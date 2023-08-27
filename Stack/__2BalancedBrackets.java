import java.util.Stack;

public class __2BalancedBrackets{
    public static void checkBalancedBrackets(String str){
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '{' || ch == '[' || ch == '('){
                stk.push(ch);
            }else{
                if(stk.peek() == '(' && ch == ')'){
                    stk.pop();
                }else if(stk.peek() == '{' && ch=='}'){
                    stk.pop();
                }else if(stk.peek() == '[' && ch==']'){
                    stk.pop();
                }
            }
        }
        if(stk.size() == 0){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
    public static void main(String[] args) {
        String str = "[(a+b)+{(c+d)*(e/f)}+(a+b)]";
        String str1 = "[(a+b)+{(c+d)*(e/f";

        checkBalancedBrackets(str);
    }
}