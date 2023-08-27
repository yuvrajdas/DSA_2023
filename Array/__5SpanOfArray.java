public class __5SpanOfArray {

    public static void findSpanOfArray(int a[]){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<a.length; i++){
            if(max<a[i]){
                max = a[i];
            }
            if(min>a[i]){
                min = a[i];
            }
        }
        int res = max-min;
        System.out.println("Span of given array is "+res);
    }
    public static void main(String[] args) {
        int a[] = {4,3,7,5,9,4,8,6};
        findSpanOfArray(a);
    }
}
