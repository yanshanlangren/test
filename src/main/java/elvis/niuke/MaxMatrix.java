package elvis.niuke;

import java.util.Scanner;

public class MaxMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        sc.nextLine();
        String[] m = new String[r];
        for (int i = 0; i < r; i++) {
            m[i] = sc.nextLine();
        }
        int c = m[0].length();
        char[][] ch = new char[r][c];
        for (int i = 0; i < r; i++)
            ch[i] = m[i].toCharArray();
        int i = 0, j = 0, l = 0, max = 0;
        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                l = 0;
                boolean flag = true;
                while (i + l < r && j + l < c) {
                    for (int k = 0; k < l + 1; k++) {
                        if (ch[i + k][j + l] == '0') {
                            flag = false;
                            break;
                        }
                        if (ch[i + l][j + k] == '0') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        l++;
                        max = Math.max(l, max);
                    } else
                        break;
                }
            }
        }
        System.out.println(max * max);
    }
}
