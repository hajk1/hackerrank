package ir.hajk1.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotatingMatrix {

    static int m;
    static int n;

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        // Write your code here
        m = matrix.size();
        n = matrix.get(0).size();
        r = remainder(m, n, r);
//        System.out.println("r = " + r+" ");

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                int[] index = iterateThis(x, y, r);
                System.out.print(matrix.get(index[1]).get(index[0]) + " ");
            }
            System.out.println();
        }
    }

    private static int[] iterateThis(int x, int y, int r) {
        int xMin = Math.min(x, Math.abs(n - 1 - x));
        int yMin = Math.min(y, Math.abs(m - 1 - y));
        int threshold = Math.min(xMin, yMin);
        boolean reverseX = (y == m - 1 - threshold);
        boolean reverseY = (x == threshold && y > threshold);
        while (r > 0) {
            if (reverseX) {
                if (x > threshold) {
                    x--;
                } else {
                    y--;
                    reverseX = false;
                    reverseY = true;
                }
            } else if (reverseY) {
                if (y > threshold) {
                    y--;
                } else {
                    x++;
                    reverseY = false;
                }
            } else if (x < (n - 1 - threshold)) {
                x++;
            } else if (y < (m - 1 - threshold)) {
                y++;
            } else {
                reverseX = true;
                x--;
            }
            r--;
        }
        return new int[] {x, y};
    }

    private static int remainder(int x, int y, int r) {
        int s = ((x + y) * 2) - 4;
        if (s > 0) {
            return r % s;
        } else {
            return r;
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test3() {
//        1 1
//        1 1
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(new Integer[] {1, 1}));
        list.add(Arrays.asList(new Integer[] {1, 1}));
        matrixRotation(list, 3);
    }

    private static void test2() {
//        28 27 26 25
//        22 9 15 19
//        16 8 21 13
//        10 14 20 7
//        4 3 2 1
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(new Integer[] {1, 2, 3, 4}));
        list.add(Arrays.asList(new Integer[] {7, 8, 9, 10}));
        list.add(Arrays.asList(new Integer[] {13, 14, 15, 16}));
        list.add(Arrays.asList(new Integer[] {19, 20, 21, 22}));
        list.add(Arrays.asList(new Integer[] {25, 26, 27, 28}));
        matrixRotation(list, 7);

    }

    private static void test1() {
//        3 4 8 12
//        2 11 10 16
//        1 7 6 15
//        5 9 13 14
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(new Integer[] {1, 2, 3, 4}));
        list.add(Arrays.asList(new Integer[] {5, 6, 7, 8}));
        list.add(Arrays.asList(new Integer[] {9, 10, 11, 12}));
        list.add(Arrays.asList(new Integer[] {13, 14, 15, 16}));
        matrixRotation(list, 13);
    }
}
