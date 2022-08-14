package com.pyz.leetcode.datastructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day2 {


    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 3, 4, 0};
        int[] nums2 = new int[]{1};

        merge(nums1, 3, nums2, 1);
    }


    /*给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。

    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

    你可以按任意顺序返回答案。

    示例 1：
    输入：nums = [2,7,11,15], target = 9
    输出：[0,1]
    解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

    示例 2：
    输入：nums = [3,2,4], target = 6
    输出：[1,2]

    示例 3：
    输入：nums = [3,3], target = 6
    输出：[0,1]

    提示：
            2 <= nums.length <= 104
            -109 <= nums[i] <= 109
            -109 <= target <= 109
    只会存在一个有效答案*/

    public static int[] twoSum(int[] nums, int target) {

       /* int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++){
            for (int j = nums.length - 1; j > i; j--){
                if (nums[i] + nums[j] == target){
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }

        return ans;*/

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {

       /* int t = m;
        for (int i = 0; i < n; i++){
            nums1[t] = nums2[i];
            t++;
        }

        Arrays.sort(nums1);

        System.out.println(Arrays.toString(nums1));*/

        /*int[] sorted = new int[m + n];

        int m1 = 0;
        int n1 = 0;
        int c;
        while (m1 < m || n1 < n) {
            if (m1 == m) {
                c = nums2[n1++];
            }else if (n1 == n){
                c = nums1[m1++];
            }else if (nums1[m1] > nums2[n1]) {
                c = nums2[n1++];
            } else {
                c = nums1[m1++];
            }
            sorted[m1 + n1 - 1] = c;
        }
        System.arraycopy(sorted, 0, nums1, 0, n + m);*/

        int p1 = m -1;
        int p2 = n- 1;
        int l = m + n - 1;
        while (p1 >= 0 && p2 >= 0){
            if (nums1[p1] < nums2[p2]){
                nums1[l] = nums2[p2--];
            }else {
                nums1[l] = nums1[p1--];
            }
            l--;
        }

        System.arraycopy(nums2,0,nums1,0,p2 +1);
        System.out.println(Arrays.toString(nums1));
    }


}
