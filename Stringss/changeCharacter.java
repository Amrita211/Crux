package Stringss;

import java.util.Scanner;

public class changeCharacter {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        changeChar(str);


//        String st = "hi";
//        StringBuilder builder = new StringBuilder(st);
//        st+="hello";
//        builder.append("Hello");
//        System.out.println(st);
//        System.out.println(builder);
    }
    private static void changeChar(String str){
        StringBuilder build = new StringBuilder();
        for(int i=0; i<str.length();i++){
            char ch =str.charAt(i);
            if(ch>='A' && ch<='Z'){
                ch = (char)('a'+(ch-'A'));
            }
            else if(ch>='a' && ch<='z'){
                ch = (char)('A'+(ch-'a'));
            }
            build.append(ch);
        }
        System.out.println(build);
    }

}
