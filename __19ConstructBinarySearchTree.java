public class __19ConstructBinarySearchTree {
    
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
        
        public Node insertInBST(Node root,int val){
            if(root == null){
                root = new Node(val);
                return root;
            }
            if(root.data>val){
                root.left = insertInBST(root.left, val);
            }else{
                root.right = insertInBST(root.right, val);
            }
            return root;
        }

        public static void printTree(Node root){
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
        int arr[] = {8,5,1,7,10,12};
        BinarySearchTree bst = new BinarySearchTree();
        Node root = null;
        for(int i=0; i<arr.length; i++){
            root = bst.insertInBST(root, arr[i]);
        }

        bst.printTree(root);
    }
}
