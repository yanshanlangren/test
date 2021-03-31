package elvis.leetcode;

import java.util.Arrays;

public class MyHashSet extends Object {
    int[] col;
    int size, cap;

    public MyHashSet() {
        col = new int[16];
        cap = 16;
        size = 0;
    }

    private void checkSize() {
        if (size + 1 > 0.75 * cap) {
            int[] tmp = new int[cap * 2];
            Arrays.fill(tmp, Integer.MAX_VALUE);
            System.arraycopy(col, 0, tmp, 0, cap);
            col = tmp;
            cap *= 2;
        }
    }

    public void add(int key) {
        checkSize();
        for (int i = 0; i < size; i++) {
            if (key == col[i])
                return;
        }
        col[size++] = key;
    }

    public void remove(int key) {
        for (int i = 0; i < size; i++) {
            if (key == col[i]) {
                System.arraycopy(col, i + 1, col, i, size - i - 1);
                size--;
                return;
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        for (int i = 0; i < size; i++)
            if (col[i] == key)
                return true;
        return false;
    }

    public static void main(String[] arags) {
        MyHashSet mhs = new MyHashSet();
        mhs.add(1);
        mhs.add(2);
        System.out.println(mhs.contains(1));
        System.out.println(mhs.contains(3));
        mhs.add(2);
        System.out.println(mhs.contains(2));
        mhs.remove(2);
        System.out.println(mhs.contains(2));
    }
}
