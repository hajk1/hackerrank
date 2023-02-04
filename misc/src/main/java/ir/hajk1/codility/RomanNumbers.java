package ir.hajk1.codility;

import java.util.HashMap;
import java.util.Map;

/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

 */
public class RomanNumbers {
    public static void main(String[] args) {
        RomanNumbers romanNumbers = new RomanNumbers();
        System.out.println("romanNumbers.romanToInt() = " + romanNumbers.romanToInt("III"));
        System.out.println("romanNumbers.romanToInt() = " + romanNumbers.romanToInt("LVIII"));
        System.out.println("romanNumbers.romanToInt() = " + romanNumbers.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        int result = 0;
        Character last = null;
        Map<Character, Integer> map = new HashMap<>();
        initMap(map);
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            result += map.get(c);
            if (last != null) {
                if (map.get(c) > map.get(last)) {
                    result -= (2 * map.get(last));
                }
            }
            last = c;
        }
        return result;
    }

    private void initMap(Map<Character, Integer> map) {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
}
