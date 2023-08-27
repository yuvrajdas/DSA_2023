import java.util.ArrayList;

public class __7GetSubsequence {
    
    private static ArrayList<String> getSubsequence(String str){
        if(str.length() == 0){
           ArrayList<String> bres =  new ArrayList<>();
           bres.add("");
           return bres;
        }
        char ch = str.charAt(0);
        ArrayList<String> list = getSubsequence(str.substring(1));

        ArrayList<String> res = new ArrayList<>();
        for(String rstr : list){
            res.add(""+rstr);
        }
        for(String rstr : list){
            res.add(ch+rstr);
        }
        return res;
    }
    public static void main(String[] args) {
        String str = "ABC";
        System.out.println(getSubsequence(str));
    }
}
