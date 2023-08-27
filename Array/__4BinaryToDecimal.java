public class __4BinaryToDecimal {
    
    public static void convertIntoDecimal(int binaryNo){
        int res = 0;
        int power = 0;
        while(binaryNo!=0){
            int rem = binaryNo%10;
            res+=(rem*Math.pow(2, power));
            power++;
            binaryNo/=10;
        }
        System.out.println(res);
    }
    public static void main(String[] args) {
        int binaryNo = 1111101; // 125
        convertIntoDecimal(binaryNo);
    }
}
