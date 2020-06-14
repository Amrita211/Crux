package Arrayss;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] ar = {34,2,5,4,66,7,1};
        quicksort(ar,0,ar.length);
        System.out.println(Arrays.toString(ar));
    }
    public static void quicksort(int[] ar, int start, int end){
//        start=0;
//        end =ar.length-1;
        if(start>=end){
            return;
        }
        int pivot = end-1;
        pivot = changePivot(ar,start,pivot);
        quicksort(ar,start,pivot);
        quicksort(ar,pivot+1,end);
    }
    public static int changePivot(int[] ar, int start,int pivot){
        int j=start;
        for (int i = start; i <pivot ; i++) {
            if(ar[i]<ar[pivot]){
                swap(ar,i,j);
                j++;
            }

        }
        swap(ar,j,pivot);
        return j;
    }

    public static void swap(int[] ar,int i, int j){
        int temp = ar[i];
        ar[i]=ar[j];
        ar[j]=temp;
    }
}
