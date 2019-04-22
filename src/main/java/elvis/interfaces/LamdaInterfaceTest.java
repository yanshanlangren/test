package elvis.interfaces;

@FunctionalInterface
public interface LamdaInterfaceTest {
    public void test1(String y);

    default String test2(){
        return "123";
    }

    default String test3(){
        return "321";
    }

    static void test4(){
        System.out.println("234");
    }
}
