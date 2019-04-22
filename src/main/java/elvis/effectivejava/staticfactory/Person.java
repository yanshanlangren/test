package elvis.effectivejava.staticfactory;

public class Person {
    /**
     * 静态工厂相较于构造器的优势:
     * 1.静态工厂有方法名, 使用者可以轻易知道调用的是什么工厂, 得到什么实例, 而构造器不行
     * 2.静态工厂创建的时候不一定需要创建新的对象, 而构造器必定会创建新的对象
     * 3.静态工厂可以返回任何子类的对象, 而构造器只能返回该类对象
     */
    private String name;
    private String sex;
    private int age;
    static Person newPersonWithName(String name){
        Person p = new Person();
        p.name = name;
        return p;
    }
}
