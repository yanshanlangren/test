package elvis.niuke;

import java.util.Scanner;

public class Revert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int i = str.length() - 1;
        while (i >= 0) {
            System.out.print(str.charAt(i--));
        }
    }
}
