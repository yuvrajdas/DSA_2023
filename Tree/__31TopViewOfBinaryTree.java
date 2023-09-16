public class __31TopViewOfBinaryTree {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static class BinaryTree{
        static int idx;

        public static Node constructTree(int nodes[]){
            idx++;

            if(nodes[idx] == -1) return null;

            Node newNode = new Node(nodes[idx]);
            newNode.left = constructTree(nodes);
            newNode.right = constructTree(nodes);

            return newNode;
        }
    }
}
