import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class __23ZigZagLevelOrderTraversal {
    
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

            Node newNode = new Node(nodes[idx]);
            newNode.left = constructTree(nodes);
            newNode.right = constructTree(nodes);

            return newNode;
        }

        public static void printTree(Node root) {
            if (root == null)
                return;

            String str = "";
            str += root.left != null ? root.left.data : "null";
            str += " <- " + root.data + " -> ";
            str += root.right != null ? root.right.data : "null";
            System.out.println(str);

            printTree(root.left);
            printTree(root.right);
        }

        public static void zigZagTraversal(Node root){
            Queue<Node> que = new ArrayDeque<>();
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            ArrayList list;
            que.add(root);
            int level = 0;
            while(que.size()>0){
                int count = que.size();

                list = new ArrayList<>();
                for(int i=0; i<count; i++){
                    Node rNode = que.remove();
                
                    if(level%2 == 0){
                        list.add(rNode.data);
                    }else{
                        list.add(0, rNode.data);
                    }
                    
                    if(rNode.left!=null){
                        que.add(rNode.left);
                    }
                    if(rNode.right!=null){
                        que.add(rNode.right);
                    }
                }
                level++;
                res.add(list);
            }
            System.out.println(res);
        }
    }
    public static void main(String[] args) {
        int arr[] = {3,9,-1,-1,20,15,-1,-1,7,-1,-1};

        BinaryTree bt = new BinaryTree();
        Node root = bt.constructTree(arr);
        bt.printTree(root);
        bt.zigZagTraversal(root);
    }
}
