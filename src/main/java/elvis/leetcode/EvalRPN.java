package elvis.leetcode;

import java.util.Stack;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        int i1, i2;
        for (String str : tokens) {
            switch (str) {
                case "+":
                    s.push(s.pop() + s.pop());
                    break;
                case "-":
                    i1 = s.pop();
                    i2 = s.pop();
                    s.push(i2 - i1);
                    break;
                case "*":
                    s.push(s.pop() * s.pop());
                    break;
                case "/":
                    i1 = s.pop();
                    i2 = s.pop();
                    s.push(i2 / i1);
                    break;
                default:
                    s.push(Integer.parseInt(str));
            }
        }
        return s.pop();
    }

    public static void main(String[] args) {
        EvalRPN e = new EvalRPN();
//        System.out.println(e.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
//        System.out.println(e.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(e.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
