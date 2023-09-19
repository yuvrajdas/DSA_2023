package BinarySeachTree;

public class __8SizeOfBST {
    
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class BinarySearchTree{

        public static Node constructBST(int nodes[], int si, int ei){
            if(si>ei) return null;

            int mid = si+(ei-si)/2;
            int data = nodes[mid];

            Node leftCNode = constructBST(nodes, si, mid-1);
            Node rightCNode = constructBST(nodes, mid+1, ei);

            Node root = new Node(data, leftCNode, rightCNode);
            return root;
        }

        public static int sizeOfBST(Node root){
            if(root == null) return 0;

            int leftSize = sizeOfBST(root.left);
            int rightSize = sizeOfBST(root.right);

            return leftSize+rightSize+1;
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
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        Node root = BinarySearchTree.constructBST(arr, 0, arr.length - 1);
        BinarySearchTree.printBST(root);
        int size = BinarySearchTree.sizeOfBST(root);
        System.out.println(size);
    }
}
