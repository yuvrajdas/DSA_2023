import java.util.Stack;

public class __5NextSmallerElementOnRight {
    
    public static void nextSmallerElementOnTheRight(int arr[]){
        int res[] = new int[arr.length];
        Stack<Integer> stk = new Stack<>();
        stk.push(arr[arr.length-1]);
        for(int i = arr.length - 1; i>= 0; i--){

            while(stk.size()>0 && stk.peek()>=arr[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = stk.peek();
            }
            stk.push(arr[i]);
        }

        for(int i=0; i<res.length; i++){
            System.out.print(res[i]+" ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {2,5,9,3,1,12,6,8,7};
        nextSmallerElementOnTheRight(arr);
    }
}
