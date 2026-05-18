package ir.hajk1.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MaximumSubarraySum {

    public static void main(String[] args) {
        MaximumSubarraySum maximumSubarraySum = new MaximumSubarraySum();
        System.out.println(maximumSubarraySum.maximumSubarraySum(new int[] {1, 5, 4, 2, 9}, 3));
        System.out.println(maximumSubarraySum.maximumSubarraySum(new int[] {1, 1, 1, 1, 1, 1, 1}, 1));
        System.out.println(maximumSubarraySum.maximumSubarraySum(new int[] {1, 5, 4, 2, 9, 9, 9}, 3));
        System.out.println(maximumSubarraySum.maximumSubarraySum(new int[] {4, 4, 4}, 3));
    }

    public int maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int maxSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                left++;
            }

            set.add(nums[right]);
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, set.stream().mapToInt(i -> i).sum());
                set.remove(nums[left]);
                left++;
            }

        }
        return maxSum;
    }

}
