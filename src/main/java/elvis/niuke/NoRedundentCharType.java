package elvis.niuke;

import java.util.Scanner;

public class NoRedundentCharType {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] co = new int[128];
        int t = 0;
        for (char c : s.toCharArray()) {
            if (co[c] == 0) {
                t++;
            }
            co[c]++;
        }
        System.out.println(t);
    }
}
