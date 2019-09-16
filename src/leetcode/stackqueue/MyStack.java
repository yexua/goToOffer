package leetcode.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用队列实现栈的下列操作：
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 *
 * 方法一 （两个队列，压入 -O(1)O(1)， 弹出 -O(n)O(n)）
 * 方法二 （两个队列， 压入 - O(n)O(n)， 弹出 - O(1)O(1)）
 * 方法三 （一个队列， 压入 - O(n)O(n)， 弹出 - O(1)O(1)）
 */
public class MyStack {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
    }


    private Queue<Integer> in = new LinkedList<>();
    private Queue<Integer> out = new LinkedList<>();

    /**
     * Initialize your data structure here.
     */
    public MyStack() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        in.offer(x);
        while(!out.isEmpty()){
            in.offer(out.poll());
        }
        Queue<Integer> temp = in;
        in = out;
        out = temp;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return out.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return out.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return out.isEmpty();
    }
}
