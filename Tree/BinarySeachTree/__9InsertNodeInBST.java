package BinarySeachTree;

public class __9InsertNodeInBST {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinarySearchTree {

        public static Node constructBST(int nodes[], int si, int ei) {
            if (si > ei)
                return null;

            int mid = si + (ei - si) / 2;
            int data = nodes[mid];

            Node leftCNode = constructBST(nodes, si, mid - 1);
            Node rightCNode = constructBST(nodes, mid + 1, ei);

            Node root = new Node(data, leftCNode, rightCNode);
            return root;
        }

        public static void printBST(Node root) {
            if (root == null)
                return;

            String str = "";
            str += root.left != null ? root.left.data : "null";
            str += " <- " + root.data + " -> ";
            str += root.right != null ? root.right.data : "null";
            System.out.println(str);

            printBST(root.left);
            printBST(root.right);
        }

        public static Node InsertInBST(Node root, int data) {
            if (root == null)
                return new Node(data);

            if (data > root.data) {
                root.right = InsertInBST(root.right, data);
            } else {
                root.left = InsertInBST(root.left, data);
            }

            return root;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        Node root = BinarySearchTree.constructBST(arr, 0, arr.length - 1);
        BinarySearchTree.printBST(root);
        Node nRoot = BinarySearchTree.InsertInBST(root, 0);
        BinarySearchTree.printBST(nRoot);

    }
}
