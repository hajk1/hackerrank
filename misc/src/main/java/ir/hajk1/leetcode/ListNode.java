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
