package elvis.leetcode;

import java.util.Stack;

class MyQueue {
    Stack<Integer> s, r;

    public MyQueue() {
        s = new Stack<>();
        r = new Stack<Integer>();
    }

    public void push(int x) {
        s.push(x);
    }

    public int pop() {
        if (r.empty()) {
            while (!s.empty())
                r.push(s.pop());
        }
        return r.pop();
    }

    public int peek() {
        if (r.empty()) {
            while (!s.empty())
                r.push(s.pop());
        }
        return r.peek();
    }

    public boolean empty() {
        return r.empty() && s.empty();
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.empty());
    }
}
