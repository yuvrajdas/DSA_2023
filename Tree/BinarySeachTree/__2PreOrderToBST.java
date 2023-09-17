package BinarySeachTree;

public class __2PreOrderToBST {
    
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static class BinarySearchTree{
        
        public static Node constructBST(Node root, int val){
            
            if(root == null){
                root = new Node(val);
                return root;
            }
            if(root.data>val){
                root.left = constructBST(root.left, val);
            }else{
                root.right = constructBST(root.right, val);
            }
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
        int arr[] = {10, 5, 1, 7, 40, 50};
        Node root = null;
        for(int i=0; i<arr.length; i++){
          root =  BinarySearchTree.constructBST(root, arr[i]);
        }

        BinarySearchTree.printBST(root);
    }
}
