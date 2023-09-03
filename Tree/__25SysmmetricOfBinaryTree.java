public class __25SysmmetricOfBinaryTree {

    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
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
            String res = "";
            res+=root.left!=null?root.left.data : "null";
            res+="<-"+root.data+"->";
            res+=root.right!=null?root.right.data:"null";
            System.out.println(res);

            printTree(root.left);
            printTree(root.right);
        }
        private static boolean isMatch(Node root1, Node root2){
            if(root1!=null && root2!=null){
                boolean a = isMatch(root1.left, root2.right);
                boolean b = isMatch(root1.right, root2.left);

                if(root1.data == root2.data && a && b){
                    return true;
                }else{
                    return false;
                }
            }else if(root1 == null && root2 == null){
                return true;
            }else{
                return false;
            }
        }
        public static boolean isSymmetric(Node root){
            if(root == null) return true;

            return isMatch(root.left, root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int arr[] = { 1, 2, 3, -1, -1, 4, -1, -1, 2, 4, -1, -1, 3, -1, -1 };
        Node root = bt.constructTree(arr);
        bt.printTree(root);
        boolean res = bt.isSymmetric(root);
        System.out.println(res);
    }
}
