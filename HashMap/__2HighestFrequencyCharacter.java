import java.util.HashMap;

public class __2HighestFrequencyCharacter {
    
    public static void getHeighestFrequencyCharacter(String str){

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<str.length(); i++){
           char ch = str.charAt(i);
           
           if(map.containsKey(ch)){
              int freq = map.get(ch);
              freq+=1;
              map.put(ch,freq);
            }else{
             map.put(ch, 1);
            }
           
        }
        char hfc = str.charAt(0);
        for(Character key:map.keySet()){
            if(map.get(key)>map.get(hfc)){
                hfc = key;
            }
        }
        System.out.println(map.get(hfc)+" "+hfc);
    }
    public static void main(String[] args) {
        String str = "abrakadabra";

        getHeighestFrequencyCharacter(str);
    }
}
