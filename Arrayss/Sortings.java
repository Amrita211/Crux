package Arrayss;

import java.util.Arrays;

public class Sortings {
    public static void main(String[] args) {
        int[] ar = {4,6,33,1,7,9};
//        bubbleSort(ar);

      //  selectionSort(ar);

        insertionSort(ar);
    }
//bubble sorting
    private static void bubbleSort(int[] ar) {
        for (int i=0;i<ar.length-1;i++){
            for (int j = 0; j <ar.length-1-i ; j++) {
                if(ar[j]>ar[j+1]){
                    int temp = ar[j];
                    ar[j] = ar[j+1];
                    ar[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(ar));
    }

    // selection sorting
    public static void selectionSort(int[] ar){
        for (int i = 0; i <ar.length-1 ; i++) {
            int min = i;

            for ( int j = i+1; j <ar.length ; j++) {
                if(ar[j]<ar[min]){
                    min=j;
                }
            }
            if(i!=min){
                int temp = ar[min];
                ar[min] = ar[i];
                ar[i] = temp;
            }
        }
        System.out.println(Arrays.toString(ar));
    }

    // insertion sorting
    public static void insertionSort(int[] ar){
        for (int i = 0; i <ar.length-1 ; i++) {
            for(int j=i+1;j>0;j--){
                if(ar[j]<ar[j-1]){
                    int temp = ar[j];
                    ar[j] = ar[j-1];
                    ar[j-1]=temp;
                }
                else{
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(ar));
    }
}
