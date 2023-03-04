package ir.hajk1.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringSearch {

  public static List<List<String>> getProductSuggestion(List<String> products, String search) {
    List<List<String>> result = new ArrayList<>();
    for (int i = 1; i <= search.length(); i++) {
      String pre = search.substring(0, i);
      List<String> tmpList = new ArrayList<>();
      for (String product : products) {
        if (product.startsWith(pre)) {
          tmpList.add(product);
        }

      }
      if (tmpList.size() > 0) {
        result.add(tmpList.stream().sorted().limit(3).collect(Collectors.toList()));
      }
    }

    return result;
  }

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("carpet");
    list.add("cart");
    list.add("car");
    list.add("camera");
    list.add("crate");

    System.out.println(getProductSuggestion(list, "camera"));

  }

}
