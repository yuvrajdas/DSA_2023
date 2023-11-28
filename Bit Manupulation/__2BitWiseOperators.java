 
public class __2BitWiseOperators {
    /*
     *  |     OR
     *  &     AND
     *  ^     XOR
     *  <<    Left Shift
     *  >>    Right Shift
     *  >>>   Triple Right Shift
     *  -(x)  2's Compliment
     * 
     * 
     */

    public static void main(String[] args) {
        int x = 0 | 1;
        
        int y = 0 & 1;
        int z = 1 & 0;
        int a = 1 & 1;
        int b = 0 & 0;
        
        

        System.out.println("Bitwise OR : "+x);
        System.out.println("Bitwise AND : "+a);
        System.out.println("Bitwise AND : "+b);
        System.out.println("Bitwise AND : "+y);
        System.out.println("Bitwise AND : "+z);
        
        int xora = 1 ^ 1;
        int xorb = 0 ^ 1;

        System.out.println("Bitwise XOR if both are same : " +  xora);
        System.out.println("Bitwise XOR if both are different : " +  xorb);
        

        int ls = 1;
        int rs = 1;
        /*

         * Left Shift
         * 0001 << 2  
         * 01 - 00 = 4 ( take from right and drop from left)
         * 
         * 
         * Right Shift
         * 0001>>2
         * 00 - 00 = 0 (take form left and drop from right)
         * 
         * 
         */
        int rres = rs>>2;
        int lres =  ls<<2;
        System.out.println("Left Shift : "+ lres);
        System.out.println("Right Shift : "+ rres);
    }
}
