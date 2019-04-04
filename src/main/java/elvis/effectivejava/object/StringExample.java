package elvis.effectivejava.object;

public class StringExample {

    public static void main(String[] args){
        String a1 = "wocao";
        String a2 = new String("wocao");
        System.out.println(a1 == a2);
        System.out.println(a1.intern() == a2.intern());
    }
}
