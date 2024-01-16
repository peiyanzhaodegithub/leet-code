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
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }

            }

        }
        return new ArrayList<>(list);
    }


    /*public static int maxProfit2(int[] prices) {

        int ans = 0;
        int len = prices.length;
        int minP = 0;
        while (minP < len) {
            int tempAns = 0;
            int tempMinp = minP;
            for (int j = tempMinp + 1; j < len; j++) {
                if (prices[tempMinp] >= prices[j]) {
                    continue;
                }
                tempAns = tempAns + (prices[j] - prices[tempMinp]);
                tempMinp = j + 1;
            }

            ans = Math.max(tempAns, ans);
            minP++;
        }

        return ans;
    }*/

    public static int maxProfit2(int[] prices) {

        if (prices == null || prices.length <= 1) return 0;

        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                ans += (prices[i] - prices[i - 1]);
            }
        }

        return ans;

    }

    public int trap(int[] height) {

        int ans = 0;
        int len = height.length;
        if (len < 3) return 0;
        int[] leftMaxArr = new int[len];
        int[] rightMaxArr = new int[len];
        leftMaxArr[0] = height[0];
        rightMaxArr[len - 1] = height[len-1];
        for (int i = 1; i < len; i++) {
            leftMaxArr[i] = Math.max(leftMaxArr[i -1], height[i]);
        }

        for (int i = len -2; i >= 0; i--) {
            rightMaxArr[i] = Math.max(rightMaxArr[i + 1], height[i]);
        }

        for (int i = 0; i < len; i++) {
            ans += Math.min(leftMaxArr[i], rightMaxArr[i]) - height[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit2(new int[]{6, 1, 3, 2, 4, 7}));
    }


}