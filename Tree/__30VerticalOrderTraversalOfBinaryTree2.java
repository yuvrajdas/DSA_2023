import java.util.*;
public class __30VerticalOrderTraversalOfBinaryTree2{
    
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static class Pair{
        int idx;
        Node pNode;

        Pair(int idx, Node pNode){
            this.idx = idx;
            this.pNode = pNode;
        }
    }
    
    public static class BinaryTree{
        static int idx = -1;

        public static Node constructTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

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
        private static void width(Node root, int hl, int hlArr[]){
            if(root == null) return;

            hlArr[0] = Math.min(hlArr[0], hl);
            hlArr[1] = Math.max(hlArr[1], hl);

            width(root.left, hl-1, hlArr);
            width(root.right, hl+1, hlArr);
        }
        public static void verticalOrderTraversal(Node root){
            int width[] = new int[2];
            width(root, 0, width);
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            Queue<Pair> que = new ArrayDeque<>();
            int length = width[1]-width[0]+1;
            for(int i=0; i<length; i++){
                res.add(new ArrayList<>());
            }
            que.add(new Pair(Math.abs(width[0]), root));

            while(que.size()>0){
                int count = que.size();
                
                for(int i=0; i<count; i++){
                    Pair rPair = que.remove();
                    
                    res.get(rPair.idx).add(rPair.pNode.data);
                    if(rPair.pNode.left!=null){
                        que.add(new Pair(rPair.idx-1, rPair.pNode.left));
                    }
                    
                    if(rPair.pNode.right!=null){
                        que.add(new Pair(rPair.idx+1, rPair.pNode.right));
                    }
                }
            }
           System.out.println(res);
        }
    } 
    
    public static void main(String[] args) {
        int arr[] = {1, 2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = BinaryTree.constructTree(arr);
        BinaryTree.printTree(root);
        BinaryTree.verticalOrderTraversal(root);
    }
}