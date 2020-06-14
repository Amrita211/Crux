package Stringss;

import java.util.Scanner;

public class reversing {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//        String str = s.nextLine();
//        System.out.print(reverse(str));

        removeDupli("aabbeffcddd");
    }
    private static char[] reverse(String str){
        char[] ar = str.toCharArray();
        int start=0;
        int end=ar.length-1;
        while(start<=end){
          char temp= ar[start];
          ar[start] = ar[end];
          ar[end] = temp;
            start++;
            end--;
        }
        return ar;
    }

    // remove consecutive duplicate
    private static void removeDupli(String str){
        int len = str.length()-1;
        String res = "";
        for(int i=0;i<str.length()-1;i++){
            char ch = str.charAt(i);
            if(ch==str.charAt(i+1)){
                continue;
            }
            else{
                res+=ch;
            }
        }
        if(str.charAt(len)!=str.charAt(str.length()-2)){
            res+=str.charAt(str.length()-1);
        }
        else{
            res+=str.charAt(str.length()-2);
        }
        System.out.print(res);
    }

    public static void removeAlter(String str){
        char curr = str.charAt(0);
        for (int i = 0; i <str.length()-1 ; i++) {
            char ch = str.charAt(i);
            if(ch==str.charAt(i+1)){
                continue;
            }
            else if(ch==curr){
                curr=str.charAt(i+1);
            }
        }
    }
}
