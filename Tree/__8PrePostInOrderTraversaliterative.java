import java.util.*;

public class __8PrePostInOrderTraversaliterative {

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

    public static class Pair{
        int state;
        Node node;

        Pair(Node node, int state){
            this.node = node;
            this.state = state;
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
            str += "<-" + root.data + "->";
            str += root.right != null ? root.right.data : "null";
            System.out.println(str);

            printTree(root.left);
            printTree(root.right);
        }

        public static void prePostInorderTraversalIterative(Node root){
            Stack<Pair> stk = new Stack<>();

            Pair pair = new Pair(root, 1);
            stk.push(pair);

            String pre = "";
            String in = "";
            String post = "";
            while(stk.size()>0){
                Pair sPair = stk.peek();

                if(sPair.state == 1){
                    pre+=sPair.node.data+" ";
                    sPair.state++;

                    if(sPair.node.left!=null) {
                        Pair lp = new Pair(sPair.node.left, 1);
                        stk.push(lp);
                    }

                }else if(sPair.state == 2){
                    in+=sPair.node.data+" ";
                    sPair.state++;
                    if(sPair.node.right!=null){
                        Pair rp = new Pair(sPair.node.right, 1);
                        stk.push(rp);
                    }
                }else{
                    post+=sPair.node.data+" ";
                    stk.pop();
                }
            }
            System.out.println(pre);
            System.out.println(post);
            System.out.println(in);
        }
    }

    public static void main(String[] args) {
        
        int arr[] = { 1, 2, 5, -1, -1, 6, -1, -1, 3, -1, -1 };
        Node root = BinaryTree.constructTree(arr);
        BinaryTree.printTree(root);
        BinaryTree.prePostInorderTraversalIterative(root);

    }
}
