package com.pyz.leetcode.question.domain;

public class NumArray {

    int[] numArray;

    public NumArray(int[] nums) {

        numArray = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            numArray[i+1] = numArray[i] + nums[i];
        }

    }

    public int sumRange(int left, int right) {
        return numArray[right+1]-numArray[left];
    }
}
