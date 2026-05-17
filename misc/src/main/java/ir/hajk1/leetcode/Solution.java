package ir.hajk1.leetcode;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.splitArray(new int[] {7, 2, 5, 10, 8}, 2));
    }

    public int splitArray(int[] nums, int m) {
        int low = 0;
        int high = 0;
        for (int num : nums) {
            high += num;
            low = Math.max(low, num);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canSplit(nums, m, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;


    }

    private boolean canSplit(int[] nums, int m, int mid) {
        int sum = 0;
        int parts = 1;
        for (int num : nums) {
            sum += num;
            if (sum > mid) {
                sum = num;
                parts++;
            }
        }
        return parts <= m;
    }
}