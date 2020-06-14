package Stringss;

import java.util.Scanner;

public class frequencyOfCharacters {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
//        frequency(str);
        FreqChar(str);
//        frequency2(str);
    }
    private static void frequency(String str){  // not giving correct output
        char[] fre = new char[256];
        for(int i =0; i<str.length();i++){
            char ch = str.charAt(i);
            fre[ch]++;
        }

    }
    private static void FreqChar(String str){
        int[] fre = new int[26];
        for(int i =0;i<str.length();i++){
            char ch = str.charAt(i);
            fre[ch-'a']++;
        }
        for (int i = 0; i <fre.length ; i++) {
            System.out.print(fre[i]+" ");
        }
        // find maximum character
        int max = 0;
        for (int i = 0; i <fre.length ; i++) {
            if(fre[max]<fre[i]){
                max=i;
            }
        }
        System.out.println("maximum occuring character");
        System.out.println((char)(max+'a'));

    }
    public static void frequency2(String str){
        int[] fre = new int[26];
        for (int i = 0; i <str.length() ; i++) {
            fre[str.charAt(i)-'a']++;
        }
        for (int i = 0; i <str.length() ; i++) {
            if(fre[str.charAt(i)-'a']!=0){
                System.out.print(str.charAt(i)+":");
                System.out.print(fre[str.charAt(i)-'a']+" ");

                // assign 0 the character so that it will not print same character again
                fre[str.charAt(i)-'a']=0;
            }
        }
    }
}
