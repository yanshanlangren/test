package elvis.lamda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LamdaTest {

    List<String> list = Arrays.asList("aaa","fsa","ser","eere");

    /**
     * 不带lamda
     */
    public void test1(){
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for (String string : list) {
            System.out.println(string);
        }
    }

    /**
     * 带参数的lamda
     */
    public void testLamda1(){
        Collections.sort(list,(Comparator<? super String>) (String a, String b) ->{
            return b.compareTo(a);
        });
        for (String string : list) {
            System.out.println(string);
        }
    }

    /**
     * 不带参数的lamda
     */
    public void testLamda2(){
        Collections.sort(list, (a,b)->{
            return b.compareTo(a);
        });
        for (String string : list) {
            System.out.println(string);
        }
    }

    public static void main(String[] args){
//        System.out.println("1231".compareTo("1229"));
        LamdaTest lt = new LamdaTest();
        long t1 = System.currentTimeMillis();
        lt.test1();
        long t2 = System.currentTimeMillis();
        System.out.println("time spend: "+(t2-t1));
    }
}
