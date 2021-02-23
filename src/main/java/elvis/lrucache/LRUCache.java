package elvis.lrucache;


public class LRUCache {
    class Node {
        Node next;
        String key;
        int index;
    }

    private Node head = null;
    private Node tail = null;
    private String[] data = null;

    public LRUCache(int n) {
        this.data = new String[n];
        this.head = new Node();
        this.head.key = "";
        this.data[this.head.index] = "";
        Node pre_node = this.head;
        Node current_node = null;
        for (int i = 1; i < n; i++) {
            current_node = new Node();
            current_node.key = "";
            this.data[current_node.index] = "";
            current_node.index = i;
            pre_node.next = current_node;
            pre_node = current_node;
        }
        this.tail = current_node;
        this.tail.next = null;
    }

    public void Add(String key, String value) {
        Node current_node = this.head;
        while (current_node.next != null) {
            if (current_node.key.equals(key) || current_node.key.equals("")) {
                current_node.key = key;
                this.data[current_node.index] = value;
                return;
            }
            current_node = current_node.next;
        }


        // delete least recent use node
        tail.key = key;
        this.data[tail.index] = value;

        Node old_head = head;
        head = tail;
        head.next = old_head;
        tail = current_node;
        tail.next = null;
    }

    public String Get(String key) {
        Node current_node = this.head;
        while (current_node.next != null) {
            if (current_node.key.equals(key)) {
                return this.data[current_node.index];
            }
        }
        return "No such node";
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.Add("a", "a");
        cache.Add("b", "b");
        cache.Add("c", "c");
        System.out.println(cache.Get("b"));
    }
}
