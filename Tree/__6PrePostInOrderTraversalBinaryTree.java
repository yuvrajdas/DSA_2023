public class __6PrePostInOrderTraversalBinaryTree {

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

        public static void preorderTraversal(Node root) {
            if (root == null)
                return;

            System.out.print(root.data + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }

        public static void postOrderTraversal(Node root) {
            if (root == null)
                return;

            preorderTraversal(root.left);
            preorderTraversal(root.right);
            System.out.print(root.data + " ");

        }

        public static void inOrderTraversal(Node root) {
            if (root == null)
                return;

            preorderTraversal(root.left);
            System.out.print(root.data + " ");
            preorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        
        Node root = BinaryTree.constructTree(arr);
        BinaryTree.preorderTraversal(root);
        System.out.println();
        BinaryTree.postOrderTraversal(root);
        System.out.println();
        BinaryTree.inOrderTraversal(root);
        
    }
}
