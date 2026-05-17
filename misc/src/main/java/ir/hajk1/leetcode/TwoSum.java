package ir.hajk1.leetcode;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(new int[] {2, 7, 11, 15}, 9);
        System.out.println("result = " + result[0] + " " + result[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        int i = 0, j = 1;

        while (i <= nums.length - 2 && j <= nums.length - 1) {

            if (nums[i] + nums[j] == target) {
                result[0] = i;
                result[1] = j;
                break;
            }
            if (j == nums.length - 1) {
                i++;
                j = i + 1;
            } else {
                j++;
            }

        }
        return result;
    }
}
