package elvis.lrucache;

public class LRUList {
    String[] list;
    int MAX_SIZE = 3;
    int count = 0;

    public void add(String o) {
        // check if exist
        for (int i = 0; i < count; i++)
            if (list[i].equals(o)) {
                touch(i);
                list[count - 1] = o;
                return;
            }
        //check capacity
        if (count < MAX_SIZE)
            list[count++] = o;
        else {
            pop();
            list[count - 1] = o;
        }
    }

    public String get(int index) {
        return list[index];
    }

    private void touch(int index) {
        System.arraycopy(list, index + 1, list, index, count - index - 1);
    }

    private void pop() {
        System.arraycopy(list, 1, list, 0, count - 1);
    }

    public static void main(String[] args){

    }
}
