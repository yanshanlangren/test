package elvis.singleton;

/**
 * 双捡锁懒汉式
 *
 */
public class DoubleCheckLazy {

    private static DoubleCheckLazy instance = null;
    public static DoubleCheckLazy getInstance(){
        if(null == instance){
            synchronized (DoubleCheckLazy.class){
                if(null == instance){
                    instance = new DoubleCheckLazy();
                }
            }
        }
        return instance;
    }
}
