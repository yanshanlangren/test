package elvis.interfaces;

public interface DefaultTest {
    public void test1();

    public default void test2(){
        System.out.println("这是default新特性");
    }

    public static void test3(){
        System.out.println("这是test3");
    }

    static void asd(){
        System.out.println();
    }
}
