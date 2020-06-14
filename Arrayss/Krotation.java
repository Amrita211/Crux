package Arrayss;

import java.util.Arrays;
import java.util.Scanner;

public class Krotation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] ar = {2,33,1,55,4,7,6,88};
        int k =2;
//        s.close();
        reverse(ar,0,k-1);
//        System.out.println(Arrays.toString(ar));
        reverse(ar,k,ar.length-1);
//        System.out.println(Arrays.toString(ar));
        reverse(ar,0,ar.length-1);
        System.out.println(Arrays.toString(ar));

    }

    // reverse of array
    public static void reverse(int[] ar ,int start, int end){
        while(start<=end){
            int temp = ar[start];
            ar[start] = ar[end];
            ar[end] =temp;
            start++;
            end--;
        }
//        System.out.print(Arrays.toString(ar));
//        return ar;
    }
}
