public class __14PrintSingleChild {

    public static class Node {
        int data;
        Node left;
        Node right;

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

        public static void printSingleChild(Node node, Node parent){

            if(node == null) return;

            if(parent!=null && parent.left == node && parent.right == null){
                System.out.print(node.data+" ");
            }else if(parent!=null && parent.right == node && parent.left == null){
                System.out.print(node.data+" ");
            }

            printSingleChild(node.left, node);
            printSingleChild(node.right, node);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 37,-1,-1};
        BinaryTree bt = new BinaryTree();
        Node root = bt.constructTree(arr);
        // bt.printTree(root);
        bt.printSingleChild(root, null);
    }   
}
