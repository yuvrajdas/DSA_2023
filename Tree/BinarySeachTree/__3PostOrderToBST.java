package BinarySeachTree;

public class __3PostOrderToBST {
    
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static class BinarySeachTree{

        public static Node constructTree(Node root, int val){
            if(root == null){
                root = new Node(val);
                return root;
            }

            if(root.data>val){
                root.left = constructTree(root.left, val);
            }else{
                root.right = constructTree(root.right, val);
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
        int arr[] = {1, 7, 5, 50, 40, 10};
        Node root = null;

        for(int i=arr.length-1; i>=0; i--){
            root = BinarySeachTree.constructTree(root, arr[i]);
        }

        BinarySeachTree.printBST(root);
    }
}
