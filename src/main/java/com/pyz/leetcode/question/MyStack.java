package com.pyz.leetcode.question;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    int index = 0;

    public MyStack() {

    }

    public void push(int x) {
        if (!queue1.isEmpty()) {
            queue1.add(x);
        } else {
            queue2.add(x);
        }
        index++;
    }

    public int pop() {

        if (!queue1.isEmpty()) {
            for (int i = 1; i <= index; i++) {
                if (i == index) {
                    index--;
                    return queue1.poll();
                }
                queue2.add(queue1.poll());
            }
        } else {
            for (int i = 1; i <= index; i++) {
                if (i == index) {
                    index--;
                    return queue2.poll();
                }
                queue1.add(queue2.poll());
            }
        }

        return 0;
    }

    public int top() {

        int v = 0;
        if (!queue1.isEmpty()) {
            for (int i = 1; i <= index; i++) {

                if (i == index) {
                    v = queue1.peek();
                }
                queue2.add(queue1.poll());
            }
        } else {
            for (int i = 1; i <= index; i++) {

                if (i == index) {
                    v = queue2.peek();
                }
                queue1.add(queue2.poll());
            }
        }

        return v;

    }

    public boolean empty() {

        return queue1.isEmpty() && queue2.isEmpty();
    }


}
