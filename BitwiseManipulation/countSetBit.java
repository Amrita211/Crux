package BitwiseManipulation;

import java.util.Scanner;

public class countSetBit {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(count(n));
        swapping(34,21);

        System.out.println(oddEven(36)?"odd":"even");
    }
    public static int count(int n){
        if(n==0){
            return 0;
        }
        int cnt =0;
        while(n!=0){
            if((n & 1 )==1){
                cnt+=1;
            }
            n = n>>1;
        }
        return cnt;
    }

    public static void swapping(int first , int sec){
        first = first^sec;
        sec=first^sec;
        first=first^sec;

        System.out.println("After swapping : "+ first+" , "+sec);
    }

    public static boolean oddEven(int  n){
        if((n&1)==1){
            return true;
        }
        return false;
    }
}
