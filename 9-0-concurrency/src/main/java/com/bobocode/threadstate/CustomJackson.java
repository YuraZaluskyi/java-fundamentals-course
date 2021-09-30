package com.bobocode.threadstate;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import lombok.Data;
import lombok.SneakyThrows;

public class CustomJackson {

  public static void main(String[] args) {
    var json = "{\n" +
        "  \"firstName\": \"Andrii\",\n" +
        "  \"lastName\": \"Shtramak\",\n" +
        "  \"email\": \"shtramak@gmail.com\"\n" +
        "}";

//    var user = jsonToObj(json, User.class);
//    System.out.println(user);
    User user = new User();
    jsonToObj(json, user.getClass());
  }

  @SneakyThrows
  private static <T> T jsonToObj(String json, Class<T> userClass) {
    String[] split = json.split(":");
    Class<?> aClass = Class.forName(userClass.getName());
    Constructor<?> constructor = aClass.getConstructor();
    System.out.println(Arrays.toString(split));
    return null;
  }

  @Data
  static class User {

    private String firstName;
    private String lastName;
    private String email;
  }

}
