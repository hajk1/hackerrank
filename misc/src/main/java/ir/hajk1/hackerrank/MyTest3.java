package ir.hajk1.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * given a set of n tasks, the ith  (0<=i<n ) task runs from time star[i] through end[i]. implement a task scheduler method that finds the minimum number of machines required to complete the tasks. A task can be scheduled on exactlty one machine, and the one machine can run only one task at a time
 * public static int getMinMachines(List<Integer> start, List<Integer> end) {
 */
public class MyTest3 {


    public static void main(String[] args) {
        MyTest3 mt = new MyTest3();
//        int[] start = {2, 1, 5, 5, 8};
        int[] start = {4, 2, 2, 2, 2, 2};
//        int[] end = {5, 3, 8, 6, 12};
        int[] end = {4, 5, 5, 5, 5, 2};

        System.out.println("mt = " + mt.getMinMachines(Arrays.stream(start).boxed().toList(), Arrays.stream(end).boxed().toList()));


    }

    public static int getMinMachines(List<Integer> start, List<Integer> end) {
        List<int[]> events = new ArrayList<>();
        for (int i = 0; i < start.size(); i++) {
            events.add(new int[] {start.get(i), end.get(i)});  // start event
        }
        events.sort(Comparator.comparingInt(a -> a[0]));
        List<List<int[]>> machines = new ArrayList<>();
        e:
        for (int[] event : events) {
            for (List<int[]> machine : machines) {
                if (canAccept(machine, event)) {
                    machine.add(event);
                    continue e;
                }
            }
            List<int[]> list = new ArrayList<>();
            list.add(event);
            machines.add(list);
        }

        for (List<int[]> machine : machines) {
            System.out.println("machine: ");
            machine.stream().
                map(e -> Arrays.toString(e)).
                forEach(System.out::println);
//            for (int[] ints : machine) {
//                System.out.println("Arrays.toString(ints = " + Arrays.toString(ints));
//            }
        }
        return machines.size();
    }

    private static boolean canAccept(List<int[]> machine, int[] event) {
        if (event[0] == event[1]) {
            return true;
        }
        for (int[] ints : machine) {
            if (ints[0] == ints[1]) {
                continue;
            }
            if (event[0] < ints[1]) {
                return false;
            }
        }
        return true;
    }
}
