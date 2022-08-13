package com.pyz.leetcode.algorithm;

import java.sql.PreparedStatement;
import java.util.*;

public class Day11 {

    public static void main(String[] args) {
        combine(4, 2);
    }

    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {

        back(n, k, 1);

        return result;
    }

    private static void back(int n, int k, int startIndex) {

        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n; i++) {

            path.add(i);

            back(n, k, i + 1);

            path.remove(path.size() - 1);
        }

    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return result;
        }
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();
        pback(nums, len, 0, path, used, result);

        return result;

    }

    public static void pback(int[] nums, int len, int depth, Deque<Integer> ppath, boolean[] used, List<List<Integer>> result) {

        if (depth == len) {
            result.add(new ArrayList<>(ppath));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            ppath.addLast(nums[i]);
            used[i] = true;
            pback(nums, len, depth + 1, ppath, used, result);
            ppath.remove(ppath.size() - 1);
        }

    }


}
