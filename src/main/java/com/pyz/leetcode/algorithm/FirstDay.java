package com.pyz.leetcode.algorithm;

public class FirstDay {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,5,7,8,9};
        System.out.println(searchInsert(nums, 0));
    }

    /*  给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
    示例 1:
    输入: nums = [-1,0,3,5,9,12], target = 9
    输出: 4
    解释: 9 出现在 nums 中并且下标为 4

    示例 2:
    输入: nums = [-1,0,3,5,9,12], target = 2
    输出: -1
    解释: 2 不存在 nums 中因此返回 -1

    提示：
    你可以假设 nums中的所有元素是不重复的。
    n将在[1, 10000]之间。
    nums的每个元素都将在[-9999, 9999]之间。*/

    // 二分查找
    public static int one(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int min = left + (right - left) / 2;
            if (nums[min] == target) {
                return min;
            } else if (target > nums[min]) {
                left = min + 1;
            } else if (target < nums[min]) {
                right = min - 1;
            }
        }

        return -1;
    }


    /*你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。

    假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。

    你可以通过调用bool isBadVersion(version)接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。

    示例 1：

    输入：n = 5, bad = 4
    输出：4
    解释：
    调用 isBadVersion(3) -> false
    调用 isBadVersion(5)-> true
    调用 isBadVersion(4)-> true
    所以，4 是第一个错误的版本。
    示例 2：

    输入：n = 1, bad = 1
    输出：1

    提示：1 <= bad <= n <= 231 - 1
*/

    public static int firstBadVersion(int n) {

        int i = 1;
        int j = n;

        while (i <= j) {
            int min = i + (j - i) / 2;

            if (isBadVersion(min)) {
                j = min - 1;
            } else {
                i = min + 1;
            }
        }

        return i;

    }

    public static boolean isBadVersion(int v) {
        return v == 5;
    }


    /*给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

    请必须使用时间复杂度为 O(log n) 的算法。

    示例 1:
    输入: nums = [1,3,5,6], target = 5
    输出: 2

    示例2:
    输入: nums = [1,3,5,6], target = 2
    输出: 1

    示例 3:
    输入: nums = [1,3,5,6], target = 7
    输出: 4

    提示:
            1 <= nums.length <= 104
            -104 <= nums[i] <= 104
    nums 为无重复元素的升序排列数组
-104 <= target <= 104*/

    public static int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int min = 0;
        while (left <= right) {

            min = left + (right - left) / 2;
            if (nums[min] == target) {
                return min;
            } else if (target > nums[min]) {
                left = min + 1;
            } else if (target < nums[min]) {
                right = min - 1;
            }

        }

        return target > nums[min] ? min + 1 : min;
    }







}
