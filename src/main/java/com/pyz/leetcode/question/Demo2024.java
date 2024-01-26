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


    public static int[] productExceptSelf(int[] nums) {


        int len = nums.length;
        int[] ans = new int[len];
        int suffix = 1;

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                ans[i] = 1;
            } else {
                ans[i] = ans[i - 1] * nums[i - 1];
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            ans[i] = ans[i] * suffix;
            suffix = suffix * nums[i];
        }

        return ans;

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int len = nums.length;
        int[] preMax = new int[len];
        int[] suffixMax = new int[len];
        for (int i = 0; i < len; i++) {
            if (i % k == 0) {
                preMax[i] = nums[i];
            } else {
                preMax[i] = Math.max(preMax[i - 1], nums[i]);
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            if ((i == len - 1) || (i + 1) % k == 0) {
                suffixMax[i] = nums[i];
            } else {
                suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
            }
        }

        int[] ans = new int[len - k + 1];
        for (int i = 0; i < len - k + 1; i++) {
            ans[i] = Math.max(suffixMax[i], preMax[i + k - 1]);
        }
        return ans;
    }


    public String minWindow(String s, String t) {

        int slen = s.length();
        int tlen = t.length();

        if (slen == 0 || tlen == 0 || slen < tlen) {
            return "";
        }
        int[] tFreq = new int[128];
        for (int i = 0; i < tlen; i++) {
            tFreq[t.charAt(i)]++;
        }
        int[] winFreq = new int[128];
        int distance = 0;
        int begin = 0;
        int min = slen + 1;
        int left = 0;
        int right = 0;
        while (right < slen) {

            if (tFreq[s.charAt(right)] == 0) {
                right++;
                continue;
            }

            if (winFreq[s.charAt(right)] < tFreq[s.charAt(right)]) {
                distance++;
            }
            winFreq[s.charAt(right)]++;
            right++;

            while (distance == tlen) {

                if (right - left < min) {
                    min = right - left;
                    begin = left;
                }

                if (tFreq[s.charAt(left)] == 0) {
                    left++;
                    continue;
                }
                if (winFreq[s.charAt(left)] == tFreq[s.charAt(left)]) {
                    distance--;
                }
                winFreq[s.charAt(left)]--;
                left++;
            }

        }

        if (min == slen + 1) {
            return "";
        }

        return s.substring(begin, begin + min);

    }


    public int canCompleteCircuit(int[] gas, int[] cost) {

        int len = gas.length;
        int sum = 0;
        int min = 0;
        int idx = 0;
        for (int i = 0; i < len; i++) {
            sum += gas[i] - cost[i];
            if (sum < min) {
                min = sum;
                idx = i + 1;
            }
        }

        return sum < 0 ? -1 : idx;
    }


    public int candy(int[] ratings) {

        int len = ratings.length;
        int incr = 1;
        int prev = 1;
        int decr = 0;
        int ans = 0;
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                decr = 0;
                prev = ratings[i] == ratings[i - 1] ? 1 : prev + 1;
                incr = prev;
                ans += prev;
            } else {
                decr++;
                if (incr == decr) {
                    decr++;
                }

                ans += decr;
                prev = 1;
            }
        }

        return ans;

    }

    public int maxSubArray(int[] nums) {

        int pre = 0;
        int max = nums[0];

        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(max, pre);
        }
        return max;
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> ans = new ArrayList<>();
        for (int[] interval : intervals) {
            int l = interval[0];
            int r = interval[1];
            int size = ans.size();
            if (size != 0 && ans.get(size - 1)[1] >= l) {
                ans.get(size - 1)[1] = Math.max(ans.get(size - 1)[1], r);
            } else {
                ans.add(new int[]{l, r});
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }

    /*public int trap(int[] height) {
        int len = height.length;
        int[] lMaxArr = new int[len];
        int[] rMaxArr = new int[len];

        lMaxArr[0] = height[0];
        for (int i = 1; i < len; i++) {
            lMaxArr[i] = Math.max(lMaxArr[i - 1], height[i]);
        }

        rMaxArr[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rMaxArr[i] = Math.max(rMaxArr[i + 1], height[i]);
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += Math.min(lMaxArr[i], rMaxArr[i]) - height[i];
        }
        return ans;
    }*/


    public static int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int len = s.length();
        int ans = 0;
        int p = 0;
        while (p < len) {
            char c = s.charAt(p);
            char next = p == len - 1 ? ' ' : s.charAt(p + 1);
            if (c == 'I' && next == 'V') {
                ans += 4;
                p = p + 2;
                continue;
            }
            if (c == 'I' && next == 'X') {
                ans += 9;
                p = p + 2;
                continue;
            }
            if (c == 'X' && next == 'L') {
                ans += 40;
                p = p + 2;
                continue;
            }
            if (c == 'X' && next == 'C') {
                ans += 90;
                p = p + 2;
                continue;
            }
            if (c == 'C' && next == 'D') {
                ans += 400;
                p = p + 2;
                continue;
            }
            if (c == 'C' && next == 'M') {
                ans += 900;
                p = p + 2;
                continue;
            }
            ans += map.get(c);
            p++;
        }

        return ans;


    }


    public static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String intToRoman(int num) {

        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < symbols.length; i++) {

            int val = values[i];
            while (num >= val) {
                stringBuffer.append(symbols[i]);
                num -= val;
            }
            if (val == 0) break;
        }

        return stringBuffer.toString();
    }

    public static void rotate1(int[] nums, int k) {

        int len = nums.length;
        int[] ints = new int[len];
        for (int i = 0; i < len; i++) {
            ints[(i + k) % len] = nums[i];
        }
        System.arraycopy(ints, 0, nums, 0, len);
    }

    public static int[] productExceptSelf1(int[] nums) {

        int len = nums.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                ans[i] = 1;
            } else {
                ans[i] = ans[i - 1] * nums[i - 1];
            }
        }

        int suffix = 1;
        for (int i = len - 1; i >= 0; i--) {
            ans[i] = ans[i] * suffix;
            suffix = nums[i] * suffix;
        }

        return ans;
    }

    public static int lengthOfLastWord(String s) {

        int slow = 0;
        int len = s.length();
        boolean b = false;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ' && !b) {
                slow = i;
                b = true;
            } else if (s.charAt(i) == ' ' && b) {
                return slow - i;
            }
        }
        return b ? slow + 1 : 0;
    }


    public static int firstMissingPositive(int[] nums) {

        boolean have1 = false;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1){
                have1 = true;
            }
            if (nums[i] <= 0 || nums[i] > len) {
                nums[i] = 1;
            }
        }
        if (!have1){
            return 1;
        }
        for (int i = 0; i < len; i++) {
            int v = Math.abs(nums[i]) - 1;
            nums[v] = -Math.abs(nums[v]);
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return len + 1;
    }

    public static void main(String[] args) {

        System.out.println(firstMissingPositive(new int[]{1,2,0}));
    }


}