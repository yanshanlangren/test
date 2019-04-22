package elvis.lamda;

import elvis.interfaces.DefaultTest;

public class DefaultTestImpl implements DefaultTest {

    @Override
    public void test1() {
        System.out.println("this is test1 implemented by DefaultTestImpl.");
    }

    @Override
    public void test2(){
        System.out.println("test2 implemented by Impl");
    }

    public static void main(String[] args){
        DefaultTest dt = new DefaultTestImpl();
        dt.test1();
        dt.test2();
    }
}
