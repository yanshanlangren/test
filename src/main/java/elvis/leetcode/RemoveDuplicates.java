package elvis.leetcode;

import java.util.Stack;

public class RemoveDuplicates {
    public String removeDuplicates(String S) {
        int i = 0;
        StringBuilder sb = new StringBuilder(S);
        while (i < sb.length()) {
            if (i + 1 < sb.length() && sb.charAt(i + 1) == sb.charAt(i)) {
                sb.delete(i, i + 2);
                if (i > 0)
                    i--;
            } else
                i++;
        }
        return sb.toString();
    }

    public String removeDuplicates_Other(String S) {
        Stack<Character> s = new Stack<Character>();
        for (char item : S.toCharArray()) {
            if (!s.empty() && s.peek() == item) {
                s.pop();
            } else {
                s.push(item);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!s.empty())
            sb.append(s.pop());
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicates rd = new RemoveDuplicates();
        System.out.println(rd.removeDuplicates_Other("abbaecbbca"));
    }
}
