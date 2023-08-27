public class LinkedListConstruction {
    
    public static class Node{
        int data;
        Node next;
    }

    public static class LinkedList{
        int size;
        Node head;
        Node tail;

        public void addLast(int val){
            Node temp = new Node();
            temp.data = val;
            temp.next = null;
            if(size == 0){
                head = tail = temp;
            }else{
                tail.next = temp;
                tail = temp;
            }
            size++;
        }

        public void addFirst(int val){

            if(size == 0){
                Node temp = new Node();
                temp.data = val;
                temp.next = null;
                head = tail = temp;
                size++;
            }else{
                Node temp = new Node();
                temp.data = val;
                temp.next = head;
                head = temp;
                size++;
            }
        }

        public void addAtIdx(int idx, int val){
            if(idx == 0){
                addFirst(val);
            }else if(idx == size-1){
                addLast(val);
            }else if(idx<0 || idx>size-1){
                System.out.println("Invalid inputs");
            }else{
                Node temp = head;
                for(int i=0; i<idx-1; i++){
                    temp = temp.next;
                }
                Node newNode = new Node();
                newNode.data = val;
                newNode.next = temp.next;
                temp.next = newNode;
                size++;
            }
        }

        public void printList(){
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.data+"->");
                temp = temp.next;
            }
            System.out.print("null");
            System.out.println();
        }

        public void size(){
            System.out.println("size is : "+this.size);
        }

        public void removeFirst(){
            if(size == 0){
                System.out.println("List is empty");
                return;
            }else if(size == 1){
                size = 0;
                head = tail = null;
                return;
            }else{
                head = head.next;
                size--;
            }
        }

        public void removeLast(){
            if(size == 0){
                System.out.println("List is empty");
                return;
            }else if(size == 1){
                size = 0;
                head = tail = null;
                return;
            }else{
                Node temp = head;
                for(int i=0; i<size-2; i++){
                    temp = temp.next;
                }
                temp.next = null;
                size--;
            }
        }

        public void removeAt(int idx){
            if(idx < 0 || idx > size-1){
                System.out.println("Invalid argument");
                return;
            }else if(idx == 0){
                removeFirst();
            }else if(idx == size-1){
                removeLast();
            }else{
                Node temp = head;
                for(int i=0; i<idx-1; i++){
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                size--;
            }
        }

        public void getFirst(){
            if(size == 0){
                System.out.println("List is Empty");
            }else{
                System.out.println(head.data);
            }
        }

        public void getLast(){
            if(size == 0){
                System.out.println("List is empty");
            }else{
                System.out.println(tail.data);
            }
        }

        public void getAtIndex(int idx){
            if(idx < 0 || idx > size-1){
                System.out.println("Invalid index");
            }else if(idx == 0){
                getFirst();
            }else if(idx == size-1){
                getLast();
            }else{
                Node temp = head;
                for(int i=0; i<idx; i++){
                    temp = temp.next;   
                }
                System.out.println(temp.data);
            }

        }

        public Node getNodeAt(int idx){
            Node temp = head;
            for(int i=0; i<idx; i++){
                temp = temp.next;
            }
            return temp;
        }
        public void reverseLinkedList(){
            int li = 0;
            int ri = size-1;

            while(li<ri){
                Node liNode = getNodeAt(li);
                Node riNode = getNodeAt(ri);

                int temp = liNode.data;
                liNode.data = riNode.data;
                riNode.data = temp;

                ri--;
                li++;
            }
        }

        public void reverseLinkedListRef(){
            Node curr = head;
            Node prev = null;

            while(curr!=null){
                Node next = curr.next;
                
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            Node temp = head;
            head = tail;
            tail = temp;
        }

        public void reverseDRHelper(Node rNode, int floor){
            if(rNode == null){
                return;
            }

            reverseDRHelper(rNode.next, floor+1);

            if(floor>=size/2){
                int temp = rNode.data;
                rNode.data = lNode.data;
                lNode.data = temp;
                lNode = lNode.next;
            }

        }
        Node lNode;
        public void reverseDR(){
          lNode = head;
            reverseDRHelper(lNode, 0);
        }

        private boolean isLinkedListPallindromHelper(Node right){
            if(right == null){
                return true;
            }

            boolean rres = isLinkedListPallindromHelper(right.next);

            if(rres == false){
                return false;
            }else if(right.data != left.data){
                return false;
            }else{
                left = left.next;
                return true;
            }
        }
        Node left;
        public void isLinkedListPallindrom(){
            left = head;

            boolean res = isLinkedListPallindromHelper(left);
            if(res)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }

   
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(1);
        ll.printList();
        // ll.size();
        // ll.removeFirst();
        // ll.printList();
        // ll.removeFirst();
        // ll.printList();
        // ll.getFirst();
        // ll.getLast();
        // ll.getAtIndex(2);
        // ll.getAtIndex(4);
        // ll.getAtIndex(5);
        // ll.addFirst(6);
        // ll.addFirst(7);
        // ll.addFirst(8);
        // ll.addFirst(9);
        // ll.addAtIdx(3, 0);
        // ll.printList();
        // ll.removeLast();
        // ll.removeAt(3);
        // ll.reverseLinkedList();
        // ll.reverseLinkedListRef();
        // ll.reverseDR();
        ll.isLinkedListPallindrom();
        ll.printList();

    }
}
