import java.util.*;
public class __29TopViewOfBinaryTree {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    public static class Pair{
        Node pNode;
        int hl;

        Pair(Node pNode, int hl){
            this.pNode = pNode;
            this.hl = hl;
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

        public static ArrayList<Integer> topViewOfBinaryTree(Node root){
            
            ArrayList<Integer> res = new ArrayList<>();
            Queue<Pair> que = new ArrayDeque<>();
            Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
            que.add(new Pair(root, 0));

            while(que.size()>0){
                int count = que.size();
                
                for(int i = 0; i<count; i++){
                    Pair rn = que.remove();


                }
            }
            return res;

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
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        Node root = BinaryTree.constructTree(arr);
        BinaryTree.printTree(root);
    }
}
