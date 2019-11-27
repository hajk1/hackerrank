package ir.hajk1.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <the description of the class for java doc by those that might use it, please use html if possible>
 */
public class ReversePolishNotation {

  public static void main(String[] args) {
    System.out.println(calculateReversePolishNotation("2 1 3.5"));
    System.out.println(calculateReversePolishNotation("10000 123 +"));
    System.out.println(calculateReversePolishNotation("5 1 2 + 4 * + 3 -"));
  }

  static double calculateReversePolishNotation(String expression) {
    if (expression == null || expression.length() == 0) {
      return 0;
    }
    Stack<Double> floatStack = new Stack<>();
    Map<String, BiFunction<Double, Double, Double>> operatorsMap = new HashMap<>();
    operatorsMap.put("+", (a, b) -> a + b);
    operatorsMap.put("-", (a, b) -> b - a);
    operatorsMap.put("/", (a, b) -> b / a);
    operatorsMap.put("*", (a, b) -> a * b);

    String[] strings = expression.split(" ");
    for (String s : strings) {
      if (!operatorsMap.containsKey(s)) {
        floatStack.push(new Double(s));
      } else {
        floatStack.push(operatorsMap.get(s).apply(floatStack.pop(), floatStack.pop()));
      }
    }

    return floatStack.peek();
  }


}
