package com.pyz.leetcode.question;

import java.util.*;

public class Demo2023 {

    public int countSegments(String s) {

        s = s.trim();
        int ans = 0;
        int len = s.length();
        boolean start = false;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                start = true;
            }
            if (start && s.charAt(i) == ' ') {
                ans++;
                start = false;
            }
        }

        return ans;
    }

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        List<String> list = Arrays.asList(s.split(" "));
        int len1 = list.size();
        int len = pattern.length();
        if (len != len1) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            String v = "";
            if (map1.containsKey(pattern.charAt(i))) {
                v = map1.get(pattern.charAt(i));
            }
            map1.put(pattern.charAt(i), v + i);

            if (map2.containsKey(list.get(i))) {
                if (!v.equals(map2.get(list.get(i)))) {
                    return false;
                }
            } else {
                if (!v.equals(map2.get(list.get(i)) == null ? "" : map2.get(list.get(i)))) {
                    return false;
                }
            }
            map2.put(list.get(i), v + i);
        }

        return true;

    }

   /* public static int minNumberOfFrogs(String croakOfFrogs) {

        int len = croakOfFrogs.length();
        int index = 0;
        StringBuilder ans = new StringBuilder();
        while (ans.su) {
            for (int i = 0; i < len; i++) {
                String temp = ans.substring(ans.length() - 1);
                if (temp.equals("c") && croakOfFrogs.charAt(i) == 'r') {
                    ans.append("r");
                    continue;
                }
                if (temp.equals("r") && croakOfFrogs.charAt(i) == 'o') {
                    ans.append("o");
                    continue;
                }
                if (temp.equals("o") && croakOfFrogs.charAt(i) == 'a') {
                    ans.append("a");
                    continue;
                }
                if (temp.equals("k") && croakOfFrogs.charAt(i) == 'c') {
                    ans.append("c");
                    continue;
                }
            }

        }
        if (!ans.substring(ans.length()-1).equals("k")){
            return -1;
        }

        return ans.length()/5;
    }*/

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int insertP = m + n - 1;

        while (n > 0) {
            if (nums1[m - 1] >= nums2[n - 1]) {
                nums1[insertP] = nums1[m - 1];
                m--;
            } else {
                nums1[insertP] = nums2[n - 1];
                n--;
            }
            insertP--;
        }
    }


    public static int removeElement(int[] nums, int val) {

        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                int t = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = t;
                slow++;
            }
        }

        return slow;
    }


   /* public int removeDuplicates(int[] nums) {
        int slow = 0;
        int temp = -1;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                int t = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = t;
                slow++;
            }
        }

        return slow;
    }*/

   /* public static final Map<Character, Integer> intMap = new HashMap<>();
    static {
        intMap.put('0', 0);
        intMap.put('1', 1);
        intMap.put('2', 2);
        intMap.put('3', 3);
        intMap.put('4', 4);
        intMap.put('5', 5);
        intMap.put('6', 6);
        intMap.put('7', 7);
        intMap.put('8', 8);
        intMap.put('9', 9);
    }*/

    public static String addStrings(String num1, String num2) {

        int n1 = num1.length() - 1;
        int n2 = num2.length()- 1;
        StringBuilder ans = new StringBuilder();
        boolean isPlus = false;
        while (n1 >= 0 || n2 >= 0) {
            int a = 0;
            int b = 0;
            if (n1 >= 0) {
                a = num1.charAt(n1)-'0';
            }
            if (n2 >= 0) {
                b = num2.charAt(n2)-'0';
            }

            int v = isPlus ? 1 + a + b : a + b;
            if (v >= 10) {
                ans.insert(0, (v - 10));
                isPlus = true;
            } else {
                ans.insert(0, v);
                isPlus = false;
            }

            n1--;
            n2--;
        }

        if (isPlus){
            ans.insert(0, 1);
        }

        return ans.toString().toString();
    }


    public static void main(String[] args) {
        System.out.println(addStrings("1", "9"));
    }


}
