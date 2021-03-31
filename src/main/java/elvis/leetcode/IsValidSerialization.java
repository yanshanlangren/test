package elvis.leetcode;

public class IsValidSerialization {
    public class Node {
        int val;
        Node l, r;

        public Node(int v){
            this.val = v;
        }
    }

    public boolean isValidSerialization(String preorder) {
        String[] seq = preorder.split(",");
        Node head = new Node(Integer.parseInt(seq[0]));
        Node pre = head, pa = head;
        for(int i=0;i<seq.length;i++){
            if(seq[i].equals("#")){
//                if(pre == null)

            }

        }
        return false;
    }
    public void search(Node n){

    }
}
