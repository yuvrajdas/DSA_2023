public class __11PrintKLevelDownBinaryTree {
    
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.left = null;
            this.right = null;
            this.data = data;
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

        public static void printKLevelDown(Node root, int k){
            if(root == null || k<0) return;

            if(k == 0){
                System.out.print(root.data+" ");
            }

            printKLevelDown(root.left, k-1);
            printKLevelDown(root.right, k-1);
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree bt = new BinaryTree();

        Node root =  bt.constructTree(arr);
        bt.printKLevelDown(root, 2);
    }
}
