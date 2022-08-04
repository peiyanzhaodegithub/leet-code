package com.pyz.leetcode.datastructure;

import java.util.*;
import java.util.stream.Collectors;

public class FirstDay {


    /*给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。

    示例 1：
    输入：nums = [1,2,3,1]
    输出：true

    示例 2：
    输入：nums = [1,2,3,4]
    输出：false

    示例 3：
    输入：nums = [1,1,1,3,3,4,3,2,4,2]
    输出：true

    提示：
            1 <= nums.length <= 105
            -109 <= nums[i] <= 109*/

    public static boolean containsDuplicate(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)){
                return true;
            }else {
                map.put(num,0);
            }
        }

        return false;
    }


    /*给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

    子数组 是数组中的一个连续部分。

    示例 1：
    输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
    输出：6
    解释：连续子数组[4,-1,2,1] 的和最大，为6 。

    示例 2：
    输入：nums = [1]
    输出：1

    示例 3：
    输入：nums = [5,4,-1,7,8]
    输出：23

    提示：
            1 <= nums.length <= 105
            -104 <= nums[i] <= 104*/
    //动态规划
    public static int maxSubArray(int[] nums) {

        int max = nums[0];
        int pre = 0;

        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(pre, max);
        }

        return max;
    }




}
