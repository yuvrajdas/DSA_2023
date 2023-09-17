package BinarySeachTree;

public class __4InOrderToBST {
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

        private static Node constructBST(int nums[], int si, int ei){
            if(si > ei){
               return null;
            }
            
            int mid = si+(ei-si)/2;
            int data = nums[mid];
            Node lc = constructBST( nums, si, mid-1);
            Node rc = constructBST( nums, mid+1, ei);
            Node root = new Node(data, lc, rc);
            return root;
            
        }

        public static void printBST(Node root){
            if(root == null) return;

            String str = "";
            str+=root.left!=null?root.left.data :"null";
            str+=" <- "+root.data+" -> ";
            str+=root.right!=null?root.right.data : "null";
            System.out.println(str);
             
            printBST(root.left);
            printBST(root.right);
        }
    }

    public static void main(String[] args) {
        int nums[] = {1, 5, 7, 10, 40, 50};
        int si = 0;
        int ei = nums.length-1;
        Node root = null;
        root = BinarySearchTree.constructBST(nums, si, ei);
        BinarySearchTree.printBST(root);
    }
}
