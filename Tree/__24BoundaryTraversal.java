import java.util.ArrayList;
import java.util.Collections;

public class __24BoundaryTraversal {
    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree {
        static int idx = -1;

        public static Node constructTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
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
        private static void leftNodes(Node root, ArrayList<Integer> res){
            Node curr = root;
            while(curr!=null){
                if(!isLeaf(curr)){
                    res.add(curr.data);
                }

                if(root.left!=null){
                    curr = curr.left;
                }else{
                    curr = curr.right;
                }
            }
        }

        private static void leafNodes(Node root, ArrayList<Integer> res){
            if(root == null) return;

            if(root.left == null && root.right == null){
                res.add(root.data);
                return;
            }
            leafNodes(root.left, res);
            leafNodes(root.right, res);
            
        }

        private static void rightNodes(Node root, ArrayList<Integer> res){
            ArrayList<Integer> temp = new ArrayList<>();
            Node curr = root;
            while(curr!=null){
                if(!isLeaf(curr)){
                    temp.add(curr.data);
                }

                if(root.right!=null){
                    curr = curr.right;
                }else{
                    curr = curr.left;
                }
            }
            Collections.reverse(temp);
            for(int val : temp){
                res.add(val);
            }
        }
        private static boolean isLeaf(Node root){
            return root.left == null && root.right == null;
        }

        public static ArrayList<Integer> boundaryTraversal(Node root){
            ArrayList<Integer> res = new ArrayList<>();
            if(root == null) return res;
            if(isLeaf(root)){
                res.add(root.data);
                return res;
            }
            res.add(root.data);
            leftNodes(root.left, res);
            leafNodes(root, res);
            rightNodes(root.right, res);
            return res;
        }

         
    }

    public static void main(String[] args) {
        int arr[] = { 20, 8, 4, -1, -1, 12, 10, -1, -1, 14, -1, -1, 22, -1, 25, -1, -1 };
       
        Node root = BinaryTree.constructTree(arr);
        BinaryTree.printTree(root);
        ArrayList<Integer> res =  BinaryTree.boundaryTraversal(root);
        System.out.println(res);
    }
}
