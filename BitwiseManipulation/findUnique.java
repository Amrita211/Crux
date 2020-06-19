package BitwiseManipulation;


// find a unique number present in the array which occurs only once and there is only one unique number
public class findUnique {
    public static void main(String[] args) {
        int[] ar  ={1,1,2,5,7,7,6,2,4,4,5};
        unique(ar);
    }
    public static void unique(int[] ar){

        int uni = ar[0];
        for(int i=0; i<ar.length-1;i++){
            uni = uni^ar[i+1];
        }
        System.out.println(uni);
    }
}
