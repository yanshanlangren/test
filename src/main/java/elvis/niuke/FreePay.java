package elvis.niuke;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class FreePay {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        HashMap<Date, Integer> m = new HashMap<>();
        HashMap<Date, Integer> c = new HashMap<>();
        int count = 0;
        while (sc.hasNext()) {
            String str = sc.nextLine();
            Date d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str.substring(0, 19));
            int ms = Integer.parseInt(str.substring(20, 23));
            if (m.containsKey(d)) {
                if (ms == m.get(d)) {
                    count++;
                    c.put(d, c.get(d) + 1);
                } else if (ms < m.get(d)) {
                    m.put(d, ms);
                    count -= c.get(d) - 1;
                    c.put(d, 1);
                }
            } else {
                count++;
                m.put(d, ms);
                c.put(d, 1);
            }
        }
        System.out.println(count);
    }
}
