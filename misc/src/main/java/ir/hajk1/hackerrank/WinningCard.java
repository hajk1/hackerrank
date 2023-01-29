package ir.hajk1.hackerrank;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/*
Winning card is the biggest number which is unique
The tricky part is there might be a big number that would be repeated in the future
so we must keep the history of big numbers to be able to switch next big one when the biggest loose it's
position as a leader
 */
public class WinningCard {
    public static void main(String[] args) {
        int[][] test = {{1, 2, 3, 9}, {1, 2, 3, 8, 9}};
        SortedSet<Integer> sortedSet = new TreeSet<>();
        int res = -1;
        Set<Integer> set = new HashSet<>();
        for (int[] ints : test) {
            for (int anInt : ints) {
                if (set.add(anInt)) {
                    if (res < anInt)
                        res = anInt;
                    sortedSet.add(anInt);
                } else {
                    sortedSet.remove(anInt);
                }
            }
        }
        System.out.println("res = " + sortedSet.last()
        );
    }
}
