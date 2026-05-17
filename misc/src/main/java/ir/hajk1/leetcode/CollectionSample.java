package ir.hajk1.leetcode;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class CollectionSample {

    public static void main(String[] args) {
//        testQueue();
        testArrayDeque();

    }

    private static void testArrayDeque() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(4);
        queue.add(3);
        queue.add(4);
        queue.add(1);
        queue.add(5);
        queue.offer(6);
        queue.add(7);
        System.out.println("queue = " + queue);
        queue.poll();
        queue.remove();
        System.out.println("queue = " + queue);
    }

    private static void testQueue() {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(4);
        queue.add(3);
        queue.add(4);
        queue.add(1);
        queue.add(5);
        System.out.println("queue = " + queue);
        queue.poll();
        System.out.println("queue = " + queue);
    }


}
