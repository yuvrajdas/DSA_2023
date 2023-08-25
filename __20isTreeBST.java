public class __20isTreeBST{
    
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

        public static Node constructBST(int val, Node root){
            if(root == null){
                root = new Node(val);
                return root;
            }

            if(root.data > val){
                root.left = constructBST(val, root.left);
            }else{
                root.right = constructBST(val, root.right);
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
        public static class BSTPair{
            boolean isBST;
            int min;
            int max;
        }
        public static BSTPair isValidBST(Node root){
            if(root == null){
                BSTPair bp = new BSTPair();
                bp.isBST = true;
                bp.min = Integer.MAX_VALUE;
                bp.max = Integer.MIN_VALUE;
                return bp;
            }

            BSTPair lp = isValidBST(root.left);
            BSTPair rp = isValidBST(root.right);

            BSTPair mp = new BSTPair();
            mp.isBST = lp.isBST && rp.isBST && (root.data>=lp.max && root.data<=rp.min);

            mp.min = Math.min(root.data, Math.min(lp.min, rp.min));
            mp.max = Math.max(root.data, Math.max(lp.max, rp.max));

            return mp;
        }

        public static void isValidBST2Helper(Node root, Node prev, boolean f){
            if(root == null) return;

            isValidBST2Helper(root.left, prev, f);
            if(prev!=null && root.data<prev.data){
                f = false;
            }
            prev = root;
            isValidBST2Helper(root.right, prev, f);

        }
        public static boolean isValidBST2(Node root){
            if(root == null) return false; 
            boolean f = true;
            Node prev = null;
            isValidBST2Helper(root, prev, f);
            return f;
        }
    }
    
    public static void main(String[] args) {
        int arr[] = {8,5,1,7,10,12};
        BinarySearchTree bst = new BinarySearchTree();
        Node root = null;
        for(int i=0; i<arr.length; i++){
            root = bst.constructBST(arr[i], root);
        }

        bst.printTree(root);
        // BinarySearchTree.BSTPair bpc = bst.isValidBST(root); 
        // System.out.println("Is the tree a valid BST " + bpc.isBST);

        boolean res = bst.isValidBST2(root);
        System.out.println(res);
    }
}