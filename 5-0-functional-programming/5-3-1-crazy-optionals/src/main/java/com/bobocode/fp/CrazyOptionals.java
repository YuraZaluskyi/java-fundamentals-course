package com.bobocode.fp;

import com.bobocode.data.Accounts;
import com.bobocode.model.Account;
import com.bobocode.model.CreditAccount;
import com.bobocode.fp.exception.AccountNotFoundException;
import com.bobocode.fp.function.AccountProvider;
import com.bobocode.fp.function.AccountService;
import com.bobocode.fp.function.CreditAccountProvider;
import com.bobocode.util.ExerciseNotCompletedException;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

/**
 * {@link CrazyOptionals} is an exercise class. Each method represents some operation with a {@link
 * Account} and should be implemented using Optional API. Every method that is not implemented yet
 * throws {@link ExerciseNotCompletedException}.
 * <p>
 * TODO: remove exception and implement each method of this class using Optional API
 */
public class CrazyOptionals {

  /**
   * Creates an instance of {@link Optional<String>} using a text parameter
   *
   * @return optional object that holds text
   */
  public static Optional<String> optionalOfString(@Nullable String text) {
//        throw new ExerciseNotCompletedException();
    return Optional.ofNullable(text);
  }

  /**
   * Adds a provided amount of money to the balance of an optional account.
   *
   * @param amount money to deposit
   */
  public static void deposit(AccountProvider accountProvider, BigDecimal amount) {
//    throw new ExerciseNotCompletedException();
    accountProvider.getAccount().ifPresent(i -> i.setBalance(i.getBalance().add(amount)));
  }

  /**
   * Creates an instance of {@link Optional<Account>} using an account parameter
   *
   * @return optional object that holds account
   */
  public static Optional<Account> optionalOfAccount(@Nonnull Account account) {
//    throw new ExerciseNotCompletedException();
    return Optional.of(account);
  }

  /**
   * Returns the {@link Account} got from {@link AccountProvider}. If account provider does not
   * provide an account, returns a defaultAccount
   *
   * @return account from provider or defaultAccount
   */
  public static Account getAccount(AccountProvider accountProvider, Account defaultAccount) {
//    throw new ExerciseNotCompletedException();
    return accountProvider.getAccount().orElse(defaultAccount);
  }

  /**
   * Passes account to {@link AccountService#processAccount(Account)} when account is provided.
   * Otherwise calls {@link AccountService#processWithNoAccount()}
   */
  public static void processAccount(AccountProvider accountProvider,
      AccountService accountService) {
//    throw new ExerciseNotCompletedException();
    accountProvider.getAccount().ifPresentOrElse(i -> accountService.processAccount(i),
        () -> accountService.processWithNoAccount());
  }

  /**
   * Returns account provided by {@link AccountProvider}. If no account is provided it generates one
   * using {@link Accounts} Please note that additional account should not be generated if {@link
   * AccountProvider} returned one.
   *
   * @return provided or generated account
   */
  public static Account getOrGenerateAccount(AccountProvider accountProvider) {
//    throw new ExerciseNotCompletedException();
    return accountProvider.getAccount().orElseGet(Accounts::generateAccount);
  }

  /**
   * Retrieves a {@link BigDecimal} balance using null-safe mappings.
   *
   * @return optional balance
   */
  public static Optional<BigDecimal> retrieveBalance(AccountProvider accountProvider) {
//    throw new ExerciseNotCompletedException();
    return accountProvider.getAccount().map(i -> i.getBalance());
  }

  /**
   * Returns an {@link Account} provided by {@link AccountProvider}. If no account is provided,
   * throws {@link AccountNotFoundException} with a message "No Account provided!"
   *
   * @return provided account
   */
  public static Account getAccount(AccountProvider accountProvider) {
//    throw new ExerciseNotCompletedException();
    return accountProvider.getAccount()
        .orElseThrow(() -> new AccountNotFoundException("No Account provided!"));
  }

  /**
   * Retrieves a {@link BigDecimal} credit balance using null-safe mappings.
   *
   * @return optional credit balance
   */
  public static Optional<BigDecimal> retrieveCreditBalance(CreditAccountProvider accountProvider) {
//    throw new ExerciseNotCompletedException();
    return accountProvider.getAccount().flatMap(i -> i.getCreditBalance());
  }

  /**
   * Retrieves an {@link Account} with gmail email using {@link AccountProvider}. If no account is
   * provided or it gets not gmail then returns {@link Optional#empty()}
   *
   * @return optional gmail account
   */
  public static Optional<Account> retrieveAccountGmail(AccountProvider accountProvider) {
    throw new ExerciseNotCompletedException();
  }

  /**
   * Retrieves account using {@link AccountProvider} and fallbackProvider. In case main provider
   * does not provide an {@link Account} then account should ge retrieved from fallbackProvider. In
   * case both provider returns no account then {@link java.util.NoSuchElementException} should be
   * thrown.
   *
   * @return account got from either accountProvider or fallbackProvider
   */
  public static Account getAccountWithFallback(AccountProvider accountProvider,
      AccountProvider fallbackProvider) {
    return accountProvider.getAccount()
        .orElse(fallbackProvider.getAccount().orElseThrow(() -> new NoSuchElementException()));
  }

  /**
   * Returns an {@link Accounts} with the highest balance. Throws {@link
   * java.util.NoSuchElementException} if input list is empty
   *
   * @return account with the highest balance
   */
  public static Account getAccountWithMaxBalance(List<Account> accounts) {
//    throw new ExerciseNotCompletedException();
    return accounts.stream().max(Comparator.comparing(Account::getBalance))
        .orElseThrow(() -> new NoSuchElementException());
  }

  /**
   * Returns the lowest balance values or empty if accounts list is empty
   *
   * @return the lowest balance values
   */
  public static OptionalDouble findMinBalanceValue(List<Account> accounts) {
    throw new ExerciseNotCompletedException();
  }

  /**
   * Finds an {@link Account} with max balance and processes it using {@link
   * AccountService#processAccount(Account)}
   */
  public static void processAccountWithMaxBalance(List<Account> accounts,
      AccountService accountService) {
    throw new ExerciseNotCompletedException();
  }

  /**
   * Calculates a sum of {@link CreditAccount#getCreditBalance()} of all accounts
   *
   * @return total credit balance
   */
  public static double calculateTotalCreditBalance(List<CreditAccount> accounts) {
//    throw new ExerciseNotCompletedException();
    Double num = 0.0;
    Double reduce = accounts.stream().map(i -> i.getCreditBalance().get().doubleValue())
        .reduce(num, (o1, o2) -> o1 + o2);
    return reduce;
  }
}