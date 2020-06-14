package Recursions;

import java.util.Stack;

public class StringPermute {
    public static void main(String[] args) {

//        permutation("","abc");

//        System.out.println(permutationCount("","abc"));

        Dicepermute("",4);
        System.out.println("NUmber of dice permutations:- "+DicepermuteCount("",4));
    }
    public static void permutation(String process, String unprocess){
        if(unprocess.isEmpty()){
            System.out.println(process);
            return;
        }
        char ch = unprocess.charAt(0);
        unprocess=unprocess.substring(1);
        for (int i = 0; i <=process.length() ; i++) {
            String first= process.substring(0,i);
            String sec = process.substring(i);
            permutation(first+ch+sec,unprocess);
        }
    }
    //count permutation
    public static int permutationCount(String process, String unprocess){
        if(unprocess.isEmpty()){
          //  System.out.println(process);
            return 1;
        }
        int count =0;
        char ch = unprocess.charAt(0);
        unprocess=unprocess.substring(1);
        for (int i = 0; i <=process.length() ; i++) {
            String first= process.substring(0,i);
            String sec = process.substring(i);
           count+= permutationCount(first+ch+sec,unprocess);
        }
        return count;
    }


    // Dice permutation for a particular target of a dice number
    public static void Dicepermute(String process, int target){
        if(target==0){
            System.out.println(process);
            return;
        }
        for (int i = 1; i <=6 && i<=target ; i++) {
            Dicepermute(process+i,target-i);
        }
    }

    // count dice permutation
    public static int DicepermuteCount(String process, int target){
        if(target==0){
            return 1;
        }
        int count=0;
        for (int i = 1; i <=6 && i<=target ; i++) {
            count+=DicepermuteCount(process+i,target-i);
        }
        return count;
    }
}
