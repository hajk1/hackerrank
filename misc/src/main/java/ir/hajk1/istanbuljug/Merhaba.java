package ir.hajk1.istanbuljug;

import java.util.HashSet;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <the description of the class for java doc by those that might use it, please use html if possible>
 */
public class Merhaba {

  private final char birinci;

  public Merhaba(char birinci) {
    this.birinci = birinci;
  }

  public static void main(String[] args) {
    HashSet<Merhaba> s = new HashSet<>();
    for (int i = 0; i < 10; i++) {
      for (char ch = 'a'; ch <= 'z'; ch++) {
        s.add(new Merhaba(ch));
      }
    }
    System.out.println("s.size() = " + s.size());
  }

  public boolean equals(Merhaba b) {
    return b.birinci == birinci;
  }

  @Override
  public int hashCode() {
    return 31 * birinci;
  }
}
