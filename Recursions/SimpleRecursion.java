package Recursions;

import java.util.Arrays;
import java.util.Scanner;

public class SimpleRecursion {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//        pd(5);

//        System.out.println(factorial(4));

//        System.out.println(fibb(5));

        int[] ar = {3,4,1,22,66};
//        System.out.println(linearSearch(ar,1,0));

//        pattern(4,0);

//        pattern2(1,0,4);

        bubbleSort(ar.length-1,0,ar);
        System.out.println(Arrays.toString(ar));
    }
    public static void pd(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        pd(n-1);
        System.out.println(n);
    }
    // factorial
    public static int factorial(int n){
        if(n<2){
            return 1;
        }
        return factorial(n-1)*n;
    }

    // fobbonacci series
    public static int fibb(int n ){
        if(n<2){
            return n;
        }
        return fibb(n-1)+fibb(n-2);

    }

    //  linear search using recursion
    public static int linearSearch(int[] ar, int elem, int i){
        if(ar==null){
            return -1;
        }
        if(elem==ar[i]){
            return i;
        }
        return linearSearch(ar,elem,i+1);
    }

    // bubble sort using recursion

    public static void bubbleSort(int row, int col, int[] ar){
        if(row==0){
            return;
        }
        if(row==col){
            bubbleSort(row-1,0,ar);
            return;
        }
        if(ar[col]>ar[col+1]){
                int temp = ar[col];
                ar[col] = ar[col+1];
                ar[col+1]=temp;
        }
        bubbleSort(row,col+1,ar);

    }

    // triangle pattern using recursion
    public static void pattern(int row, int col){
        if(row==0){
            return;
        }
        if(col==row){
            System.out.println();
           pattern(row-1,0);
        }
        else{
            System.out.print("*");
            pattern(row,col+1);
        }
    }

    // pattern2 using recursion
    public static void pattern2(int row, int col,int n){
        if(row>n){
            return;
        }
        if(col==row){
            System.out.println();
            pattern2(row+1,0,n);
        }
        else{
            System.out.print("*");
            pattern2(row,col+1,n);
        }
    }
}
