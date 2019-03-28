package elvis.collection;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MyMap implements Map {

    private Object[] keys;

    private Object[] values;

    private int count;

    public MyMap(){
        count = 0;
        keys = new Object[2^30];
        values = new Object[2^30];
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count>0;
    }

    @Override
    public boolean containsKey(Object key) {
        return keyIndex(key)>-1;
    }

    @Override
    public boolean containsValue(Object value) {
        for(int i=0;i<count;i++)
            if(values[i].equals(value)){
                return true;
            }
        return false;
    }

    private int keyIndex(Object key){
        for(int i=0;i<count;i++)
            if(key.equals(keys[i])){
                return i;
            }
        return -1;
    }

    @Override
    public Object get(Object key) {
        int index = keyIndex(key);
        if(index>-1)
            return values[index];
        return null;
    }

    @Override
    public Object put(Object key, Object value) {

        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }

    @Override
    public Object getOrDefault(Object key, Object defaultValue) {
        return null;
    }

    @Override
    public void forEach(BiConsumer action) {

    }

    @Override
    public void replaceAll(BiFunction function) {

    }

    @Override
    public Object putIfAbsent(Object key, Object value) {
        return null;
    }

    @Override
    public boolean remove(Object key, Object value) {
        return false;
    }

    @Override
    public boolean replace(Object key, Object oldValue, Object newValue) {
        return false;
    }

    @Override
    public Object replace(Object key, Object value) {
        return null;
    }

    @Override
    public Object computeIfAbsent(Object key, Function mappingFunction) {
        return null;
    }

    @Override
    public Object computeIfPresent(Object key, BiFunction remappingFunction) {
        return null;
    }

    @Override
    public Object compute(Object key, BiFunction remappingFunction) {
        return null;
    }

    @Override
    public Object merge(Object key, Object value, BiFunction remappingFunction) {
        return null;
    }
}
