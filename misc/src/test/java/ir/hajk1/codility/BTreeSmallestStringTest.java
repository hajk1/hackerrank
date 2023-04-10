package ir.hajk1.codility;

import ir.hajk1.leetcode.BTreeSmallestString;
import ir.hajk1.leetcode.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class BTreeSmallestStringTest {
    @Test
    void test_0() {
        Integer[] list = new Integer[]{0, 1, 2, 3, 4, 3, 4};
        test(list, "dba");
    }

    @Test
    void test_1() {
        Integer[] list = new Integer[]{25, 1, 3, 1, 3, 0, 2};
        test(list, "adz");
    }

    @Test
    void test_2() {
        Integer[] list = new Integer[]{2, 2, 1, null, 1, 0, null, 0};
        test(list, "abc");
    }

    @Test
    void test_3() {
        Integer[] list = new Integer[]{4, 0, 1, 1};
        test(list, "bae");
    }


    private void test(Integer[] list, String result) {
        TreeNode treeNode = generateBTree(list);
        BTreeSmallestString solution = new BTreeSmallestString();
        Assertions.assertEquals(result, solution.smallestFromLeaf(treeNode));
    }

    private TreeNode generateBTree(Integer[] arr) {

        if (arr == null || arr.length == 0) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode curr = queue.poll();

            Integer leftVal = arr[i++];
            if (leftVal != null) {
                curr.setLeft(new TreeNode(leftVal));
                queue.offer(curr.getLeft());
            }

            if (i < arr.length) {
                Integer rightVal = arr[i++];
                if (rightVal != null) {
                    curr.setRight(new TreeNode(rightVal));
                    queue.offer(curr.getRight());
                }
            }
        }

        return root;
    }


}
