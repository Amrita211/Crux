package Arrayss;

// along row i.e clockwise
public class spiralArray {
    public static void main(String[] args) {
        int[][] ar = {{1,2,3,44},
                   {4,5,6,33},
                   {7,8,9,22}};

        spiralPrint(ar,4,3);

        System.out.println("**************");
        int[][] ar1 = {{1,2,3},
                     {4,5,6},
                     {7,8,9}};
        spiralColumn(ar1);

    }

    private static void spiralPrint(int[][] ar,int m , int n) { // m is for no. of rows and n is for no, of colums

        int top = 0;
        int left = 0;
        int right = m - 1;
        int bottom = n - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                System.out.print(ar[top][i]+" ");
            }
            System.out.println();
            top++;
            for (int i = top; i <= bottom; i++) {
                System.out.print(ar[i][right]+" ");
            }
            System.out.println();
            right--;
            for (int i = right; i >= left; i--) {
                System.out.print(ar[bottom][i]+" ");
            }
            System.out.println();
            bottom--;
            for (int i = bottom; i >= top; i--) {
                System.out.print(ar[i][left]+" ");
            }
            System.out.println();
            left++;
        }
    }

    // along column wise
    public static void spiralColumn(int[][] ar){
        int top=0;
        int left=0;
        int right=ar.length-1;
        int bottom =ar.length-1;
        while(top<=bottom && left<=right){
            if(left%2==0){
                for (int i = top; i <=bottom ; i++) {
                    System.out.print(ar[i][left]);
                }
            }
            else {
                for (int i = bottom; i >=top ; i--) {
                    System.out.print(ar[i][left]);
                }
            }
            System.out.println();
            left++;
        }
    }
}
