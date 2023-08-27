import java.util.Stack;

public class __7LargestRectangeHistogram {
    
    public static void findLargestRectangle(int arr[]){
        int rb[] = new int[arr.length]; // nse on the right
        Stack<Integer> stk = new Stack<>();
        stk.push(arr.length-1);

        for(int i=arr.length-1; i>=0; i--){
            while(stk.size()>0 &&  arr[i]<=arr[stk.peek()]){
                stk.pop();
            }
            if(stk.isEmpty()){
                rb[i] = arr.length;
            }else{
                rb[i] = stk.peek();
            }
            stk.push(i);
        }
       
        int lb[] = new int[arr.length]; // nse on the left
        Stack<Integer> stk1 = new Stack<>();
        stk1.push(0);
        for(int i=0; i<arr.length; i++){
            while(stk1.size()>0 && arr[i]<=arr[stk1.peek()]){
                stk1.pop();
            }
            if(stk1.isEmpty()){
                lb[i] = -1;
            }else{
                lb[i] = stk1.peek();
            }
            stk1.push(i);
        }

        int maxArea = 0;
        for(int i=0; i<arr.length; i++){
            int width = (rb[i] - lb[i]) -1;
            int area = width*arr[i];
            if(maxArea < area){
                maxArea = area;
            }
        }
        System.out.println(maxArea);
    }

    public static void main(String[] args) {
        int arr[] = {3, 5, 1, 7, 5, 9};
        findLargestRectangle(arr);
    }
}

















