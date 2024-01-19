package com.pyz.leetcode.question;

import java.util.*;

public class Demo2024 {

    public static int maxArea(int[] height) {

        int p1 = 0;
        int p2 = height.length - 1;
        int ans = 0;

        while (p1 < p2) {

            ans = height[p1] > height[p2] ? Math.max(ans, (p2 - p1) * height[p2--]) : Math.max(ans, (p2 - p1) * height[p1++]);

        }

        return ans;

    }

    public static void rotate(int[] nums, int k) {

        int len = nums.length;
        int[] ints = new int[len];
        for (int i = 0; i < nums.length; i++) {
            ints[(i + k) % len] = nums[i];
        }

        System.arraycopy(ints, 0, nums, 0, len);
    }

    public static int maxProfit(int[] prices) {

        int ans = 0;
        int min = prices[0];
        for (int price : prices) {
            ans = Math.max(ans, price - min);
            min = Math.min(min, price);
        }

        return ans;
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> list = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {

            int l = i + 1;
            int r = n - 1;
            while (l < r) {

                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }

            }

        }
        return new ArrayList<>(list);
    }


    /*public static int maxProfit2(int[] prices) {

        int ans = 0;
        int len = prices.length;
        int minP = 0;
        while (minP < len) {
            int tempAns = 0;
            int tempMinp = minP;
            for (int j = tempMinp + 1; j < len; j++) {
                if (prices[tempMinp] >= prices[j]) {
                    continue;
                }
                tempAns = tempAns + (prices[j] - prices[tempMinp]);
                tempMinp = j + 1;
            }

            ans = Math.max(tempAns, ans);
            minP++;
        }

        return ans;
    }*/

    public static int maxProfit2(int[] prices) {

        if (prices == null || prices.length <= 1) return 0;

        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                ans += (prices[i] - prices[i - 1]);
            }
        }

        return ans;

    }

    public int trap(int[] height) {

        int ans = 0;
        int len = height.length;
        if (len < 3) return 0;
        int[] leftMaxArr = new int[len];
        int[] rightMaxArr = new int[len];
        leftMaxArr[0] = height[0];
        rightMaxArr[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            leftMaxArr[i] = Math.max(leftMaxArr[i - 1], height[i]);
        }

        for (int i = len - 2; i >= 0; i--) {
            rightMaxArr[i] = Math.max(rightMaxArr[i + 1], height[i]);
        }

        for (int i = 0; i < len; i++) {
            ans += Math.min(leftMaxArr[i], rightMaxArr[i]) - height[i];
        }

        return ans;
    }

    public static int lengthOfLongestSubstring(String s) {

        int len = s.length();
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }

            ans = Math.max(ans, i - left + 1);
            map.put(s.charAt(i), i);
        }

        return ans;
    }


    public static boolean canJump(int[] nums) {

        int step = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i <= step) {
                step = Math.max(step, i + nums[i]);
                if (step >= len - 1) {
                    return true;
                }
            }
        }
        //[2, 3, 1, 1, 4]
        return false;
    }

    public static int jump(int[] nums) {

        int position = nums.length - 1;//距离，需要走的最大步数
        int steps = 0;//答案，最终走的步数

        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (1 + nums[i] >= position) {
                    //找到到达终点并且距离终点最远的值
                    steps++;
                    position = i;
                    break;
                }
            }

        }
        return steps;
    }

    public static int hIndex(int[] citations) {

        Arrays.sort(citations);

        int len = citations.length;
        for (int i = 0; i < len; i++) {
            if (citations[i] >= len - i) {
                return len - i;
            }
        }
        return 0;

    }

    public static List<Integer> findAnagrams(String s, String p) {

        int slen = s.length();
        int plen = p.length();
        if (slen < plen) {
            return new ArrayList<Integer>();
        }
        List<Integer> ans = new ArrayList<>();

        int[] scount = new int[26];
        int[] pcount = new int[26];
        for (int i = 0; i < plen; i++) {
            ++scount[s.charAt(i) - 'a'];
            ++pcount[p.charAt(i) - 'a'];
        }
        if (Arrays.equals(scount, pcount)) {
            ans.add(0);
        }

        for (int i = 0; i < slen - plen; i++) {
            --scount[s.charAt(i) - 'a'];
            ++scount[s.charAt(i + plen) - 'a'];

            if (Arrays.equals(scount, pcount)) {
                ans.add(i + 1);
            }

        }

        return ans;

    }

    public int subarraySum(int[] nums, int k) {

        /*int count = 0;
        for (int i = 0; i < nums.length; i++) {

            int sum = 0;
            for (int i1 = i; i1 >= 0; i1--) {
                sum += nums[i1];
                if (sum == k) {
                    count++;
                }
            }

        }
        return count;*/

        int count = 0;
        int pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre - k, 0) + 1);
        }

        return count;

    }

    class RandomizedSet {
        Random random;
        List<String> keys;
        Map<String, Integer> map;

        public RandomizedSet() {
            keys = new ArrayList<>();
            map = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            String k = String.valueOf(val);
            if (map.containsKey(k)) {
                return false;
            }

            keys.add(k);
            map.put(k, val);
            return true;
        }

        public boolean remove(int val) {
            String k = String.valueOf(val);
            if (!map.containsKey(k)) {
                return false;
            }

            keys.remove(k);
            map.remove(k);
            return true;
        }

        public int getRandom() {
            return map.get(keys.get(random.nextInt(keys.size())));
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextInt(9));
        }
        System.out.println();
    }


}