import java.util.*;

public class __28MaxWidthOfBinaryTree {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public static class Pair{
        Node mwNode;
        int idx;

        Pair(Node mwNode, int idx){
            this.mwNode = mwNode;
            this.idx = idx;
        }
    }

    public static class BinaryTree {
        static int idx = -1;

        public static Node constructTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1)
                return null;

            Node newNode = new Node(nodes[idx]);
            newNode.left = constructTree(nodes);
            newNode.right = constructTree(nodes);

            return newNode;
        }

        public static void printTree(Node root) {
            if (root == null)
                return;

            String res = "";
            res += root.left != null ? root.left.data : "null";
            res += "<-" + root.data + "->";
            res += root.right != null ? root.right.data : "null";

            System.out.println(res);

            printTree(root.left);
            printTree(root.right);
        }
        public static void widthOfBinaryTree(Node root){
           Queue<Pair> que = new ArrayDeque<>();
           int max = 0;
           que.add(new Pair(root, 0));
            
           while(que.size()>0){
            int count = que.size();
            Pair leftTreeNode = que.peek();
            int lmost = leftTreeNode.idx;
            int rmost = leftTreeNode.idx;
            for(int i=0; i<count; i++){
                Pair rp = que.remove(); 
                rmost = rp.idx;

                if(rp.mwNode.left!=null) que.add(new Pair(rp.mwNode.left, 2*rp.idx+1));
                
                if(rp.mwNode.right!=null) que.add(new Pair(rp.mwNode.right, 2*rp.idx+2));
            }
            max = Math.max(max, rmost-lmost+1);
           }
           System.out.println(max);
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int arr[] = { 1, 3, 5, -1, -1, 3, -1, -1, 2, -1, 9, -1, -1 };
        Node root = bt.constructTree(arr);
        // bt.printTree(root);

        bt.widthOfBinaryTree(root);
        
    }
}