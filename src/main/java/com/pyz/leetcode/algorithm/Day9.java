package com.pyz.leetcode.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day9 {


    public static void main(String[] args) {
        /* int[][] a = new int[][]{{0,1,0,1,1}, {1,1,0,0,1},{0,0,0,1,0},{1,0,1,1,1},{1,0,0,0,1}};*/
        int[][] a = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        updateMatrix(a);
    }


    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static int[][] updateMatrix(int[][] mat) {

        int m = mat.length, n = mat[0].length;
        int[][] ans = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    seen[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];
            for (int d = 0; d < 4; d++) {
                int ni = i + dx[d];
                int nj = j + dy[d];
                if (nj >= 0 && ni >= 0 && ni < m && nj < n && !seen[ni][nj]) {
                    ans[ni][nj] = ans[i][j] + 1;
                    queue.offer(new int[]{ni, nj});
                    seen[ni][nj] = true;
                }
            }
        }
        return ans;
    }

    public int orangesRotting(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        if (m == 1 && n == 1 && grid[0][0] == 0){
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        int b = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }else if (grid[i][j] == 0){
                }else {
                    b++;
                }
            }
        }

        if (queue.isEmpty()){
            if (b > 0){
                return -1;
            }
            if (b == 0){
                return 0;
            }
            return -1;
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                for (int q = 0; q < 4; q++) {
                    int px = x + dx[q], py = y + dy[q];
                    if (px >= 0 && py >= 0 && px < m && py < n && grid[px][py] == 1){
                        grid[px][py] = 2;
                        queue.offer(new int[]{px,py});
                    }
                }
            }
            index ++;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return index - 1;
    }

}
