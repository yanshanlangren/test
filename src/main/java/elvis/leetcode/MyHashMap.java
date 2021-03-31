package elvis.leetcode;

class MyHashMap {

    class Node {
        int k, v;
        Node next;

        public Node(int key, int value) {
            this.k = key;
            this.v = value;
        }
    }

    Node[] data;
    int size;

    public MyHashMap() {
        data = new Node[8196];
        size = 8196;
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int k = key & (size - 1);
        if (data[k] == null)
            data[k] = new Node(key, value);
        else {
            Node cur = data[k], pre = cur;
            while (cur != null) {
                if (cur.k == key) {
                    cur.v = value;
                    return;
                }
                pre = cur;
                cur = cur.next;
            }
            pre.next = new Node(key, value);
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int k = (size - 1) & key;
        Node cur = data[k];
        while (cur != null && cur.k != key) {
            cur = cur.next;
        }
        if (cur != null)
            return cur.v;
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int k = (size - 1) & key;
        Node cur = data[k];
        if (cur == null || (cur.k == key && cur.next == null)) {
            data[k] = null;
        } else if (cur.k == key) {
            data[k] = cur.next;
        } else {
            Node pre = cur;
            cur = cur.next;
            while (cur != null) {
                if (cur.k == key) {
                    pre.next = cur.next;
                    return;
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(3));
        myHashMap.put(2, 1);
        System.out.println(myHashMap.get(2));
        myHashMap.remove(2);
        System.out.println(myHashMap.get(2));
        myHashMap.put(17, 3);
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(17));
    }
}
