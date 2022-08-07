package com.pyz.leetcode.datastructure;

import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @Author: peiyanzhao
 * @DateTime: 2022/8/6 10:42
 * @Description: TODO
 */
public class Day6 {

    public static void main(String[] args) {
        System.out.println(isAnagram("rat", "car"));
    }


    public static int firstUniqChar(String s) {
        Map<Character, Integer> position = new HashMap<Character, Integer>();
        Queue<Pair> queue = new LinkedList<Pair>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (!position.containsKey(ch)) {
                position.put(ch, i);
                queue.offer(new Pair(ch, i));
            } else {
                position.put(ch, -1);
                while (!queue.isEmpty() && position.get(queue.peek().ch) == -1) {
                    queue.poll();
                }
            }
        }
        return queue.isEmpty() ? -1 : queue.poll().pos;
    }

    static class Pair {
        char ch;
        int pos;

        Pair(char ch, int pos) {
            this.ch = ch;
            this.pos = pos;
        }
    }


        /*if (s.length() == 1){
            return 0;
        }

        for (int i = 0; i < s.length(); i++) {
            boolean isT = true;
            for (int i1 = 0; i1 < s.length(); i1++) {
                if (i == i1){
                    continue;
                }
                if (s.charAt(i) == s.charAt(i1)){
                    isT = false;
                    break;
                }
            }
            if (isT){
                return i;
            }
        }
      return -1;*/

    public static boolean canConstruct(String ransomNote, String magazine) {

        int[] nums = new int[26];
        for (char c : magazine.toCharArray()) {
            nums[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (nums[c - 'a'] <= 0) return false;
            nums[c - 'a']--;
        }

        return true;

       /* Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            if (map.containsKey(magazine.charAt(i))) {
                map.put(magazine.charAt(i), map.get(magazine.charAt(i)) + 1);
            } else {
                map.put(magazine.charAt(i), 1);
            }
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            Integer num = map.get(ransomNote.charAt(i));
            if (num != null && num > 0) {
                map.put(ransomNote.charAt(i), num - 1);
            } else {
                return false;
            }
        }

        return true;*/
    }


    public static boolean isAnagram(String s, String t) {

        int slen = s.length();
        int tlen = t.length();
        if (slen != tlen) {
            return false;
        }

        int[] a1 = new int[26];
        int[] a2 = new int[26];

        for (int i = 0; i < slen; i++) {
            a1[s.charAt(i) - 'a']++;
            a2[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < slen; i++) {
            int s1 = a1[s.charAt(i) - 'a'];
            int t1 = a2[s.charAt(i) - 'a'];
            if (s1 != t1) {
                return false;
            }
        }

        return true;

    }


}



