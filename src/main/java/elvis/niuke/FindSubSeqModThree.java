package elvis.niuke;

import java.util.Scanner;

public class FindSubSeqModThree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        int[] in = new int[inp.length()];
        for (int i = 0; i < inp.length(); i++) {
            in[i] = inp.charAt(i) - '0';
        }
        int[] total = new int[inp.length()];
        int sum = in[0];
        total[0] = in[0] % 3 == 0 ? 1 : 0;
        for (int i = 1; i < in.length; i++) {
            total[i] = total[i - 1];
            if (in[i] % 3 == 0)
                total[i]++;
            sum += in[i];
            if (sum % 3 == 0)
                total[i]++;
        }
        System.out.println(total[inp.length() - 1]);
    }
}
