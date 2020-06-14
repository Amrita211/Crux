package Arrayss;
// row wise wave

public class waveArray {
    public static void main(String[] args) {
        int[][] ar = {{1,2,3},
                      {4,5,6},
                      {7,8,9}};
        wavePrint(ar);
    }

    private static void wavePrint(int[][] ar) {
        for (int i = 0; i <ar.length ; i++) {
            if(i%2!=0){
                for (int j = ar.length-1; j >=0 ; j--) {
                    System.out.print(ar[i][j]+" ");
                }
            }
            else{
                for (int j = 0; j <ar.length ; j++) {
                    System.out.print(ar[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
}
