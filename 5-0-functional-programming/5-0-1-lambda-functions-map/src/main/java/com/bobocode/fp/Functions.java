package com.bobocode.fp;

public class Functions {

  /**
   * A static factory method that creates an integer function map with basic functions: - abs
   * (absolute value) - sgn (signum function) - increment - decrement - square
   *
   * @return an instance of {@link FunctionMap} that contains all listed functions
   */
  public static FunctionMap<Integer, Integer> intFunctionMap() {
    // todo: add simple functions to the function map (abs, sgn, increment, decrement, square)
    FunctionMap<Integer, Integer> intFunctionMap = new FunctionMap<>();
    intFunctionMap.addFunction("abs", i -> i >= 0 ? i : -i);
    intFunctionMap.addFunction("sgn", i -> {
      if (i == 0) {
        return 0;
      } else if (i < 0) {
        return -1;
      }
      return 1;
    });
    intFunctionMap.addFunction("increment", i -> i + 1);
    intFunctionMap.addFunction("decrement", i -> i - 1);
    intFunctionMap.addFunction("square", i -> i * i);
    return intFunctionMap;
  }
}
