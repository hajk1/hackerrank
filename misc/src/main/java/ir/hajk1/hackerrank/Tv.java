package ir.hajk1.hackerrank;

import java.util.Arrays;
import java.util.List;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <the description of the class for java doc by those that might use it, please use html if possible>
 */
final public class Tv extends SuperTv {

  private final List<String> list;

  private Tv() {
    list = Arrays.asList("A", "B", "C");
  }

  public static void main(String[] args) {
    Tv tv = new Tv();
    tv.overrideMe();
  }

  public void overrideMe() {
    System.out.println(list);
    super.overrideMe();
  }
}

class SuperTv {

  SuperTv() {
    overrideMe();
  }

  public void overrideMe() {
    System.out.println("Hi");
  }
}
