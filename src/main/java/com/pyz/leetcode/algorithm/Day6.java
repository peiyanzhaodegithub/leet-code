package com.pyz.leetcode.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: peiyanzhao
 * @DateTime: 2022/8/6 10:42
 * @Description: TODO
 */
public class Day6 {


    public static void main(String[] args) {
        System.out.println(checkInclusion("abc","cccccbabbbaaaa"));
    }


    public static int lengthOfLongestSubstring(String s) {

      /*  // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;*/

        Set<Character> set = new HashSet<>();
        int n = s.length();
        int p = -1;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {

            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }

            while (p + 1 < n && !set.contains(s.charAt(p + 1))){
                set.add(s.charAt(p + 1));
                p++;
            }

            max = Math.max(max, p - i +  1);
        }

        return max;
    }


    public static boolean checkInclusion(String s1, String s2) {

        int len1 = s1.length();
        int len2 = s2.length();

        if(len1 > len2)
            return false;

        HashMap<Character, Integer> mapS1  = new HashMap<>();
        HashMap<Character, Integer>  mapS2 = new HashMap<>();

        for(char ch : s1.toCharArray())
            mapS1.put(ch, mapS1.getOrDefault(ch, 0) + 1);

        int index = 0;
        for(int i = 0; i < len1; i++, index++){
            char ch = s2.charAt(i);
            mapS2.put(ch, mapS2.getOrDefault(ch, 0) + 1) ;
        }

        while(index < len2){
            if(mapS2.equals(mapS1))
                return true;

            char before = s2.charAt(index - len1);
            char after  = s2.charAt(index);

            mapS2.put(before, mapS2.get(before) - 1);
            if(mapS2.get(before) == 0)
                mapS2.remove(before);
            mapS2.put(after, mapS2.getOrDefault(after, 0) + 1);

            index++;
        }

        return mapS2.equals(mapS1);


    }


}
