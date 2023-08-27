import java.util.Stack;

public class __6NextSmallerElementOnLeft {
    public static void nextSmallerElementToTheLeft(int arr[]){
        int res[] = new int[arr.length];
        Stack<Integer> stk = new Stack<>(); 
        stk.push(arr[0]);

        for(int i=0; i<arr.length; i++){
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
        nextSmallerElementToTheLeft(arr);
    }
}
