import java.util.ArrayDeque;
import java.util.Queue;

public class __1Queue{

    public static class CustomQueue{
        int data[];
        int size;
        int front;
        
        public CustomQueue(int cap){
            data = new int[cap];
            size = 0;
            front = 0;
        } 
        public void add(int val){
            if(size == data.length){
                System.out.println("Queue overflow");
                return;
            }
            int idx = (front+size)%data.length;
            data[idx] = val;
            size++;
        }
        public void remove(){
            if(size == 0){
                System.out.println("Queue underflow");
                return;
            }
            front = (front+1)%data.length;
            size--;
            System.out.println(data[front]);
        }

        public void peek(){
            if(size == 0){
                System.out.println("Queue underflow");
                return;
            }
            System.out.println(data[front]);
        }
        public void size(){
            System.out.println(size);
        }
 
        public void display(){
            for(int i=0; i<size; i++){
                int idx = (front+i)%data.length;
                System.out.print(data[idx]+" ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        CustomQueue cq = new CustomQueue(5);
        cq.add(1);
        cq.add(2);
        cq.add(3);
        cq.add(4);
        cq.add(5);
        cq.display();
        cq.remove();
        cq.display();
        cq.size();
    }
}