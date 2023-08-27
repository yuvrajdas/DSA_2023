public class __2DecimalToBinary {
    
    public static void converIntoBinary(int no){
        int res = 0;
        int powr= 0;
        while(no>0){
            int rem = no%2;
            res +=(int) (rem*Math.pow(10, powr));
            no/=2; 
            powr++;           
        }
        System.out.println(res);
    }
    public static void main(String[] args) {
        int no = 125;
        converIntoBinary(no);
    }
}
