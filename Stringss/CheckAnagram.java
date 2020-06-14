package Stringss;

import java.util.Scanner;

public class CheckAnagram {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str1 = s.nextLine();
        String str2 = s.nextLine();
        System.out.println(anagram(str1,str2));
    }
    private static boolean anagram(String str1, String str){
        str1 =str1.toLowerCase();
        str = str.toLowerCase();
        StringBuilder str2 = new StringBuilder(str);
        boolean res = false;
        if(str1.length()==str2.length()) {
            for (int i = 0; i < str1.length(); i++) {
                for (int j = 0; j < str2.length(); j++) {
                    if (str1.charAt(i) == str2.charAt(j)) {
                        str2.deleteCharAt(j);
                        if (i == str1.length() - 1 && str2.length()==0){
                            res= true;
                            break;
                        }
                        break;
                    }
                }
            }
        }
        return res;
    }
}
