public class __PrefixProduct {
    
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        int ppfs[] = new int[arr.length];
        int ppfe[] = new int[arr.length];
        int prods = 1;
        int prode = 1;
        for(int i=0; i<arr.length; i++){
            prods = prods*arr[i];
            ppfs[i] = prods;
        }

        for(int i=arr.length-1; i>=0; i--){
            prode = prode*arr[i];
            ppfe[i] = prode;
        }
        for(int i=0; i<ppfe.length; i++){
            System.out.print(ppfe[i]+" ");
        }
        System.out.println();
        for(int i=0; i<ppfs.length; i++){
            System.out.print(ppfs[i]+" ");
        }
    }
}
