package ir.hajk1.leetcode;

import java.util.HashMap;
import java.util.Map;

public class AllOne2 {

    Node head;
    Node tail;
    Map<String, Node> map = new HashMap<>();
    public AllOne2() {

    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            Node tmp = map.get(key);
            tmp.count++;
            if (tmp != tail) {
                Node next = tmp.next;
                while (next != null && next.count < tmp.count) {
                    swapRight(tmp, next);
                    next = tmp.next;
                }
            }
        } else {
            Node tmp = new Node(key, 1, head, null);
            if (head != null)
                head.previous = tmp;
            head = tmp;
            map.put(key, tmp);
        }
        if (tail == null)
            tail = head;
    }

    private void swapRight(Node left, Node right) {
        left.next = right.next;
        right.previous = left.previous;
        Node leftPre = left.previous;
        if (leftPre != null)
            leftPre.next = right;
        left.previous = right;
        Node rightNext = right.next;
        if (rightNext != null)
            rightNext.previous = left;
        right.next = left;
        if (right.previous == null)
            head = right;
        if (left.next == null)
            tail = left;
    }

    public void dec(String key) {
        Node tmp = map.get(key);
        tmp.count--;
        if (tmp.count == 0) {
            safeRemoveNode(tmp);
        } else {
            if (tmp != head) {
                Node left = tmp.previous;
                while (left != null && left.count > tmp.count) {
                    swapRight(left, tmp);
                    left = tmp.previous;
                }
            }
        }
        if (head == null)
            head = tail;

    }

    private void safeRemoveNode(Node tmp) {
        if (tmp == head)
            head = tmp.next;
        if (tmp == tail)
            tail = tmp.previous;
        if (tmp.previous != null)
            tmp.previous.next = tmp.next;
        if (tmp.next != null)
            tmp.next.previous = tmp.previous;
        map.remove(tmp.value);
    }

    public String getMaxKey() {
        if (map.keySet().size() == 0)
            return "";
        return tail.value;
    }

    public String getMinKey() {
        if (map.keySet().size() == 0)
            return "";
        return head.value;
    }

    class Node {
        Integer count;
        String value;
        Node next;
        Node previous;

        public Node(String value, Integer count, Node next, Node previous) {
            this.value = value;
            this.count = count;
            this.next = next;
            this.previous = previous;
        }
    }
}
