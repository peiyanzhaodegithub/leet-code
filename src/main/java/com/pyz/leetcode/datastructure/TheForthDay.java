package com.pyz.leetcode.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TheForthDay {

    public static void main(String[] args) {

        System.out.println(generate(5));

    }


    public static int[][] matrixReshape(int[][] mat, int r, int c) {

        if (mat.length * mat[0].length != r * c) {
            return mat;
        }

        int[][] ans = new int[r][c];
        int x = 0, y = 0;
        int len = mat.length;
        int size = mat[0].length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < size; j++) {
                ans[x][y] = mat[i][j];
                y++;
                if (y == c) {
                    x++;
                    y = 0;
                }
            }
        }
        return ans;

    }


    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            if (i == 0) {
                list.add(1);
                res.add(list);
                continue;
            } else if (i == 1) {
                list.add(1);
                list.add(1);
                res.add(list);
                continue;
            }
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    list.add(1);
                } else if (j == i) {
                    list.add(1);
                } else {
                    int r = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
                    list.add(r);
                }
            }
            res.add(list);
        }

        return res;

    }


}
