package BinarySeachTree;

public class __10RemoveNodeInBST {
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
        private static int max(Node root){
            if(root == null) return Integer.MIN_VALUE;

            int lMax = max(root.left);
            int rMax = max(root.right);

            return Math.max(root.data, Math.max(lMax, rMax));
        }
        public static Node removeInBST(Node root, int data) {
            if (root == null)
                return null;

            if (data < root.data) {
                root.left = removeInBST(root.left, data);
            } else if (data > root.data) {
                root.right = removeInBST(root.right, data);
            } else {

                if (root.left != null && root.right != null) {

                    int leftMaxVal = max(root.left);
                    root.data = leftMaxVal;
                    root.left = removeInBST(root.left, leftMaxVal);
                    return root;

                } else if (root.left != null) {
                    return root.left;
                } else if (root.right != null) {
                    return root.right;
                } else {
                    return null;
                }
            }
            return root;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        Node root = BinarySearchTree.constructBST(arr, 0, arr.length - 1);
        BinarySearchTree.printBST(root);
        Node nRoot = BinarySearchTree.removeInBST(root, 4);
        System.out.println();
        BinarySearchTree.printBST(nRoot);

    }
}
