package ir.hajk1.hackerrank;

import java.util.Comparator;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <the description of the class for java doc by those that might use it, please use html if possible>
 */
public class HashMapFindMaxValueKey {

  private HashMap<Integer, Integer> map = new HashMap<>();

  public static void main(String[] args) {
    HashMapFindMaxValueKey hashMapMax = new HashMapFindMaxValueKey();
    hashMapMax.map.put(2, 3);
    hashMapMax.map.put(1, 0);
    hashMapMax.map.put(5, 1);
    System.out.println("hashMapMax = " + hashMapMax.findMaxIndex());
    for (Currency availableCurrency : Currency.getAvailableCurrencies()) {
      System.out.println("Currency.getAvailableCurrencies() = " + availableCurrency);
    }
    Currency currency = Currency.getInstance("IRR");
    System.out.println(currency.getSymbol());
    System.out.println(currency.getCurrencyCode());
    System.out.println(currency.getDisplayName());

  }

  private Integer findMaxIndex() {
    return map.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue))
        .map(Map.Entry::getKey).orElse(null);
  }

}
