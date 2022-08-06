package com.pyz.leetcode.algorithm;

import java.util.HashSet;
import java.util.Set;

public class Day6Temp {


    public static void main(String[] args) {
        lengthOfLongestSubstring("pwwkew");
    }

    public static int lengthOfLongestSubstring(String s) {


        Set<Character> set = new HashSet<>();
        int start = -1;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0){
                set.remove(s.charAt(i-1));
            }

            while (start + 1 < s.length() && !set.contains(s.charAt(start + 1))){
                set.add(s.charAt(start + 1));
                ++start;
            }

            max = Math.max(max, start - i + 1);
            System.out.println(max+"---"+(start - i + 1));
        }
        return max;
    }

}
