package Arrayss;

public class searchInSortedMatrix {
    public static void main(String[] args) {
        int[][] ar= {{1,2,3},
                    {4,5,6},
                    {7,8,9}};
            SortedArraySearch(ar,4);
    }

    private static void SortedArraySearch(int[][] ar, int elem) {
        int i=0;
        int j=ar.length-1;
        while(i<ar.length && j>=0){
            if(ar[i][j]==elem){
                    System.out.print(i+","+j);
                    return;
                }
             if(elem<ar[i][j]){
                    j--;
            }
            else{
                i++;
            }
        }
    }
}
