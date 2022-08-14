package com.pyz.leetcode.datastructure;

import java.util.*;
import java.util.stream.Collectors;

public class Day3 {


    public static void main(String[] args) {
        int[] num1 = new int[]{3,2,2,3};
        // int[] num2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(removeElement(num1,3));
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


    /*给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

    请注意，必须在不复制数组的情况下原地对数组进行操作。

    示例 1:
    输入: nums = [0,1,0,3,12]
    输出: [1,3,12,0,0]

    示例 2:
    输入: nums = [0]
    输出: [0]*/

    public static void moveZeroes(int[] nums) {
        if (nums.length == 0) return;

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j++] = t;
            }
        }
        System.out.println(Arrays.toString(nums));

    }

    /*给你一个下标从 1 开始的整数数组numbers ，该数组已按 非递减顺序排列 ，请你从数组中找出满足相加之和等于目标数target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。

    以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。

    你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。

    你所设计的解决方案必须只使用常量级的额外空间。


    示例 1：

    输入：numbers = [2,7,11,15], target = 9
    输出：[1,2]
    解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
    示例 2：

    输入：numbers = [2,3,4], target = 6
    输出：[1,3]
    解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。
    示例 3：

    输入：numbers = [-1,0], target = -1
    输出：[1,2]
    解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。


    提示：

            2 <= numbers.length <= 3 * 104
            -1000 <= numbers[i] <= 1000
    numbers 按 非递减顺序 排列
-1000 <= target <= 1000
    仅存在一个有效答案*/

    public static int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            if (numbers[left] + numbers[right] == target){
                return new int[]{left, right};
            }else if (numbers[left] + numbers[right] > target){
                right--;
            }else {
                left++;
            }
        }

        return new int[]{-1,-1};
    }


    public static int removeElement(int[] nums, int val) {

        int slow = 0;
        int index = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val){
                int t = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = t;
                slow++;
                index++;
            }
        }

        return index;
    }

    public int removeDuplicates(int[] nums) {

        int slow = 0;
        int index = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]){
                int t = nums[fast];
                nums[slow + 1] = t;
                slow++;
                index++;
            }
        }

        return index;
    }


}


