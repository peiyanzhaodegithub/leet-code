package com.pyz.leetcode.algorithm;

public class Day4 {

    public static void main(String[] args) {
        char[] s = new char[]{'a','b','c','D'};
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    /*编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。

    不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。

    示例 1：
    输入：s = ["h","e","l","l","o"]
    输出：["o","l","l","e","h"]

    示例 2：
    输入：s = ["H","a","n","n","a","h"]
    输出：["h","a","n","n","a","H"]

    提示：
            1 <= s.length <= 105
    s[i] 都是 ASCII 码表中的可打印字符*/

    public static void reverseString(char[] s) {

        int endP = s.length - 1;

        for (int i = 0; i < s.length / 2; i++) {
            char t = s[i];
            s[i] = s[endP];
            s[endP] = t;
            endP--;
        }

        System.out.println(s);
    }


    /*给定一个字符串s，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

    示例 1：
    输入：s = "Let's take LeetCode contest"
    输出："s'teL ekat edoCteeL tsetnoc"

    示例 2:
    输入： s = "God Ding"
    输出："doG gniD"

    提示：
            1 <= s.length <= 5 * 104
    s包含可打印的 ASCII 字符。
    s不包含任何开头或结尾空格。
    s里 至少 有一个词。
    s中的所有单词都用一个空格隔开。*/

    public static String reverseWords(String s) {

        StringBuilder stringBuilder = new StringBuilder();
        int p = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                for (int j = i - 1; j >= p; j--) {
                    char t = s.charAt(j);
                    stringBuilder.append(t);
                }
                stringBuilder.append(" ");
                p = i +1;
            }else if (i == len - 1){
                for (int j = i; j >= p; j--) {
                    char t = s.charAt(j);
                    stringBuilder.append(t);
                }
            }
        }
        return stringBuilder.toString();

    }


}
