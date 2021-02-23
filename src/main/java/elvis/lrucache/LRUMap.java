package elvis.lrucache;

import java.util.HashMap;

public class LRUMap {
    HashMap<String, String> map = new HashMap();
    int count = 0;
    int MAX_SIZE = 3;
    String[] LRUList = new String[MAX_SIZE];

    private void touch(String key) {
        int i;
        for (i = 0; i < count; i++)
            if (LRUList[i].equals(key))
                break;
        System.arraycopy(LRUList, i + 1, LRUList, i, count - i - 1);
        LRUList[count - 1] = key;
    }

    private void pop() {
        map.remove(LRUList[0]);
        System.arraycopy(LRUList, 1, LRUList, 0, MAX_SIZE - 1);
    }

    public void set(String key, String value) {
        if (map.containsKey(key)) {
            touch(key);
        } else {
            if (count < MAX_SIZE) {
                LRUList[count++] = key;
            } else {
                pop();
                LRUList[MAX_SIZE - 1] = key;
            }
        }
        map.put(key, value);
    }

    public String get(String key) {
        if (map.containsKey(key)) {
            touch(key);
            return map.get(key);
        }
        return null;
    }

    public static void main(String[] args) {
        LRUMap l = new LRUMap();
        l.set("a", "hello");
        l.set("b", "world");
        l.set("c", "elvis");
        l.set("d", "ann");
        System.out.println(l.get("a"));
    }
}
