package com.pyz.leetcode.datastructure;

import java.util.*;

public class TheFifthDay {

    public static void main(String[] args) {
        int[][] board = {
                  {0,1,2,0}
                , {3,4,5,2}
                , {1,3,1,5}
        };
        setZeroes(board);
    }


    public static boolean isValidSudoku(char[][] board) {

        int[][] rows = new int[9][9];//用数组同样实现
        int[][] columns = new int[9][9];
        int[][][] boxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    rows[i][index]++;
                    columns[j][index]++;
                    boxes[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || boxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;



       /* Map<Character, Character> map1 = new HashMap<>();
        Map<Integer, List<Character>> map2 = new HashMap<>();
        Map<Integer, List<Character>> map3 = new HashMap<>();
        Map<Integer, List<Character>> map4 = new HashMap<>();
        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                if (board[j][i] == '.'){
                    continue;
                }

                if (map1.containsKey(board[j][i])) {
                    return false;
                } else {
                    map1.put(board[j][i], ' ');
                }

                if (map2.containsKey(i) && map2.get(i).contains(board[j][i])) {
                    return false;
                } else {
                    if (map2.containsKey(i)){
                        map2.get(i).add(board[j][i]);
                    }else {
                        List<Character> characterList = new ArrayList<>();
                        characterList.add(board[j][i]);
                        map2.put(i, characterList);
                    }
                }

                if (map3.containsKey(j) && map3.get(j).contains(board[j][i])) {
                    return false;
                } else {
                    if (map3.containsKey(j)){
                        map3.get(j).add(board[j][i]);
                    }else {
                        List<Character> characterList = new ArrayList<>();
                        characterList.add(board[j][i]);
                        map3.put(j, characterList);
                    }
                }

                if (map4.containsKey(j/3) && map4.get(j/3).contains(board[j][i])) {
                    return false;
                } else {
                    if (map4.containsKey(j/3)){
                        map4.get(j/3).add(board[j][i]);
                    }else {
                        List<Character> characterList = new ArrayList<>();
                        characterList.add(board[j][i]);
                        map4.put(j/3, characterList);
                    }
                }
            }

            map1.clear();

            if ((i + 1) % 3 == 0){
                map4.clear();
            }

        }

        return true;*/
    }


    public static void setZeroes(int[][] matrix) {
        int len = matrix.length;
        int size = matrix[0].length;
        boolean h = false;
        boolean l = false;

        for (int i = 0; i < len; i++){
            for (int j = 0; j < size; j++){
                if (matrix[i][j] == 0){
                    if (i == 0){
                        h = true;
                    }
                    if (j == 0){
                        l = true;
                    }
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j < size; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; l && i < len; i++) {
            matrix[i][0] = 0;
        }

        for (int i = 0; h && i < size; i++) {
            matrix[0][i] = 0;
        }

        System.out.println(Arrays.deepToString(matrix));
    }


}
