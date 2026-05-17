package ir.hajk1.leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Zigzag {

    public static void main(String[] args) {
        Zigzag zigzag = new Zigzag();
        System.out.println("zigzag.convert(\"PAYPALISHIRING\", 3) = " + zigzag.convert("PAYPALISHIRING", 3));
        System.out.println("zigzag.convert(\"PAYPALISHIRING\", 4) = " + zigzag.convert("PAYPALISHIRING", 4));
        System.out.println("zigzag.convert(\"A\", 1) = " + zigzag.convert("A", 1));
    }

    public String convert(String s, int numRows) {
        List<Character>[] rows = new List[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new ArrayList<>();
        }
        int zigzag = numRows - 1;
        int rowIndex = 0;
        boolean increase = false;
        for (int i = 0; i < s.length(); i++) {

            if (zigzag == 0 || zigzag == numRows - 1) {
                rows[rowIndex].add(s.charAt(i));
                rowIndex++;
            } else {
                rows[zigzag].add(s.charAt(i));
                rowIndex = 0;
                if (increase) {
                    zigzag++;
                } else {
                    zigzag--;
                }
            }

            if (rowIndex == numRows) {
                rowIndex = 0;
                zigzag = numRows - 2;
            }

            if (zigzag < 0) {
                zigzag = 0;
                increase = true;
            } else if (zigzag == numRows) {
                zigzag--;
                increase = false;
            }
        }

        String result = generateResult(rows);
        return result;
    }

    String generateResult(List<Character>[] rows) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows.length; i++) {
            List<Character> chars = rows[i];
            System.out.println("chars.stream() = " + chars.stream().map(String::valueOf).collect(Collectors.joining()));
            for (int j = 0; j < chars.size(); j++) {
                sb.append(("" + chars.get(j)));
            }
        }
        return sb.toString();
    }
}
