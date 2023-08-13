public class __4SumMaxSizeBinaryTree{

    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree{
        static int idx = -1;

        public static Node constructTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1) return null;

            Node newNode = new Node(nodes[idx]);
            newNode.left = constructTree(nodes);
            newNode.right = constructTree(nodes);
            return newNode;
        }

        public static void printTree(Node root){
            if(root == null) return;
            String str = "";
            str+=root.left!=null?root.left.data : "null";
            str+=" <- "+root.data+" -> ";
            str+=root.right!=null?root.right.data : "null";
            System.out.println(str);

            printTree(root.left);
            printTree(root.right);
        }

        public static int totalSumOfBinaryTree(Node root){
            if(root == null) return 0;

            int lSum = totalSumOfBinaryTree(root.left);
            int rSum = totalSumOfBinaryTree(root.right);
            int totalSum = lSum+rSum+root.data;
            return totalSum;
        }

        public static int sizeOfBinaryTree(Node root){
            if(root == null) return 0;

            int ls = sizeOfBinaryTree(root.left);
            int rs = sizeOfBinaryTree(root.right);
            int ts = ls+rs+1;
            return ts;
        }

        public static int maxOfBinaryTee(Node root){
            if(root == null) return Integer.MIN_VALUE;

            int lMax = maxOfBinaryTee(root.left);
            int rMax = maxOfBinaryTee(root.right);

            int max = Math.max(root.data,Math.max(lMax, rMax));
            return max;
        }
    }
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int arr[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = bt.constructTree(arr);
        bt.printTree(root);

        // Size of Binary Tree
        int size = bt.sizeOfBinaryTree(root);
        System.out.println("size of tree : "+size);

        // Sum of Binary Tree 
        int sum = bt.totalSumOfBinaryTree(root);
        System.out.println("Sum of tree : "+sum);

        // Max of Binary Tree
        int max = bt.maxOfBinaryTee(root);
        System.out.println("Max is : "+max);
    }
}