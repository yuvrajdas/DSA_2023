package BinarySeachTree;

public class __5MinMaxInBST {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class BinarySearchTree {

        public static Node constructBST(int nodes[], int si, int ei) {
            if (si > ei) {
                return null;
            }

            int mid = si + (ei - si) / 2;
            int data = nodes[mid];

            Node leftChild = constructBST(nodes, si, mid - 1);
            Node rightChild = constructBST(nodes, mid + 1, ei);

            Node root = new Node(data, leftChild, rightChild);
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

        public static int min(Node root) {
            if (root == null)
                return Integer.MAX_VALUE;

            int lmin = min(root.left);
            int rmin = min(root.right);

            return Math.min(root.data, Math.min(lmin, rmin));
        }

        public static int max(Node root) {
            if (root == null)
                return Integer.MIN_VALUE;

            int lmax = max(root.left);
            int rmax = max(root.right);

            return Math.max(root.data, Math.max(lmax, rmax));
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        Node root = BinarySearchTree.constructBST(arr, 0, arr.length - 1);
        BinarySearchTree.printBST(root);
        int min = BinarySearchTree.min(root);
        int max = BinarySearchTree.max(root);

        System.out.println("min value is " + min + " and max value is " + max);
    }
}
