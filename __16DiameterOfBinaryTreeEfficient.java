public class __16DiameterOfBinaryTreeEfficient {
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

        public static void printList(Node root) {
            if (root == null)
                return;
            String str = "";
            str += root.left != null ? root.left.data : "null";
            str += " <- " + root.data + " -> ";
            str += root.right != null ? root.right.data : "null";
            System.out.println(str);

            printList(root.left);
            printList(root.right);
        }

        // calculating diameter using node
        private static int height(Node root){
            if(root == null) return 0;

            int lh = height(root.left);
            int rh = height(root.right);
            ans = Math.max(ans, lh+rh+1);
            return Math.max(lh, rh)+1;
        }

        static int ans = 0;
        public static int diaMeterOfBinaryTree(Node root){
            if(root == null) return 0;
            height(root);
            return ans;
        }
    }

    public static void main(String[] args) {
        int arr[] = {3,5,6,-1,-1,2,7,18,-1,-1,-1,4,-1,-1,1,0,-1,-1,8,-1,-1};

        BinaryTree bt = new BinaryTree();
        Node root = bt.constructTree(arr);
        bt.printList(root);

        // O(n) Time Complexity
        int dia = bt.diaMeterOfBinaryTree(root); 
        System.out.println(dia);
    }
}
