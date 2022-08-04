package com.pyz.leetcode.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OnTheThirdDay {


    public static void main(String[] args) {
        int[] num1 = new int[]{3,2,2,3};
        // int[] num2 = new int[]{9, 4, 9, 8, 4};

    }

    /*给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。

    示例 1：

    输入：nums1 = [1,2,2,1], nums2 = [2,2]
    输出：[2,2]
    示例 2:

    输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    输出：[4,9]

    提示：
            1 <= nums1.length, nums2.length <= 1000
            0 <= nums1[i], nums2[i] <= 1000*/

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        int[] ans = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int index = 0;
        for (int i : nums2) {
            Integer integer = map.get(i);
            if (integer != null) {
                ans[index] = i;
                index++;
                if (integer == 1) {
                    map.remove(i);
                } else {
                    map.put(i, integer - 1);
                }
            }
        }
        return Arrays.copyOfRange(ans, 0, index);
    }

    /*给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。

    你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。

    返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

    示例 1：
    输入：[7,1,5,3,6,4]
    输出：5
    解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
    注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。

    示例 2：
    输入：prices = [7,6,4,3,1]
    输出：0
    解释：在这种情况下, 没有交易完成, 所以最大利润为 0。

    提示：
            1 <= prices.length <= 105
            0 <= prices[i] <= 104*/

    public int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        int min = Arrays.stream(prices).max().getAsInt();
        int max = 0;

        for (int price : prices) {
            if (price < min) {
                min = price;
            } else if (price - min > max) {
                max = price - min;
            }
        }

        return max;
    }




}


