package Arrayss;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
    int[] ar = {34,2,6,55,7,1,98};
        System.out.println(Arrays.toString(divideArray(ar)));
    }

    public static int[] divideArray(int[] ar){
        if(ar.length==1){
            return ar;
        }
        int mid = (ar.length)/2;
        int[] first = divideArray(Arrays.copyOfRange(ar,0,mid));
        int[] sec = divideArray(Arrays.copyOfRange(ar,mid,ar.length));
        return mergeSort(first,sec);
    }
    public static int[] mergeSort(int[] first, int[] sec){

        int[] mix = new int[first.length+sec.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<first.length && j<sec.length){
            if(first[i]<sec[j]){
                mix[k] = first[i];
                i++;
                k++;
            }
            else{
                mix[k] = sec[j];
                j++;
                k++;
            }
        }
        while(i<first.length){
            mix[k] = first[i];
            i++;
            k++;
        }
        while(j<sec.length){
            mix[k] = sec[j];
            j++;
            k++;
        }
        return mix;
    }
}
