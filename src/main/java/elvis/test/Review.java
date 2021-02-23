package elvis.test;

public class Review {
    public String stringTimes(String a, String b) {
        char[] a_arr = a.toCharArray();
        char[] b_arr = b.toCharArray();
        int length = a_arr.length + b_arr.length;
        int[] sum = new int[length];

        //calculate
        for (int i = a_arr.length - 1; i >= 0; i--)
            for (int j = b_arr.length - 1; j >= 0; j--)
                sum[a_arr.length + b_arr.length - i - j - 2] += (a_arr[i] - '0') * (b_arr[j] - '0');

        //num to char
        char[] result = new char[length + 1];
        int carry = 0;
        for (int i = 0; i < sum.length; i++) {
            result[i] = (char) (((sum[i] + carry) % 10) + '0');
            carry = (sum[i] + carry) / 10;
        }
        result[length] = (char) carry;

        //result reverse
        char[] result_rev = new char[result.length];
        for (int j = 0; j < result.length; j++)
            result_rev[j] = result[result.length - 1 - j];
        return String.valueOf(result_rev);
    }

    public static void main(String[] args) {
        Review r = new Review();
        System.out.println(r.stringTimes("11", "12"));
    }
}
