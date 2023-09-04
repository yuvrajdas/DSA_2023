import java.util.*;

public class __26LeftViewOfBinaryTree {
    
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;    
        }
    }

    public static class BinaryTree{
        static int idx = -1;

        public static Node constructTree(int nodes[]){
            idx++;

            if(nodes[idx] == -1) return null;

            Node newNode  = new Node(nodes[idx]);
            newNode.left = constructTree(nodes);
            newNode.right = constructTree(nodes);

            return newNode;
        }

        public static void printTree(Node root){
            if(root == null) return;

            String res = "";
            res+=root.left!=null?root.left.data :"null";
            res+="<-"+root.data+"->";
            res+=root.right!=null?root.right.data :"null";

            System.out.println(res);
            printTree(root.left);
            printTree(root.right);
        }

        public static ArrayList<Integer> leftSideView(Node root){
            ArrayList<Integer> res = new ArrayList<>();
            Queue<Node> que = new ArrayDeque<>();

            if(root == null) return res;
            que.add(root);

            while(que.size()>0){
                int count = que.size();
                Node pn = que.peek();
                res.add(pn.data);

                for(int i=0; i<count; i++){
                    Node rNode = que.remove();

                    if(rNode.left!=null) que.add(rNode.left);
                    if(rNode.right!=null) que.add(rNode.right);
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int arr[] = {1,2,-1,5,-1,-1,3,-1,4,-1,-1};
        Node root = bt.constructTree(arr);
        // bt.printTree(root);
        // Left view should be => 1, 2, 5

        ArrayList<Integer> res = bt.leftSideView(root);
        System.out.println(res);
    }
}
