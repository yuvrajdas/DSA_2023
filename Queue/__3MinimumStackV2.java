import java.util.Stack;

public class __3MinimumStackV2 {
    
    int min;
    Stack<Integer> stk;
    public __3MinimumStackV2(){
        min = Integer.MAX_VALUE;
        stk = new Stack<Integer>();
    }

    public void push(int val){
        if(stk.empty()){
            stk.push(val);
            min = val;
        }else{
            if(val <= min){
                min = val;
                stk.push(val);
            }else{
                stk.push(val);
            }
        }
    }

    public void pop(){
        stk.pop();
    }

    public void peek(){
        System.out.println(stk.peek());
    }
    public void getMin(){
        System.out.println(min);
    }

    public void printStk(){
        System.out.println(stk);
    }
    public static void main(String[] args) {
        __3MinimumStackV2 ms = new __3MinimumStackV2();
        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        ms.getMin();
        ms.pop();
        ms.printStk();
    }


}
