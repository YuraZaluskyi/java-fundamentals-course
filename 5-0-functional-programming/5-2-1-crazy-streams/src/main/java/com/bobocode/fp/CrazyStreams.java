package com.bobocode.fp;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toSet;

import com.bobocode.data.Accounts;
import com.bobocode.fp.exception.EntityNotFoundException;
import com.bobocode.model.Account;
import com.bobocode.util.ExerciseNotCompletedException;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.Month;
import java.util.*;

/**
 * {@link CrazyStreams} is an exercise class. Each method represent some operation with a collection
 * of accounts that should be implemented using Stream API. Every method that is not implemented yet
 * throws {@link ExerciseNotCompletedException}.
 * <p>
 * TODO: remove exception throwing and implement each method using Stream API
 */
@AllArgsConstructor
public class CrazyStreams {

  private Collection<Account> accounts;

  /**
   * Returns {@link Optional} that contains an {@link Account} with the max value of balance
   *
   * @return account with max balance wrapped with optional
   */
  public Optional<Account> findRichestPerson() {
//        throw new ExerciseNotCompletedException();
//    return accounts.stream().max((o1, o2) -> o1.getBalance().compareTo(o2.getBalance()));
    return accounts.stream().max(Comparator.comparing(Account::getBalance));
  }

  /**
   * Returns a {@link List} of {@link Account} that have a birthday month equal to provided.
   *
   * @param birthdayMonth a month of birth
   * @return a list of accounts
   */
  public List<Account> findAccountsByBirthdayMonth(Month birthdayMonth) {
//    throw new ExerciseNotCompletedException();
    return accounts.stream().filter(i -> i.getBirthday().getMonth().equals(birthdayMonth))
        .collect(Collectors.toList());
  }

  /**
   * Returns a map that separates all accounts into two lists - male and female. Map has two keys
   * {@code true} indicates male list, and {@code false} indicates female list.
   *
   * @return a map where key is true or false, and value is list of male, and female accounts
   */
  public Map<Boolean, List<Account>> partitionMaleAccounts() {
    throw new ExerciseNotCompletedException();

  }

  /**
   * Returns a {@link Map} that stores accounts grouped by its email domain. A map key is {@link
   * String} which is an email domain like "gmail.com". And the value is a {@link List} of {@link
   * Account} objects with a specific email domain.
   *
   * @return a map where key is an email domain and value is a list of all account with such email
   */
  public Map<String, List<Account>> groupAccountsByEmailDomain() {
    throw new ExerciseNotCompletedException();
  }

  /**
   * Returns a number of letters in all first and last names.
   *
   * @return total number of letters of first and last names of all accounts
   */
  public int getNumOfLettersInFirstAndLastNames() {
//    throw new ExerciseNotCompletedException();
    return accounts.stream()
        .mapToInt(i -> i.getFirstName().length() + i.getLastName().length())
        .sum();
  }

  /**
   * Returns a total balance of all accounts.
   *
   * @return total balance of all accounts
   */
  public BigDecimal calculateTotalBalance() {
//    throw new ExerciseNotCompletedException();
    return accounts.stream().map(i -> i.getBalance()).reduce((i, j) -> i.add(j)).get();
  }

  /**
   * Returns a {@link List} of {@link Account} objects sorted by first and last names.
   *
   * @return list of accounts sorted by first and last names
   */
  public List<Account> sortByFirstAndLastNames() {
//    throw new ExerciseNotCompletedException();
    return accounts.stream()
        .sorted(Comparator.comparing(Account::getFirstName).thenComparing(Account::getLastName))
        .collect(Collectors.toList());
  }

  /**
   * Checks if there is at least one account with provided email domain.
   *
   * @return true if there is an account that has an email with provided domain
   */
  public boolean containsAccountWithEmailDomain(String emailDomain) {
//    throw new ExerciseNotCompletedException();
    return accounts.stream().anyMatch(i -> i.getEmail().split("@")[1].equals(emailDomain));

  }

  /**
   * Returns account balance by its email. Throws {@link EntityNotFoundException} with message
   * "Cannot find Account by email={email}" if account is not found.
   *
   * @param email account email
   * @return account balance
   */
  public BigDecimal getBalanceByEmail(String email) {
//    throw new ExerciseNotCompletedException();
    return accounts.stream().filter(i -> i.getEmail().equals(email))
        .findFirst()
        .orElseThrow(() -> new EntityNotFoundException("Cannot find Account by email=" + email))
        .getBalance();
  }

  /**
   * Collects all existing accounts into a {@link Map} where a key is account id, and the value is
   * {@link Account} instance
   *
   * @return map of accounts by its ids
   */
  public Map<Long, Account> collectAccountsById() {
//    throw new ExerciseNotCompletedException();
    return accounts.stream().collect(Collectors.toMap(i -> i.getId(), j -> j));
  }

  /**
   * Filters accounts by the year when an account was created. Collects account balances by its
   * emails into a {@link Map}. The key is {@link Account#email} and the value is {@link
   * Account#balance}
   *
   * @param year the year of account creation
   * @return map of account by its ids the were created in a particular year
   */
  public Map<String, BigDecimal> collectBalancesByEmailForAccountsCreatedOn(int year) {
//    throw new ExerciseNotCompletedException();
    return accounts.stream().filter(i -> i.getCreationDate().getYear() == year)
        .collect(Collectors.toMap(Account::getEmail, Account::getBalance));
  }

  /**
   * Returns a {@link Map} where key is {@link Account#lastName} and values is a {@link Set} that
   * contains first names of all accounts with a specific last name.
   *
   * @return a map where key is a last name and value is a set of first names
   */
  public Map<String, Set<String>> groupFirstNamesByLastNames() {
//    throw new ExerciseNotCompletedException();
    return accounts.stream()
        .collect(groupingBy(Account::getLastName, mapping(Account::getFirstName, toSet())));
  }

  /**
   * Returns a {@link Map} where key is a birthday month, and value is a {@link String} that stores
   * comma and space -separated first names (e.g. "Polly, Dylan, Clark"), of all accounts that have
   * the same birthday month.
   *
   * @return a map where a key is a birthday month and value is comma-separated first names
   */
  public Map<Month, String> groupCommaSeparatedFirstNamesByBirthdayMonth() {
    throw new ExerciseNotCompletedException();
  }

  /**
   * Returns a {@link Map} where key is a {@link Month} of {@link Account#creationDate}, and value
   * is total balance of all accounts that have the same value creation month.
   *
   * @return a map where key is a creation month and value is total balance of all accounts created
   * in that month
   */
  public Map<Month, BigDecimal> groupTotalBalanceByCreationMonth() {
    throw new ExerciseNotCompletedException();
  }

  /**
   * Returns a {@link Map} where key is a letter {@link Character}, and value is a number of its
   * occurrences in {@link Account#firstName}.
   *
   * @return a map where key is a letter and value is its count in all first names
   */
  public Map<Character, Long> getCharacterFrequencyInFirstNames() {
    throw new ExerciseNotCompletedException();
  }

  /**
   * Returns a {@link Map} where key is a letter {@link Character}, and value is a number of its
   * occurrences ignoring case, in all {@link Account#firstName} and {@link Account#lastName}. All
   * letters should stored in lower case.
   *
   * @return a map where key is a letter and value is its count ignoring case in all first and last
   * names
   */
  public Map<Character, Long> getCharacterFrequencyIgnoreCaseInFirstAndLastNames() {
    throw new ExerciseNotCompletedException();
  }
}

