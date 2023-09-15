public class __5HeightOfBinaryTree {

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

        public static int heightOfBinaryTree(Node root){
            if(root == null) return -1;
            
            int lh = heightOfBinaryTree(root.left);
            int rh = heightOfBinaryTree(root.right);

            int th = Math.max(lh, rh)+1;
            return th;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        
        Node root = BinaryTree.constructTree(arr);

        BinaryTree.printTree(root);
        int height = BinaryTree.heightOfBinaryTree(root);
        System.out.println(height);
    }
}
