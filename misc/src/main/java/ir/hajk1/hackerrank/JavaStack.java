package ir.hajk1.hackerrank;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <the description of the class for java doc by those that might use it, please use html if possible>
 */
public class JavaStack {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (sc.hasNext()) {
      String input = sc.next();
      //Complete the code
      boolean balanced = true;
      Stack<Character> stack = new Stack();
      HashMap<Character, Character> map = new HashMap<>();
      map.put('(', ')');
      map.put('[', ']');
      map.put('{', '}');
      for (char ch : input.toCharArray()) {
        if (ch == '(' || ch == '[' || ch == '{') {
          stack.push(ch);
        } else {
          if (stack.isEmpty()) {
            balanced = false;
            break;
          }
          char last = stack.pop();
          Character enclosingCharacter = map.get(last);
          if (enclosingCharacter == null || !enclosingCharacter.equals(ch)) {
            balanced = false;
            break;
          }
        }
      }
      if (!stack.empty()) {
        balanced = false;
      }
      System.out.println(balanced ? "true" : "false");
    }
  }

}
