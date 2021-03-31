package elvis.leetcode;

public class Calculate {
    public int calculate(String s) {
        int i = 0, register = 0, add = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
                continue;
            }
            if (c == '(') {
                int j, count = 1;
                for (j = i + 1; j < s.length() - 1; j++) {
                    if (s.charAt(j) == '(')
                        count++;
                    if (s.charAt(j) == ')') {
                        count--;
                        if (count == 0)
                            break;
                    }
                }
                if (add >= 0)
                    register += calculate(s.substring(i + 1, j));
                else
                    register -= calculate(s.substring(i + 1, j));
                i = j + 1;
                continue;
            }
            if (c == '+')
                add = 1;
            if (c == '-')
                add = -1;
            if (c <= '9' && c >= '0') {
                int j = i + 1;
                while (j < s.length() && s.charAt(j) <= '9' && s.charAt(j) >= '0') {
                    j++;
                }
                if (add >= 0)
                    register += Integer.parseInt(s.substring(i, j));
                else
                    register -= Integer.parseInt(s.substring(i, j));
                i = j;
                continue;
            }
            i++;
        }
        return register;
    }

    public static void main(String[] args) {
        Calculate c = new Calculate();
//        System.out.println(c.calculate("2+3"));
        System.out.println(c.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
