package com.bobocode.threadstate;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Map;
import lombok.Data;
import lombok.SneakyThrows;

public class CustomJackson {

  public static void main(String[] args) {
    var json = "{\n" +
        "  \"firstName\": \"Andrii\",\n" +
        "  \"lastName\": \"Shtramak\",\n" +
        "  \"email\": \"shtramak@gmail.com\"\n" +
        "}";

    getMap(json);

//    var user = jsonToObj(json, User.class);
//    System.out.println(user);
//    User user = new User();
//    jsonToObj(json, user.getClass());
  }

  @SneakyThrows
  private static <T> T jsonToObj(String json, Class<T> userClass) {
    Constructor<T> constructor = userClass.getConstructor();
    T t = constructor.newInstance();
    return null;
  }

  private static Map<String, String> getMap(String json){
    String[] split = json.split("\n");
    System.out.println(Arrays.toString(split));
    String s = split[0];
    System.out.println(s);
    return null;
  }

  @Data
  static class User {

    private String firstName;
    private String lastName;
    private String email;
  }
}
