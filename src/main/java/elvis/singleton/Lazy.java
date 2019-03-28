package elvis.singleton;

/**
 * 懒汉式
 * 需要对象时初始化
 * 线程不安全
 */
public class Lazy {
    private static Lazy instance = null;

    private static int count = 0;

    public static Lazy getInstance() {
        if(null == instance) {
            System.out.println("第"+count+++"次初始化lazy对象");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Lazy();
        }
        return instance;
    }


    public static void main(String[] args){
        for(int i=0;i<100;i++){
            new Thread(){
                @Override
                public void run(){
                    Lazy.getInstance();
                }
            }.start();
        }
    }
}
