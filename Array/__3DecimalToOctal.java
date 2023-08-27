public class __3DecimalToOctal {

    public static void convertDecimalToOctal(int no){
        int res = 0;
        int power = 0;
        while(no!=0){
            int rem = no%8;
            res+=(int)(rem*Math.pow(10, power));
            no/=8;
            power++;
        }
        System.out.println(res);
    }
    public static void main(String[] args) {
        int no = 125;
        convertDecimalToOctal(no);
    }
}
