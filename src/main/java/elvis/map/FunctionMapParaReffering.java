package elvis.map;

import java.util.HashMap;
import java.util.Map;

public class FunctionMapParaReffering {

    private String name = "";

    public static void MapFunction(Map m) {
        m.put("key", "qqq");
    }

    public static void ObjectFunction(FunctionMapParaReffering o) {
        o.name = "new name";
    }

    public static void BaseFunction(int i) {
        i = 2;
    }

    public static void WrappedBaseFunction(Integer i) {
        i = 2;
    }

    public static void main(String[] args) {
//        Map<String, String> hashMap = new HashMap<String, String>();
//        MapFunction(hashMap);
//        for (String key : hashMap.keySet()) {
//            System.out.println("key[" + key + "],value[" + hashMap.get(key) + "]");
//        }

//        FunctionMapParaReffering o = new FunctionMapParaReffering();
//        ObjectFunction(o);
//        System.out.println(o.name);

//        int i = 10;
//        BaseFunction(i);
//        System.out.println(i);

        Integer i = 10;
        BaseFunction(i);
        System.out.println(i);
    }
}
