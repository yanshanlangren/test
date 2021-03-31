package elvis.leetcode;

public class ToLowerCase {
    public String toLowerCase(String str) {
        char[] ch = new char[str.length()];
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) <= 'Z' && str.charAt(i) >= 'A')
                ch[i] = (char) (str.charAt(i) | 32);
            else
                ch[i] = str.charAt(i);
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        System.out.println(1 | 32);
//        ToLowerCase twc = new ToLowerCase();
//        System.out.println(twc.toLowerCase("Hello"));
    }
}
