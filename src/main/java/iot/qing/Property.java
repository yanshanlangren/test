package iot.qing;

/**
 * 属性
 * @param <A> 属性key值类型
 * @param <B> 属性value类型
 */
public class Property<A,B> {
    A key;
    B value;

    public A getKey(){
        return key;
    }

    public B getValue(){
        return value;
    }

    public static <A,B> Property<A,B> newInstance(A key, B value){
        Property<A,B> p = new Property();
        p.key = key;
        p.value = value;
        return p;
    }
}
