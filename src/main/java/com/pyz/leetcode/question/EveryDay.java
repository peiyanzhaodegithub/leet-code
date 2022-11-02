package com.pyz.leetcode.question;

import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class EveryDay {


    class MyCircularDeque {
        //循环双端队列

        private int[] ele;
        private int front, rear;
        private int capacity;


        public MyCircularDeque(int k) {
            //构造函数
            ele = new int[k + 1];
            rear = front = 0;
            capacity = k + 1;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }

            front = (front - 1 + capacity) % capacity;
            ele[front] = value;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }

            ele[rear] = value;
            rear = (rear + 1) % capacity;
            return true;
        }

        public boolean deleteFront() {
            //从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false
            if (isEmpty()) {
                return false;
            }
            front = (front + 1) % capacity;
            return true;
        }

        public boolean deleteLast() {
            //从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false
            if (isEmpty()) {
                return false;
            }
            rear = (rear - 1 + capacity) % capacity;
            return true;
        }

        public int getFront() {
            //从双端队列头部获得一个元素。如果双端队列为空，返回 -1
            if (isEmpty()) {
                return -1;
            }

            return ele[front];
        }

        public int getRear() {
            //获得双端队列的最后一个元素。 如果双端队列为空，返回 -1
            if (isEmpty()) {
                return -1;
            }

            return ele[(rear - 1 + capacity) % capacity];
        }

        public boolean isEmpty() {
            //若双端队列为空，则返回 true ，否则返回 false

            return front == rear;

        }

        public boolean isFull() {
            //若双端队列满了，则返回 true ，否则返回 false

            return (rear + 1) % capacity == front;
        }


    }

    private static void p(int n) {
        if (n == 0) {
            return;
        }
        p(n / 10);
        System.out.println(n % 10);
    }

    public static boolean isPalindrome(int x) {

        String s = x + "";
        if (s.length() == 1) {
            return true;
        }
        if (s.charAt(0) == '-') {
            return false;
        }
        String ts = "";
        if (s.length() % 2 == 0) {
            ts = s.substring(s.length() / 2);
        } else {
            ts = s.substring(s.length() / 2 + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = ts.length() - 1; i >= 0; i--) {
            sb.append(ts.charAt(i));
        }

        return Integer.parseInt(sb.toString()) == Integer.parseInt(s.substring(0, s.length() / 2));


    }

    class OrderedStream {
        // 设计有序流
        int[] index;
        String[] ele;
        int ptr;
        int max;

        public OrderedStream(int n) {
            index = new int[n + 1];
            ele = new String[n + 1];
            ptr = 1;
            max = n;
        }

        public List<String> insert(int idKey, String value) {

            List<String> list = new ArrayList<>();
            ele[idKey] = value;
            index[idKey] = idKey;
            if (ptr == idKey) {
                for (int i = ptr; i <= max; i++) {
                    if (index[i] == 0) {
                        ptr = i;
                        break;
                    }
                    list.add(ele[i]);
                }
            }

            return list;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int plus = 0;
        ListNode listNode = new ListNode();
        ListNode curr = listNode;
        while (l1 != null || l2 != null || plus > 0) {

            int v = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + plus;
            plus = v / 10;
            curr.next = new ListNode(v % 10);
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            curr = curr.next;
        }

        return listNode.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static int deepestLeavesSum(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {

            int num = queue.size();
            sum = 0;
            for (int i = 1; i <= num; i++) {
                TreeNode treeNode = queue.poll();
                sum = sum + treeNode.val;
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
            }
        }

        return sum;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int p1 = 0, p2 = 0;
        int n1 = nums1.length, n2 = nums2.length;
        int[] merge = new int[n1 + n2];
        if (n1 == 0) {
            merge = nums2;
        } else if (n2 == 0) {
            merge = nums1;
        } else {
            for (int i = 0; i < (n1 + n2); i++) {
                if (p1 == n1) {
                    merge[i] = nums2[p2];
                    p2++;
                    continue;
                }
                if (p2 == n2) {
                    merge[i] = nums1[p1];
                    p1++;
                    continue;
                }
                if (nums1[p1] <= nums2[p2]) {
                    merge[i] = nums1[p1];
                    p1++;
                } else {
                    merge[i] = nums2[p2];
                    p2++;
                }
            }
        }
        int median = (n1 + n2) / 2;

        return (n1 + n2) % 2 > 0 ? merge[median] : Double.parseDouble((merge[median] + merge[median - 1]) + "") / 2;

    }

    public static String longestPalindrome(String s) {

        int len = s.length();
        if (len == 1) {
            return s;
        }
        String ans = "";
        for (int i = 0; i < len; i++) {

            // 第二层循环可以改成for (int j = len - 1; j > i; j--) {}  这样判断是回文串之后就不必再往后循环了，因为这就是当前循环最长的回文串
            for (int j = i + 1; j < len; j++) {

                if (s.charAt(i) == s.charAt(j)) {
                    //判断是否是回文串
                    int p1 = i + 1, p2 = j - 1;
                    boolean is = true;
                    while (p1 <= p2) {
                        if (s.charAt(p1) != s.charAt(p2)) {
                            is = false;
                            break;
                        }
                        p1++;
                        p2--;
                    }

                    if (is && ans.length() < (j - i + 1)) {
                        ans = s.substring(i, j + 1);
                    }
                }

            }
        }

        return ans.length() == 0 ? s.charAt(0) + "" : ans;

    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        int len = s.length();
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        int inc = 1;
        int line = 0;

        for (int i = 0; i < len; i++) {

            stringBuilders[line].append(s.charAt(i));
            if (line == 0) {
                inc = 1;
            }

            if (line == numRows - 1) {
                inc = -1;
            }

            line = line + inc;

        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < stringBuilders.length; i++) {
            res.append(stringBuilders[i]);
        }

        return res.toString();
    }

    public static int reverse(int x) {

        int res = 0;
        while (x != 0) {
            if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x = x / 10;
            res = res * 10 + digit;
        }

        return res;

    }

    public static int myAtoi(String str) {

        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int sign = str.charAt(0) == '-' ? -1 : 1;
        int res = 0;
        int i = str.charAt(0) == '-' || str.charAt(0) == '+' ? 1 : 0;
        int len = str.length();
        for (; i < len; i++) {
            char currChar = str.charAt(i);
            if (!Character.isDigit(currChar)) {
                break;
            }

            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + sign * (currChar - '0');
        }
        return res;
    }

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {

        int ans = 0;
        int len = startTime.length;

        for (int i = 0; i < len; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                ans++;
            }
        }

        return ans;

    }


    public static int subarraysWithKDistinct(int[] nums, int k) {

        int n = nums.length;
        int[] num1 = new int[n + 1];
        int[] num2 = new int[n + 1];
        int tot1 = 0, tot2 = 0;
        int left1 = 0, left2 = 0, right = 0;
        int ret = 0;
        while (right < n) {
            if (num1[nums[right]] == 0) {
                tot1++;
            }
            num1[nums[right]]++;
            if (num2[nums[right]] == 0) {
                tot2++;
            }
            num2[nums[right]]++;
            while (tot1 > k) {
                num1[nums[left1]]--;
                if (num1[nums[left1]] == 0) {
                    tot1--;
                }
                left1++;
            }
            while (tot2 > k - 1) {
                num2[nums[left2]]--;
                if (num2[nums[left2]] == 0) {
                    tot2--;
                }
                left2++;
            }
            ret += left2 - left1;
            right++;
        }
        return ret;


        //return atMostKDistinct(A, K) - atMostKDistinct(A, K - 1);
    }

    /**
     * @param A
     * @param K
     * @return 最多包含 K 个不同整数的子区间的个数
     */
    private static int atMostKDistinct(int[] A, int K) {
        int len = A.length;
        int[] freq = new int[len + 1];

        int left = 0;
        int right = 0;
        // [left, right) 里不同整数的个数
        int count = 0;
        int res = 0;
        // [left, right) 包含不同整数的个数小于等于 K
        while (right < len) {
            if (freq[A[right]] == 0) {
                count++;
            }
            freq[A[right]]++;
            right++;

            while (count > K) {
                freq[A[left]]--;
                if (freq[A[left]] == 0) {
                    count--;
                }
                left++;
            }
            // [left, right) 区间的长度就是对结果的贡献
            res += right - left;
        }
        return res;
    }


    static Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};


    public static int romanToInt(String s) {

        int len = s.length(), ans = 0;

        for (int i = 0; i < len; i++) {

            int v = symbolValues.get(s.charAt(i));
            if (i < len - 1 && v < symbolValues.get(s.charAt(i + 1))) {
                ans -= v;
            } else {
                ans += v;
            }
        }

        return ans;
    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        String str = strs[0];
        int len = str.length();
        int total = strs.length;
        String ans = "";
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            for (int i1 = 1; i1 < total; i1++) {
                if (i == strs[i1].length() || c != strs[i1].charAt(i)) {
                    ans = str.substring(0, i);
                    return ans;
                }
            }

        }

        return ans;

    }

    public static List<List<String>> printTree(TreeNode root) {

        int height = calDepth(root);
        int m = height + 1;
        int n = (int) Math.pow(2, height + 1) - 1;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add("");
            }
            res.add(row);
        }

        Deque<Tuple> tupleDeque = new ArrayDeque<>();
        Tuple tuple = new Tuple(0, (n - 1) / 2, root);
        tupleDeque.offer(tuple);
        while (!tupleDeque.isEmpty()) {
            Tuple t = tupleDeque.poll();
            res.get(t.r).set(t.c, t.node.val + "");
            if (t.node.left != null) {
                tupleDeque.offer(new Tuple(t.r + 1, t.c - (int) Math.pow(2, height - t.r - 1), t.node.left));
            }
            if (t.node.right != null) {
                tupleDeque.offer(new Tuple(t.r + 1, t.c + (int) Math.pow(2, height - t.r - 1), t.node.right));
            }
        }

        return res;

    }

    private static int calDepth(TreeNode root) {

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        int res = -1;
        while (!stack.isEmpty()) {
            res++;
            int len = stack.size();
            while (len > 0) {
                TreeNode treeNode = stack.poll();
                len--;
                if (treeNode.left != null) {
                    stack.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    stack.offer(treeNode.right);
                }
            }
        }
        return res;
    }

    static class Tuple {
        int c;
        int r;
        TreeNode node;

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }

        public TreeNode getNode() {
            return node;
        }

        public void setNode(TreeNode node) {
            this.node = node;
        }

        public Tuple() {
        }

        public Tuple(int r, int c, TreeNode node) {
            this.c = c;
            this.r = r;
            this.node = node;
        }
    }

    public int lengthOfLastWord(String s) {

        int len = s.length();
        int res = 0;
        boolean is = false;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                res++;
                is = true;
            }

            if (is && s.charAt(i) == ' ') {
                break;
            }
        }

        return res;
    }

    public static int[] plusOne(int[] digits) {

        int len = digits.length;
        boolean max = true;

        for (int digit : digits) {
            if (digit != 9) {
                max = false;
                break;
            }
        }

        int newLen = max ? len + 1 : len;
        int[] ans = new int[newLen];
        int d = 0;
        boolean isLen = newLen == len;
        for (int i = (len - 1); i >= 0; i--) {
            int v = (i == len - 1 ? 1 : 0) + (digits[i]) + d;
            ans[isLen ? i : i + 1] = v % 10;
            d = v / 10;
        }
        if (!isLen) {
            ans[0] = 1;
        }

        return ans;

    }

    public static String addBinary(String a, String b) {
        //不建议直接使用库函数
        // System.out.println(Integer.toBinaryString(Integer.parseInt(a,2)+Integer.parseInt(b,2)));
        int alen = a.length() - 1;
        int blen = b.length() - 1;
        StringBuilder stringBuilder = new StringBuilder();
        boolean carry = false;
        while (alen >= 0 || blen >= 0) {

            if (alen < 0) {
                char bc = b.charAt(blen);
                if (carry) {
                    if (bc == '1') {
                        stringBuilder.append("0");
                    } else {
                        stringBuilder.append("1");
                        carry = false;
                    }
                } else {
                    stringBuilder.append(b.charAt(blen));
                }
                blen--;
                continue;
            }

            if (blen < 0) {
                char ac = a.charAt(alen);
                if (carry) {
                    if (ac == '1') {
                        stringBuilder.append("0");
                    } else {
                        stringBuilder.append("1");
                        carry = false;
                    }
                } else {
                    stringBuilder.append(a.charAt(alen));
                }
                alen--;
                continue;
            }

            if (a.charAt(alen) == '1' && b.charAt(blen) == '1') {
                if (carry) {
                    stringBuilder.append("1");
                } else {
                    stringBuilder.append("0");
                }
                carry = true;
            } else if (a.charAt(alen) == '0' && b.charAt(blen) == '0') {
                if (carry) {
                    stringBuilder.append("1");
                } else {
                    stringBuilder.append("0");
                }
                carry = false;
            } else {
                if (carry) {
                    stringBuilder.append("0");
                } else {
                    stringBuilder.append("1");
                }
            }

            alen--;
            blen--;
        }

        if (carry) {
            stringBuilder.append("1");
        }
        return stringBuilder.reverse().toString();
    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }


    public static int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        //深度优先搜索
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

    public static int countOperations(int num1, int num2) {

        if (num1 == 0 || num2 == 0) {
            return 0;
        }
        int ans = 1;
        while (num1 != num2) {
            if (num1 >= num2) {
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
            ans++;
        }

        return ans;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode treeNode = helper(nums, 0, nums.length - 1);
        return treeNode;
    }

    public static TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

    public static boolean canBeEqual(int[] target, int[] arr) {

        int len = target.length;
        for (int i = 0; i < len; i++) {
            if (target[i] != arr[i]) {
                int p1 = i;
                int p2 = 0;
                boolean b = false;
                for (int j = i + 1; j < len; j++) {
                    if (target[i] == arr[j]) {
                        p2 = j;
                        b = true;
                        break;
                    }
                }
                if (!b) {
                    return false;
                }

                while (p1 < p2) {
                    int t = arr[p1];
                    arr[p1] = arr[p2];
                    arr[p2] = t;
                    p1++;
                    p2--;
                }
            }
        }
        return true;
    }

    public static boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private static int height(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        } else {
            return Math.max(height(treeNode.left), height(treeNode.right)) + 1;
        }
    }

    public static int multiply(int A, int B) {

        return back(A, B);
    }

    private static int back(int a, int b) {
        if (a == 0) {
            return 0;
        }
        if (b == 1) {
            return a;
        }
        if (a == 1) {
            return b;
        }
        if (a > b) {
            return multiply(b, a);
        }
        return b + back(a - 1, b);
    }

    public static int addDigitsBack(int num, int v) {

        if (num < 10) {
            return num;
        }

        v = num % 10 + addDigitsBack(num / 10, v);

        if (v >= 10) {
            v = addDigitsBack(v, v);
        }
        return v;
    }


    public static boolean isPowerOfTwoBack(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    /*public String addBinary(String a, String b) {

        int alen = a.length();
        int blen = b.length();
        StringBuilder stringBuilder = new StringBuilder();
        boolean isCarry = false;
        while (alen > 0 && blen > 0){
            char ac = a.charAt(alen - 1);
            char bc = b.charAt(blen - 1);
            int v = ac + bc;
            if (v == 2){
                if (isCarry) {
                    stringBuilder.append("1");
                }else {
                    stringBuilder.append("0");
                }
                isCarry = true;
            }else if (v == 1){
                if (isCarry){
                    stringBuilder.append("0");
                }else {
                    stringBuilder.append("1");
                }
            }else {
                if (isCarry){
                    stringBuilder.append("1");
                    isCarry = false;
                }else {
                    stringBuilder.append("0");
                }
            }
            alen--;
            blen--;
        }
        if (isCarry){
            stringBuilder.append("1");
        }

        return stringBuilder.reverse().toString();
    }*/


    public static int maxProduct(int[] nums) {

        int v1 = 0, v2 = 0;

        for (int num : nums) {
            if (num >= v1) {
                int t = v1;
                v1 = num;
                v2 = t;
            } else if (v2 < num) {
                v2 = num;
            }
        }

        return (v1 - 1) * (v2 - 1);

    }

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null || root.right == null) {
            return 1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            index++;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left == null && treeNode.right == null) {
                    return index;
                }

                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
            }
        }
        return index;

    }

    public static int[] shuffle(int[] nums, int n) {

        int p = n;
        int[] ans = new int[2 * n];
        int index = 0;
        for (int p1 = 0; p1 < n; p1++, p++) {
            ans[index] = nums[p1];
            ans[index + 1] = nums[p];
            index = index + 2;
        }

        return ans;
    }

    public static List<Integer> getRow(int rowIndex) {

        List<List<Integer>> bucket = new ArrayList<>();
        int row = 0;
        int cell = 0;
        while (row <= rowIndex) {
            if (row == 0) {
                List<Integer> t1 = new ArrayList<>();
                t1.add(1);
                bucket.add(t1);
                row++;
                continue;
            } else if (row == 1) {
                List<Integer> t1 = new ArrayList<>();
                t1.add(1);
                t1.add(1);
                bucket.add(t1);
                row++;
                continue;
            }
            List<Integer> l = new ArrayList<>();
            while (bucket.get(row - 1).size() >= cell) {
                if (cell == 0 || cell == bucket.get(row - 1).size()) {
                    l.add(1);
                } else {
                    l.add(bucket.get(row - 1).get(cell) + bucket.get(row - 1).get(cell - 1));
                }
                cell++;
            }
            bucket.add(l);
            cell = 0;
            row++;
        }

        return bucket.get(rowIndex);
    }


    public static boolean isPalindrome(String s) {

        int lastIndex = s.length() - 1;
        int firstIndex = 0;
        int is = (lastIndex + 1) % 2;
        while (is == 0 ? lastIndex >= firstIndex : lastIndex > firstIndex) {
            while (!Character.isLetterOrDigit(s.charAt(firstIndex)) && lastIndex > firstIndex) {
                firstIndex++;
            }
            while (!Character.isLetterOrDigit(s.charAt(lastIndex)) && lastIndex > firstIndex) {
                lastIndex--;
            }
            if (Character.toLowerCase(s.charAt(firstIndex)) != Character.toLowerCase(s.charAt(lastIndex))) {
                return false;
            }
            lastIndex--;
            firstIndex++;
        }

        return true;
    }

    public static int singleNumber(int[] nums) {

        Set<Integer> list = new HashSet<>();

        for (int num : nums) {
            if (list.contains(num)) {
                list.remove(num);
            } else {
                list.add(num);
            }
        }

        return list.iterator().next();
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            //利用对象地址方式判断是否有公共点
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;




        /*Set<ListNode> set = new HashSet<>();

        ListNode temp1 = headA;
        while (temp1 != null){
            set.add(temp1);
            temp1 = temp1.next;
        }


        ListNode temp2 = headB;
        while (temp2 != null){
            if (set.contains(temp2)){
                return temp2;
            }
            temp2 = temp2.next;
        }

        return null;*/

    }


    public String convertToTitle(int columnNumber) {

        StringBuilder stringBuilder = new StringBuilder();
        while (columnNumber > 0) {
            int a0 = (columnNumber - 1) % 26 + 1;
            stringBuilder.append((char) (a0 - 1 + 'A'));
            columnNumber = (columnNumber - a0) / 26;
        }

        return stringBuilder.reverse().toString();

    }


    public int numComponents(ListNode head, int[] nums) {

        int res = 0;
        boolean isIns = false;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        while (head != null) {
            if (numSet.contains(head.val)) {
                if (!isIns) {
                    isIns = true;
                    res++;
                }
            } else {
                isIns = false;
            }
            head = head.next;
        }

        return res;

    }

    public int majorityElement(int[] nums) {

        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (candidate != num) {
                count--;
            } else {
                count++;
            }
        }

        return candidate;

    }

    public static int titleToNumber(String columnTitle) {

        int number = 0;
        int multiple = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int k = columnTitle.charAt(i) - 'A' + 1;
            number += k * multiple;
            multiple *= 26;
        }
        return number;

    }


    public static int longestPalindromeInt(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        boolean isPlus = false;
        int res = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            res = res + entry.getValue() / 2;
            if (!isPlus && entry.getValue() % 2 > 0) {
                isPlus = true;
            }
        }

        return res * 2 + (isPlus ? 1 : 0);
    }


    public static boolean isHappy(int n) {

        //判断是否存在环
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if (n < 10) {
                n = n * n;
                continue;
            }

            int t = 0;
            while (n > 0) {
                t = t + (n < 10 ? n * n : (n % 10) * (n % 10));
                n = n < 10 ? 0 : n / 10;
            }

            if (set.contains(t)) {
                return false;
            } else {
                set.add(t);
            }

            n = t;
        }

        return true;
    }

    public static int countStudents(int[] students, int[] sandwiches) {

        Queue<Integer> studentQueue = new LinkedList<>();
        int len = sandwiches.length;
        for (int i = 0; i < len; i++) {
            studentQueue.offer(students[i]);
        }

        for (int i = 0; i < len; i++) {
            if (studentQueue.peek() == sandwiches[i]) {
                studentQueue.poll();
                continue;
            }

            int t = 0;
            int ssize = studentQueue.size();
            while (t <= ssize) {
                if (t == ssize) {
                    return ssize;
                }
                if (studentQueue.peek() == sandwiches[i]) {
                    studentQueue.poll();
                    break;
                } else {
                    int c = studentQueue.poll();
                    studentQueue.offer(c);
                }
                t++;
            }
        }

        return 0;

    }

    public static boolean isIsomorphic(String s, String t) {

        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
            }
        }

        return true;
    }


    public static int partitionDisjoint(int[] nums) {

        int n = nums.length;
        int leftMax = nums[0], leftPos = 0, curMax = nums[0];
        for (int i = 1; i < n - 1; i++) {
            curMax = Math.max(curMax, nums[i]);
            if (nums[i] < leftMax) {
                leftMax = curMax;
                leftPos = i;
            }
        }
        return leftPos + 1;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }

        return false;
    }

    public static List<String> summaryRanges(int[] nums) {
        int len = nums.length;
        List<String> list = new ArrayList<>();
        if (len == 0){
            return list;
        }

        if (len == 1){
            list.add(nums[0]+"");
            return list;
        }
        int start = nums[0];
        int end = nums[0];

        for (int i = 1; i < len; i++) {
            if (nums[i] == end + 1){
                end = end + 1;
            }else {
                if (start == end){
                    list.add(start+"");
                }else {
                    list.add(start + "->" + end);
                }
                start = nums[i];
                end = nums[i];
            }
            if (i == len - 1){
                if (start == end){
                    list.add(start+"");
                }else {
                    list.add(start + "->" + end);
                }
            }
        }


        return list;
    }

    public boolean isPalindrome(ListNode head) {

        if (head == null){
            return true;
        }
        ListNode firstHalfEnd = endOfFirstHalf(head);


    }

    public static ListNode endOfFirstHalf(ListNode head){


    }

    public static void main(String[] args) {
        System.out.println(
                summaryRanges(new int[]{0,2,3,4,6,8,9})
        );

    }


}