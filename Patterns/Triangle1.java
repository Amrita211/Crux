package Patterns;

public class Triangle1 {
    public static void main(String[] args) {
       // trai1(5);

       // trai2(5);

        //trai3(4);

       // trai4(5);

       // diamond(3);

       // hollowDiamond(3);

        butterfly(3);
    }

    private static void trai1(int n) {
        int row = 1;
        while (row <= n) {

        int col = 1;
             while (col <= row) {
            System.out.print("* ");
            col++;
             }
            System.out.println();
        row++;
         }
    }

    public static void trai2(int n){
        int row =n;
        while(row>0){
            int col =1;
            while(col<=row){
                System.out.print("*");
                col++;
            }
            System.out.println();
            row--;
        }
    }

    // pyramid traingle

    public static void trai3(int n){
        int row =1;
        while(row<=n){
            int space =1;
            while(space<=n-row){
                System.out.print("  ");
                space++;
            }
            int col =1;
            while(col<=2*row-1){
                System.out.print("* ");
                col++;
            }
            System.out.println();
            row++;
        }
    }
// ulta pyramid triangle
    public static void trai4(int n){
        int row =n;
        while(row>0){
            int space =1;
            while (space<=n-row){
                System.out.print("  ");
                space++;
            }
            int col =1;
            while(col<=2*row-1){
                System.out.print("* ");
                col++;
            }
            System.out.println();
            row--;
        }
    }

    // diamond shape
    public static void diamond(int n){
        int row =1;
        int k=1;
        while(k<=2*n-1){
            int space =1;
            while(space<=n-row){
                System.out.print("  ");
                space++;
            }
            int col=1;
            while(col<=2*row-1){
                System.out.print("* ");
                col++;
            }


            System.out.println();
            if(k<n){
                row++;
            }
            else{
                row--;
            }
            k++;
        }
    }
    // hollow diamond pattern
    public static void hollowDiamond(int n){
        int row = n;
        int k=1;
        while (k<=2*n-1){
            int col =1;
            int sidemirror =1;
            while(sidemirror<=2*n+1){
                if(col<=row){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
                if(sidemirror<=n){
                    col++;
                }
                else {
                    col--;
                }
                sidemirror++;
            }
            System.out.println();
            if(k<n){
                row--;
            }
            else{
                row++;
            }
            k++;
        }
    }

    // butterfly pattern
    public static void butterfly(int n){
        int row =1;
        int k=1;
        while(k<=2*n-1){
            int col =1;
            int sidemirr =1;
            while(sidemirr<=2*n-1){
                if(col<=row){
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
                if(sidemirr<n){
                    col++;
                }
                else{
                    col--;
                }
                sidemirr++;
            }
            System.out.println();
            if(k<n){
                row++;
            }
            else{
                row--;
            }
            k++;
        }
    }

 }

