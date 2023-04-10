package ir.hajk1.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BTreeSmallestString {

    public String smallestFromLeaf(TreeNode root) {
        if (root.left == null && root.right == null) {
            return (char) (root.val + 'a') + "";
        }
        Set<String> result = new TreeSet<>();
        if (root.left != null) {
            List<String> left = getAllPath(root.left);
            for (String s : left) {
                result.add(s + (char) (root.val + 'a'));
            }
        }
        if (root.right != null) {
            List<String> right = getAllPath(root.right);
            for (String s : right) {
                result.add(s + (char) (root.val + 'a'));
            }
        }
        return result.stream().findFirst().get();
    }

    public List<String> getAllPath(TreeNode node) {
        List<String> list = new ArrayList<>();
        if (node.left == null && node.right == null) {
            list.add((char) (node.val + 'a') + "");
            return list;
        }
        if (node.left != null) {
            List<String> left = getAllPath(node.left);
            for (String s : left) {
                list.add(s + (char) (node.val + 'a'));
            }
        }
        if (node.right != null) {
            List<String> right = getAllPath(node.right);
            for (String s : right) {
                list.add(s + (char) (node.val + 'a'));
            }
        }
        return list;
    }
}
