package elvis.leetcode;

/**
 * StringBuffer和StringBuilder的区别:
 * StringBufferd支持并发操作，线性安全的，适 合多线程中使用。StringBuilder不支持并发操作，线性不安全的，不适合多线程中使用。
 * StringBuilder类不是线程安全的，但其在单线程中的性能比StringBuffer高
 */
public class Convert {
    public String convert(String s, int numRows) {
        StringBuilder[] res = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++)
            res[i] = new StringBuilder();
        int index = 0, bufferIndex = 0;
        boolean reverse = false;
        while (index < s.length()) {
            res[bufferIndex % numRows].append(s.charAt(index));
            index++;

            if (reverse)
                bufferIndex--;
            else
                bufferIndex++;
            if (bufferIndex % numRows == numRows - 1)
                reverse = true;
            if (bufferIndex % numRows == 0)
                reverse = false;
        }
        for (int i = 1; i < numRows; i++)
            res[0].append(res[i]);
        return res[0].toString();
    }

    public static void main(String[] args) {
        Convert c = new Convert();
//        System.out.println(c.convert("PAYPALISHIRING", 3));
//        System.out.println(c.convert("PAYPALISHIRING", 4));
//        System.out.println(c.convert("A", 1));
        System.out.println(c.convert("AB", 1));
    }
}
