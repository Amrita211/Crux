package Arrayss;

import java.util.Scanner;

public class searching {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] ar = new int[6];
        for (int i = 0; i <6 ; i++) {
            int numbers = s.nextInt();
            ar[i] =numbers;

        }
        System.out.println("Enter the element to be searched");
        int elem =s.nextInt();

//        System.out.println(linearSearch(ar,elem));
//            int[] ar1 = {3,5,2,7,8,44};
        System.out.println(binarySearch(ar,elem));
    }

    private static int linearSearch(int[] ar, int elem) {
        for (int i = 0; i <ar.length ; i++) {
            if(elem==ar[i]){
                return i;
            }
        }
        return -1;
    }

    // binary search
    public static int binarySearch(int[] ar, int elem){
        int start =0;
        int end = ar.length-1;
        while(start<=end){
            int mid = (start+end)/2 +1;
            if(elem==ar[mid]){
                return mid;
            }
            else if(elem<ar[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
}
