import java.util.Stack;
public class __2MinimumStack {

    Stack<Integer> allData; 
    Stack<Integer> minData;

    public __2MinimumStack(){
        allData = new Stack<>();
        minData = new Stack<>();
    }

    public void push(int val){
        if(allData.isEmpty() && minData.isEmpty()){
            minData.push(val);
            allData.push(val);
        }else if(val<allData.peek()){
            minData.push(val);
            allData.push(val);
        }else if(val>allData.peek()){
            allData.push(val);
        }
    }

    public void size(){
        System.out.println(allData.size());
    }

    public void pop(){
        if(allData.peek() == minData.peek()){
            minData.pop();
            allData.pop();
        }else{
            allData.pop();
        }
    }
    public void peek(){
        System.out.println(allData.peek());
    }
    public void getMin(){
        System.out.println(minData.peek());
    }

    public void printStack(){
        System.out.println(allData);
        System.out.println(minData);
    }
    public static void main(String[] args) {
        __2MinimumStack ms = new __2MinimumStack();
        ms.push(10);
        ms.push(2);
        ms.push(20);
        ms.push(1);
        ms.push(50);
        ms.getMin();
        ms.peek();
        ms.pop();
        ms.getMin();
        ms.pop();
        ms.getMin();
        ms.printStack();
    }
}
