package elvis.classloader;

public class Derived extends Base{
    static String derivedStaticPara = init("子类静态变量");
    static {
        System.out.println("子类静态代码块");
    }

    String derivedNormalPara = Base.init("子类普通变量");

    {
        System.out.println("子类普通代码块");
    }

    public Derived(){
        System.out.println("子类构造函数");
    }
}
