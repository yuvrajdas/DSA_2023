public class __22IdenticalOrNot {

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

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public static boolean isIdenticalTree(Node root1, Node root2) {

            if (root1 == null && root2 == null)
                return true;
            if (root1 == null || root2 == null)
                return false;

            if (root1.data != root2.data)
                return false;

            boolean lc = isIdenticalTree(root1.left, root2.left);
            boolean rc = isIdenticalTree(root1.right, root2.right);

            return lc && rc;
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
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, -1, -1, 3, -1, -1 };
        BinaryTree bt = new BinaryTree();
        Node root = bt.buildTree(arr);
        bt.printTree(root);
        boolean res = bt.isIdenticalTree(root, root);
        System.out.println(res);
    }
}
