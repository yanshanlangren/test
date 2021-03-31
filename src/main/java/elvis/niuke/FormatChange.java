package elvis.niuke;

import java.util.Scanner;

public class FormatChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string;
        while (sc.hasNext()) {
            string = sc.nextLine();
            if (!string.substring(0, 2).equals("0x")) {
                return;
            }
            String str16 = string.substring(2, string.length());
            char[] ch = str16.toCharArray();
            int len = str16.length(), carry = 0;
            int[] ans = new int[len + 2];
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len + 2; j++) {
                    ans[j] = 16 * ans[j] + carry;
                    carry = ans[j] / 10;
                    ans[j] = ans[j] % 10;
                }
                if (ch[i] <= 'F' && ch[i] >= 'A')
                    ans[0] += ch[i] - 'A' + 10;
                else if (ch[i] <= '9' && ch[i] >= '0')
                    ans[0] += ch[i] - '0';
            }
            for (int j = 0; j < len + 2; j++) {
                int tmp = ans[j] + carry;
                ans[j] = tmp % 10;
                carry = tmp / 10;
            }
            StringBuffer sb = new StringBuffer();
            int i = ans.length - 1;
            while (ans[i] == 0)
                i--;
            for (; i >= 0; i--)
                sb.append(ans[i]);
            System.out.println(sb.toString());
        }
    }
}
