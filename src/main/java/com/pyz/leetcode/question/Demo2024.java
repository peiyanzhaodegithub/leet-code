package com.pyz.leetcode.question;

import java.util.*;

public class Demo2024 {

    public static int maxArea(int[] height) {

        int p1 = 0;
        int p2 = height.length - 1;
        int ans = 0;

        while (p1 < p2) {

            ans = height[p1] > height[p2] ? Math.max(ans, (p2 - p1) * height[p2--]) : Math.max(ans, (p2 - p1) * height[p1++]);

        }

        return ans;

    }

    public static void rotate(int[] nums, int k) {

        int len = nums.length;
        int[] ints = new int[len];
        for (int i = 0; i < nums.length; i++) {
            ints[(i + k) % len] = nums[i];
        }

        System.arraycopy(ints, 0, nums, 0, len);
    }


    public static int maxProfit(int[] prices) {

        int ans = 0;
        int min = prices[0];
        for (int price : prices) {
            ans = Math.max(ans, price - min);
            min = Math.min(min, price);
        }

        return ans;
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> list = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {

            int l = i + 1;
            int r = n - 1;
            while (l < r) {

                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                }else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }

            }

        }
        return new ArrayList<>(list);
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }


}