package elvis.lamda;

import elvis.interfaces.LamdaInterfaceTest;
import java.util.Arrays;
import java.util.List;

public class LamdaInterfaceTester{
    public static void main(String[] args){
        LamdaInterfaceTest m = y -> System.out.println("ss:"+y);
        LamdaInterfaceTest m1 = System.out::println;

        List<String> list = Arrays.asList("aaa","fsa","ser","eere");

        m.test1("asdasd");
        System.out.println(m.test2());

        m1.test1("this is m1.test1");
//        list.forEach();
    }
}
