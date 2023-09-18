package BinarySeachTree;

public class __6HeightOfBST {

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

    public static class BinarySeachTree {

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

        public static int heightOfBST(Node root) {
            if (root == null)
                return 0;

            int lh = heightOfBST(root.left);
            int rh = heightOfBST(root.right);

            return Math.max(lh, rh) + 1;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        Node root = BinarySeachTree.constructBST(arr, 0, arr.length - 1);
        BinarySeachTree.printBST(root);
        int height = BinarySeachTree.heightOfBST(root);
        System.out.println(height);
    }
}
