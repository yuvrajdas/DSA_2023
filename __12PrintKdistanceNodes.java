import java.util.*;

public class __12PrintKdistanceNodes {

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

        static ArrayList<Node> path;

        public static void printNodeFromKdistance(Node root, int k, int target) {
            path = new ArrayList<>();
            nodeToRootPath(root, target);

            for (int i = 0; i < path.size(); i++) {
                printKLevelDown(path.get(i), k - i, i == 0 ? null : path.get(i - 1));
            }
        }

        private static void printKLevelDown(Node node, int k, Node blocker) {
            if (node == null || k < 0 || node == blocker)
                return;

            if (k == 0) {
                System.out.print(node.data + " ");
            }

            printKLevelDown(node.left, k - 1, blocker);
            printKLevelDown(node.right, k - 1, blocker);
        }

        private static boolean nodeToRootPath(Node root, int target) {
            if (root == null)
                return false;

            if (root.data == target) {
                path.add(root);
                return true;
            }

            boolean lc = nodeToRootPath(root.left, target);
            if (lc) {
                path.add(root);
                return true;
            }

            boolean rc = nodeToRootPath(root, target);
            if (rc) {
                path.add(root);
                return true;
            }

            return false;
        }

    }

    public static void main(String[] args) {
        int arr[] = { 3, 5, 6, -1, -1, 2, 7, -1, -1, 4, -1, -1, 1, 0, -1, -1, 8, -1, -1 };

        BinaryTree bt = new BinaryTree();
        Node root = bt.constructTree(arr);
        bt.printList(root);
        System.out.println();
        bt.printNodeFromKdistance(root, 1, 5);
    }
}