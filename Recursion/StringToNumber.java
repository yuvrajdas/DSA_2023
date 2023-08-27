public class StringToNumber {
    private static int convertNumber(String str, int len) {
        if (len == 0) { 
            System.out.println(str.charAt(len) - '0');
            return str.charAt(len) - '0';
        }
            System.out.println((str.charAt(len) - '0')+"------u");

        int res = convertNumber(str, len - 1);
        System.out.println((str.charAt(len) - '0')+"------");
        res = res * 10 + (str.charAt(len) - '0');
        return res;
    }
    
    public static void main(String[] args) {
        String str = "12";
        int res = convertNumber(str, str.length() - 1);
        System.out.println(res);
    }
}
