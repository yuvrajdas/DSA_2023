public class __17TiltOfBinaryTree {
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

        public static void printList(Node root) {
            if (root == null)
                return;
            String str = "";
            str += root.left != null ? root.left.data : "null";
            str += " <- " + root.data + " -> ";
            str += root.right != null ? root.right.data : "null";
            System.out.println(str);

            printList(root.left);
            printList(root.right);
        }
        static int tilt;
        public static int tilt(Node root){
            if(root == null) return 0;

            int lsum = tilt(root.left);
            int rsum = tilt(root.right);
            
            int ltilt = Math.abs(lsum-rsum);
            tilt+=ltilt;
            int ts = lsum+rsum+root.data;
            return ts;
        }

    }

    public static void main(String[] args) {
        // int arr[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        int arr[] = {4,2,3,-1,-1,5,-1,-1,9,-1,7,-1,-1};
        
        Node root = BinaryTree.constructTree(arr);
        BinaryTree.tilt(root);
        System.out.println(BinaryTree.tilt);
       
    }
}
