public class __21MaximumPathBinaryTree {

    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree {

        static int idx = -1;

        public static Node constructTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1)
                return null;

            Node newNode = new Node(nodes[idx]);
            newNode.left = constructTree(nodes);
            newNode.right = constructTree(nodes);

            return newNode;
        }

        public static void printTree(Node root) {
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
        static int maxSum = Integer.MIN_VALUE;
        private static int maximumPathSumHelper(Node root){
            if(root == null) return 0;

            int ls = maximumPathSumHelper(root.left);
            int rs = maximumPathSumHelper(root.right);

            int found_in_below = ls+rs+root.data; // max sum found in below side only
            int one_is_best = Math.max(ls, rs)+root.data; // if max sum is in only one side either left or right side
            int root_is_best = root.data;
            maxSum = Math.max(maxSum,Math.max(found_in_below,Math.max(one_is_best, root_is_best)));

            // calculater further for root and another left or right
            return Math.max(one_is_best, root_is_best);

        }
       
        public static int maximumPathSum(Node root){
            if(root == null) return 0;
            maximumPathSumHelper(root);
            return maxSum;
        }
    }

    public static void main(String[] args) {
        int arr[] = { -10, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1 };
        BinaryTree bt = new BinaryTree();
        Node root = bt.constructTree(arr);
        bt.printTree(root);

        int maxPath = bt.maximumPathSum(root);
        System.out.println(maxPath);

    }
}


// https://youtu.be/Op6YFcs8R9M?si=kvY_ZVag4iWJAFfb