import java.util.ArrayList;

public class __10NodeToRootPathBinaryTree {
    
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

    static ArrayList<Integer> path;
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

        public static boolean nodeToRootPath(Node root, int val){
            if(root == null) return false;

            if(root.data == val) {
                path.add(root.data);
                return true;
            }

            boolean lc = nodeToRootPath(root.left, val);
            if(lc) {
                path.add(root.data);
                return true;
            }


            boolean rc = nodeToRootPath(root.right, val);
            if(rc) {
                path.add(root.data);
                return true;
            }

            return false;
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        path = new ArrayList<>();

        BinaryTree bt = new BinaryTree();
        Node root = bt.constructTree(arr);
        bt.nodeToRootPath(root, 6);
        System.out.println(path);
    }
}
