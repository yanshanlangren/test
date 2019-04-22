package elvis.stackOverflow;

public class StackTest {
    private static int index = 0;

    public static void call(){
        index++;
//        System.out.println("index = "+index);
        call();
    }

    public static void main(String[] args){
        try{
            call();
        }catch(Throwable e){
//            e.printStackTrace();
//            System.out.println(e.getMessage());
            System.out.println("index is "+ index);
        }
    }

}
