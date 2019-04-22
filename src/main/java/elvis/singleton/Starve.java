package elvis.singleton;

/**
 * 饿汉式
 * 对象建立时初始化,以空间换时间
 * 线程安全
 */
public class Starve {
    private static Starve instance = new Starve();

    public static Starve getInstance() {
        return instance;
    }
}
