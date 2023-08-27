import java.util.Stack;

public class __1DuplicateBrackets{

    public static void checkDublicateBrackets(String str){
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == ')'){
                if(stk.peek() == '('){
                    System.out.println("true");
                    return;
                }else{
                    while(stk.peek() != '('){
                        stk.pop();
                    }
                    stk.pop();
                }
            }else{
                stk.push(ch);
            }
        }
        System.out.println("false");
    }
    public static void main(String[] args) {
        String str = "((a+b)+(c+d))+(a)";
        checkDublicateBrackets(str);
    }
}