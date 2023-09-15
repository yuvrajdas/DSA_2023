import java.util.ArrayDeque;
import java.util.Queue;

public class __7LevelOrderTraversalBinaryTree {

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

        public static void levelOrderTraversal(Node root) {

            Queue<Node> que = new ArrayDeque<>();
            que.add(root);

            while (que.size() > 0) {
                int count = que.size();

                for (int i = 0; i < count; i++) {
                    Node node = que.remove();
                    System.out.print(node.data + " ");

                    if (node.left != null)
                        que.add(node.left);

                    if (node.right != null)
                        que.add(node.right);
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        
        Node root = BinaryTree.constructTree(arr);
        BinaryTree.levelOrderTraversal(root);
    }
}
