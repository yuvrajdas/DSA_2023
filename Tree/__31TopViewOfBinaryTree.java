import java.util.*;
public class __31TopViewOfBinaryTree {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static class Pair{
        Node pNode;
        int idx;
        Pair(Node pNode, int idx){
            this.pNode = pNode;
            this.idx = idx;
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

            String res = "";
            res += root.left != null ? root.left.data : "null";
            res += "<-" + root.data + "->";
            res += root.right != null ? root.right.data : "null";

            System.out.println(res);

            printTree(root.left);
            printTree(root.right);
        }
        private static void width(Node root, int hl, int minMax[]){
            if(root == null) return;

            minMax[0] = Math.min(minMax[0], hl);
            minMax[1] = Math.max(minMax[1], hl);

            width(root.left, hl-1, minMax);
            width(root.right, hl+1, minMax);
        }

        public static ArrayList<Integer> topViewOfBinaryTree(Node root){
            ArrayList<Integer> res = new ArrayList<>();
            if(root == null) return res;
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            Queue<Pair> que = new ArrayDeque<>();
            int minMax[] = new int[2];
            width(root, 0, minMax);
            int length = minMax[1] - minMax[0] +1;
            
            for(int i=0; i<length; i++){
                list.add(new ArrayList<>());
            }
            que.add(new Pair(root, Math.abs(minMax[0])));
            
            while(que.size()>0){
                int count = que.size();

                for(int i=0; i<count; i++){
                    Pair rPair = que.remove();
                    
                    if(list.get(rPair.idx).size() == 0){
                        list.get(rPair.idx).add(rPair.pNode.data);
                    }

                    if(rPair.pNode.left!=null){
                        que.add(new Pair(rPair.pNode.left, rPair.idx-1));
                    }

                    
                    if(rPair.pNode.right!=null){
                        que.add(new Pair(rPair.pNode.right, rPair.idx+1));
                    }
                }
            }

            for(ArrayList<Integer> element : list){
                res.addAll(element);
            }
            
            return res;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        Node root = BinaryTree.constructTree(arr);
        BinaryTree.printTree(root);
        ArrayList<Integer> res = BinaryTree.topViewOfBinaryTree(root);
        System.out.println(res);
    }
}
