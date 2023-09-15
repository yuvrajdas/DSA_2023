public class __9FindNodeInBinaryTree {
    
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
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

        public static boolean findNode(Node root, int val)
        {
            if(root == null) return false;

            if(root.data == val) return true;

            boolean lcVal = findNode(root.left, val);
            if(lcVal) return true;

            boolean rcVal = findNode(root.right, val);
            if(rcVal) return true;

            return false;
        }
    }
    public static void main(String[] args) {
        int arr[] = { 1, 2, 5, -1, -1, 6, -1, -1, 3, -1, -1 };
        
        Node root = BinaryTree.constructTree(arr);
        boolean res = BinaryTree.findNode(root, 3);
        System.out.println(res);
    }
}
