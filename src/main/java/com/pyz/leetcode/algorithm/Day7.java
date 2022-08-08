package com.pyz.leetcode.algorithm;

import java.util.*;

/**
 * @Author: peiyanzhao
 * @DateTime: 2022/8/7 12:30
 * @Description: TODO
 */
public class Day7 {


    public static void main(String[] args) {
        int[][] p = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland(p));
    }


    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};


    public static int maxAreaOfIsland(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        int ans = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++){

            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1) {
                    int curr = 1;
                    grid[i][j] = 0;
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int x = cell[0], y = cell[1];

                        for (int r = 0; r < 4; r++){
                            int mx = x + dx[r];
                            int my = y + dy[r];
                            if (mx >= 0 && my >= 0 && mx < m && my < n && grid[mx][my] == 1){
                                queue.offer(new int[]{mx, my});
                                curr++;
                                grid[mx][my] = 0;
                            }
                        }

                    }
                    ans = Math.max(ans, curr);
                }

            }

        }

       return ans;

    }


    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int currColor = image[sr][sc];
        if (currColor == newColor) {
            return image;
        }

        int m = image.length, n = image[0].length;
        image[sr][sc] = newColor;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && my >= 0 && mx < m && my < n && image[mx][my] == currColor) {
                    image[mx][my] = newColor;
                    queue.offer(new int[]{mx, my});
                }
            }
        }

        return image;


















       /* int currColor = image[sr][sc];
        if (currColor == newColor) {
            return image;
        }
        int n = image.length, m = image[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < n && my >= 0 && my < m && image[mx][my] == currColor) {
                    queue.offer(new int[]{mx, my});
                    image[mx][my] = newColor;
                }
            }
        }
        return image;*/


    }


}
