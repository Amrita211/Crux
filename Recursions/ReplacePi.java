package Recursions;

import java.util.Scanner;

public class ReplacePi {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//        String str = s.nextLine();
//        replaceAllPi("",str);
        System.out.println(replaceAllPi("ppi34phgpiiipip"));

    }

    private static String replaceAllPi(String str){
        if(str.length()<2){
            return str ;
        }
       if(str.charAt(0)=='p' && str.charAt(1)=='i' && str.length()>=2){
           return "3.14"+replaceAllPi(str.substring(2));
       }
       return str.charAt(0)+replaceAllPi(str.substring(1));
    }
}
