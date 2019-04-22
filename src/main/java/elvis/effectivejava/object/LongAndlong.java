package elvis.effectivejava.object;

public class LongAndlong {
    public static void main(String[] args){
        long sum = 0L;
        long t1 = System.currentTimeMillis();
        for(int i = 0;i<Integer.MAX_VALUE;i++){
            sum+=i;
        }
        long t2 = System.currentTimeMillis();
        System.out.println("sum = "+sum);
        System.out.println("Total time cost: "+(t2-t1)*1.0/1000+" seconds");
    }
}
