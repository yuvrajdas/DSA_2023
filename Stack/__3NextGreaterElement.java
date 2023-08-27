import java.util.Stack;

public class __3NextGreaterElement {
    
    public static void findNextGreaterElement(int arr[]){
        int res[] =new int[arr.length];
        Stack<Integer> s = new Stack<Integer>();
        s.push(arr[arr.length-1]);
        res[arr.length-1] = -1;
        for(int i=arr.length-2;i>=0;i--){
            while(!s.isEmpty() && s.peek()<=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = s.peek();
            }
            s.push(arr[i]);
        }
        for(int i=0; i<res.length; i++){
            System.out.print(res[i]+" ");
        }
        
    }
    public static void main(String[] args) {
        int arr[] = {2,5,9,3,1,12,6,8,7};

        findNextGreaterElement(arr);
    }
}
