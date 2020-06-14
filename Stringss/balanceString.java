package Stringss;

import java.util.Stack;

public class balanceString {
    public static void main(String[] args) {
        System.out.println(balance("[]"));
    }

    private static boolean balance(String str) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='{'|| ch=='[' || ch=='('){
                st.push(ch);
            }
            else if(ch=='}' && st.peek()=='{'){
                st.pop();
            }
            else if(ch ==')' && st.peek()=='('){
                st.pop();
            }
            else if(ch==']' && st.peek()=='['){
                st.pop();
            }
        }
        if(st.isEmpty()){
            return true;
        }
        return false;
    }
}
