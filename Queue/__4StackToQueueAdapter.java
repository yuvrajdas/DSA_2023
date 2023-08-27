import java.util.*;
public class __4StackToQueueAdapter {
 
    Stack<Integer> mainS;
    Stack<Integer>helperS;

    public __4StackToQueueAdapter(){
        mainS = new Stack<>();
        helperS = new Stack<>();
    }

    public void add(int val) {
        mainS.push(val);
    }

    public void top(){
        while(mainS.size()>1){
            helperS.push(mainS.pop());
        }
        int topVal = mainS.pop();
        helperS.push(topVal);
        while(!helperS.isEmpty()){
            mainS.push(helperS.pop());
        }
        System.out.println(topVal);
    } 

    public void remove(){
        while(mainS.size()>1){
            helperS.push(mainS.pop());
        }
        int topVal = mainS.pop();
        while(!helperS.isEmpty()){
            mainS.push(helperS.pop());
        }
        System.out.println(topVal);
    }
    public void size(){
        System.out.println(mainS.size());
    }
    public static void main(String[] args) {
        __4StackToQueueAdapter stqa = new __4StackToQueueAdapter();
        stqa.add(1);
        stqa.add(2);
        stqa.add(3);
        stqa.top();
        stqa.size();
        stqa.remove();
        stqa.top();
    }
}
