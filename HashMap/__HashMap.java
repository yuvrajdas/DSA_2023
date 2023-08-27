import java.util.*;
public class __HashMap{

    public static void main(String[] args) {

        /*
         * get() => return the value if present in the map else return null
         * containsKey() => return true if present else return false
         * put() => inserts the vlaue is preseviously not present in the map else update the older value
         * 
         */


        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 143);
        map.put("china", 145);
        System.out.println(map.put("US", 45));
    }
}