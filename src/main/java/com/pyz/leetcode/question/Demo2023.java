package com.pyz.leetcode.question;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

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
        int n2 = num2.length() - 1;
        StringBuilder ans = new StringBuilder();
        boolean isPlus = false;
        while (n1 >= 0 || n2 >= 0) {
            int a = 0;
            int b = 0;
            if (n1 >= 0) {
                a = num1.charAt(n1) - '0';
            }
            if (n2 >= 0) {
                b = num2.charAt(n2) - '0';
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

        if (isPlus) {
            ans.insert(0, 1);
        }

        return ans.toString().toString();
    }

    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.reverse(list);
        int ans = list.get(0);
        int n = 0;
        for (int i = 0; i < list.size(); i++) {
            if (n == 3) {
                return ans;
            }

            if (i != 0 && ans == list.get(i)) {
                continue;
            }

            ans = list.get(i);
            n++;
        }

        return n < 3 ? nums[nums.length - 1] : ans;
    }


    public static List<String> fizzBuzz(int n) {


        List<String> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                ans.add("FizzBuzz");

            } else if (i % 5 == 0) {
                ans.add("Buzz");
            } else if (i % 3 == 0) {
                ans.add("Fizz");

            } else {
                ans.add(i + "");
            }
        }

        return ans;

    }


    public static int maxArea(int[] height) {

        int p1 = 0;
        int p2 = height.length - 1;
        int ans = 0;
        while (p1 < p2) {
            ans = height[p1] < height[p2] ? Math.max(ans, (p2 - p1) * height[p1++]) : Math.max(ans, (p2 - p1) * height[p2--]);
        }

        return ans;
    }


    public static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String intToRoman(int num) {

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < values.length; i++) {

            int val = values[i];
            String s = symbols[i];

            while (num >= val) {
                stringBuffer.append(s);
                num -= val;
            }

            if (val == 0) {
                break;
            }

        }

        return stringBuffer.toString();
    }

    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    public static boolean isUgly(int n) {

        while (n > 0) {
            if (n == 1 || n == 2 || n == 3 || n == 5) {
                return true;
            }
            n = n % 2 == 0 ? n / 2 : n % 3 == 0 ? n / 3 : n % 5 == 0 ? n / 5 : 0;
        }

        return false;

    }

    public int missingNumber(int[] nums) {

        int len = nums.length;
        int total = len * (len + 1) / 2;
        for (int i = 0; i < len; i++) {
            total = total - nums[i];
        }
        return total;
    }

    public static boolean canWinNim(int n) {

        return n % 4 > 0;

    }

    /*public List<List<Integer>> threeSum(int[] nums) {



    }*/

/*

    public static void main(String[] args) {

        NumArray numArray = new NumArray(new int[]{-2,0,3,-5,2,-1});

        System.out.println(numArray.sumRange(0,2));
    }
*/


   /* public static void main(String[] args) {

        Demo2023 lock = new Demo2023();
        AtomicReference<String> temp = new AtomicReference<>("");

        Runnable r1 = () -> {
            while (true) {
                synchronized (lock) {
                    if (!temp.get().equals("")) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("A");
                    temp.set("A");
                    lock.notifyAll();
                }
            }
        };
        Runnable r2 = () -> {
            while (true) {
                synchronized (lock) {

                    if (!temp.get().equals("A")) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("B");
                    temp.set("B");
                    lock.notifyAll();
                }
            }
        };
        Runnable r3 = () -> {
            while (true) {
                synchronized (lock) {

                    if (!temp.get().equals("B")) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("C");
                    temp.set("");
                    lock.notifyAll();
                }
            }
        };

        r1.run();
        r2.run();
        r3.run();

    }*/


    public static void merge1(int[] nums1, int m, int[] nums2, int n) {

        int p = 0;
        int max = m + n - 1;
        for (int i = 0; i < max; i++) {
            if (p == n) {
                break;
            }
            if (nums1[i] > nums2[p]) {
                nums1[m] = nums1[i];
                nums1[i] = nums2[p];
                p++;
                m++;
            }

        }

        if (p < n) {
            for (int i = p; i < n; i++) {
                nums1[m] = nums2[i];
                m++;
            }
        }
        System.out.println(Arrays.toString(nums1));

    }


    /*public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
        cache.put(4, 4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }*/


    static class LRUCache {


        class Node {
            private Node next;
            private Node prev;
            private Integer v;
            private Integer k;

            public Node() {
            }

            public Node(Node next, Node prev, Integer v, Integer k) {
                this.next = next;
                this.prev = prev;
                this.v = v;
                this.k = k;
            }
        }


        private Node head, tail;
        private int capacity;
        private int size;
        private Map<Integer, Node> cache = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }


        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) {
                //不存在返回-1
                return -1;
            }
            moveToHead(node);
            return node.v;
        }

        public void put(int key, int value) {

            Node cacheNode = cache.get(key);
            if (cacheNode == null) {
                if (size >= capacity) {
                    //移除链表尾部node
                    Node tail = removeTail();
                    //删除缓存
                    cache.remove(tail.k);
                    --size;
                }

                Node node = new Node();
                node.k = key;
                node.v = value;
                cache.put(key, node);
                //将node添加到链表头
                addHead(node);
                ++size;
            } else {
                cacheNode.v = value;
                moveToHead(cacheNode);
            }
        }

        private void addHead(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToHead(Node node) {
            removeNode(node);
            addHead(node);
        }

        private Node removeTail() {
            Node tail = this.tail.prev;
            removeNode(tail);
            return tail;
        }


        public LRUCache() {
        }

        public Node getHead() {
            return head;
        }

        public void setHead(Node head) {
            this.head = head;
        }

        public Node getTail() {
            return tail;
        }

        public void setTail(Node tail) {
            this.tail = tail;
        }

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public Map<Integer, Node> getCache() {
            return cache;
        }

        public void setCache(Map<Integer, Node> cache) {
            this.cache = cache;
        }
    }

    public static int removeDuplicates(int[] nums) {

        int slow = 2;
        int fast = 2;
        int n = nums.length;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }

        return slow;
    }


    public static int[] twoSum(int[] nums, int target) {


        //方法 1
        /*Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> indexList = map.getOrDefault(nums[i], new ArrayList<>());
            indexList.add(i);
            map.put(nums[i], indexList);
        }

        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            List<Integer> idxList = map.get(val);
            if (idxList == null){
                continue;
            }

            if (val == nums[i] ){
                if (idxList.size() != 2) {
                    continue;
                }else {
                    return new int[]{i, idxList.get(1)};
                }
            }

            return new int[]{i, idxList.get(0)};
        }

        return null;*/

        //方法2
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                if (val == nums[j]) {
                    return new int[]{i, j};
                }
            }

        }
        return null;

    }



    public static void merge2(int[] nums1, int m, int[] nums2, int n) {

        int insP = m + n - 1;

        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[insP] = nums1[m-1];
                m--;
            }else {
                nums1[insP] = nums2[n-1];
                n--;
            }
            insP--;
        }

        if (n> 0){
            for (int i = n; i > 0; i--) {
                nums1[insP] = nums2[i-1];
                insP--;
            }
        }
        System.out.println(Arrays.toString(nums1));

    }

    public static void main(String[] args) {
        System.out.println(removeElement1(new int[]{3,2,2,3}, 3));
    }


    public static int removeElement1(int[] nums, int val) {

        int slow = 0;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[i] != val){
                nums[slow] = nums[i];
                slow++;
            }
        }

        return slow;



    }

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String > list = map.getOrDefault(key,new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());


    }



























}
