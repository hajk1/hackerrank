package ir.hajk1.leetcode;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = new ListNode();
            ListNode tmp = result;
            while (l1 != null || l2 != null) {
                int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + tmp.val;
                tmp.val = ((sum) % 10);
                if (sum / 10 > 0)
                    tmp.next = new ListNode(sum / 10);
                else {
                    if ((l1 != null && l1.next != null) || (l2 != null && l2.next != null))
                        tmp.next = new ListNode();
                }
                l1 = (l1 != null ? l1.next : null);
                l2 = (l2 != null ? l2.next : null);
                tmp = tmp.next;
            }
            return result;
        }

        public ListNode addTwoNumbers_v2(ListNode l1, ListNode l2) {
            int parity = 0;
            int sum = l1.val + l2.val;
            ListNode result = new ListNode(sum % 10);
            ListNode current = result;
            ;
            parity = sum / 10;

            while (l1.next != null || l2.next != null || parity > 0) {
                int l1tmp = 0, l2tmp = 0;
                if (l1.next != null) {
                    l1 = l1.next;
                    l1tmp = l1.val;
                }
                if (l2.next != null) {
                    l2 = l2.next;
                    l2tmp = l2.val;
                }
                sum = l1tmp + l2tmp + parity;
                ListNode tmp = new ListNode(sum % 10);
                current.next = tmp;
                current = current.next;
                parity = sum / 10;

            }
            return result;

        }
    }


    private static ListNode initL(int n1, int n2, int n3) {
        ListNode l = new ListNode(n3);
        ListNode l2 = new ListNode(n2, l);
        return new ListNode(n1, l2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println("s = " + s.addTwoNumbers(initL(2, 4, 3), initL(5, 6, 4)));
    }
}
