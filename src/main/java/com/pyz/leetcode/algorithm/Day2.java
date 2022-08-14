package com.pyz.leetcode.algorithm;

import java.util.Arrays;
import java.util.Collections;

public class Day2 {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};

        System.out.println(Arrays.toString(rotate(nums, 4)));
    }


    /*给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。

    示例 1：
    输入：nums = [-4,-1,0,3,10]
    输出：[0,1,9,16,100]
    解释：平方后，数组变为 [16,1,0,9,100]
    排序后，数组变为 [0,1,9,16,100]

    示例 2：
    输入：nums = [-7,-3,2,3,11]
    输出：[4,9,9,49,121]

    提示：
            1 <= nums.length <= 104
            -104 <= nums[i] <= 104
    nums 已按 非递减顺序 排序*/

    public static int[] sortedSquares(int[] nums) {

        /*int len = nums.length;
        for (int i = 0; i<len;i++){
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);

        return nums;*/

        int neg = -1;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) {
                neg = i;
            } else {
                break;
            }
        }

        int[] ans = new int[len];
        int index = 0, i = neg, j = neg + 1;

        while (i >= 0 || j < len) {
            if (i < 0) {
                ans[index] = nums[j] * nums[j];
                j++;
            } else if (j == len) {
                ans[index] = nums[i] * nums[i];
                i--;
            } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
                ans[index] = nums[i] * nums[i];
                i--;
            } else {
                ans[index] = nums[j] * nums[j];
                j++;
            }
            index++;
        }

        return ans;
    }


    /*给你一个数组，将数组中的元素向右轮转 k个位置，其中k是非负数。

    示例 1:
    输入: nums = [1,2,3,4,5,6,7], k = 3
    输出: [5,6,7,1,2,3,4]
    解释:
    向右轮转 1 步: [7,1,2,3,4,5,6]
    向右轮转 2 步: [6,7,1,2,3,4,5]
    向右轮转 3 步: [5,6,7,1,2,3,4]

    示例 2:
    输入：nums = [-1,-100,3,99], k = 2
    输出：[3,99,-1,-100]
    解释:
    向右轮转 1 步: [99,-1,-100,3]
    向右轮转 2 步: [3,99,-1,-100]

    提示：
            1 <= nums.length <= 105
            -231 <= nums[i] <= 231 - 1
            0 <= k <= 105*/

    public static int[] rotate(int[] nums, int k) {

        if (k == 0 || nums.length <= 1 || k == nums.length) {
            return nums;
        }

        int[] c = Arrays.copyOf(nums, nums.length);
        int index = 0;
        if (k > nums.length) {
            k = k % nums.length;
        }

        for (int i = nums.length - k; i < nums.length; i++) {
            nums[index] = c[i];
            index++;
        }

        for (int i = 0; i < nums.length - k; i++) {
            nums[index] = c[i];
            index++;
        }

        return nums;

    }


}
