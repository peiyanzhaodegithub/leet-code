package com.pyz.leetcode.datastructure;

import java.util.*;

public class Day9 {

    public static void main(String[] args) {
        System.out.println(isValid("(("));
    }


    public static boolean isValid(String s) {

        if (s.length() == 0) {
            return true;
        } else if (s.length() == 1) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> s1 = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                s1.add(c);
            } else {
                if (s1.isEmpty() || !map.get(s1.pop()).equals(c)) {
                    return false;
                }
            }
        }

        return s1.isEmpty();
    }

    public static class MyQueue {

        Deque<Integer> s1;
        Deque<Integer> s2;

        public MyQueue() {
            s1 = new ArrayDeque<>();
            s2 = new ArrayDeque<>();
        }

        public void push(int x) {
            s1.push(x);
        }

        public int pop() {
            if (s2.isEmpty()){
                inOut();
            }
            return s2.pop();
        }

        public int peek() {
            if (s2.isEmpty()){
                inOut();
            }
            return s2.peek();
        }

        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }

        private void inOut(){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
    }

}
