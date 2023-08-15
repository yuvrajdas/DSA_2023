import java.util.ArrayList;

public class __13NodeToLeafPath {
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

            Node newnoNode = new Node(nodes[idx]);
            newnoNode.left = constructTree(nodes);
            newnoNode.right = constructTree(nodes);

            return newnoNode;
        }

        public static void printTree(Node root){
            if(root == null) return;
            String str = "";

            str+=root.left!=null?root.left.data : "null";
            str+=" <- "+root.data+" -> ";
            str+=root.right!=null?root.right.data : "null";
            System.out.println(str);

            printTree(root.left);
            printTree(root.right);
        }

        static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        public static void rootToLeafPath(Node root, ArrayList<Integer> list){
            if(root == null) return;
            ArrayList<Integer> newList = new ArrayList<>(list);
            newList.add(root.data);
            if(root.left == null && root.right == null){
                res.add(newList);
            }
           
            rootToLeafPath(root.left, newList);
            rootToLeafPath(root.right, newList);
        }
        public static void printRes(){
            System.out.println(res);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,-1,-1,3,-1,-1};
        BinaryTree bt = new BinaryTree();
        Node root = bt.constructTree(arr);

        // bt.printTree(root);
        bt.rootToLeafPath(root, new ArrayList<>());
       bt.printRes();
        
    }
}
