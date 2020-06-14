package Recursions;

// given a matrix, we have to print the all paths from starting to reach at index[1,1] , i.e at the last

import java.util.ArrayList;

public class BacktrackingMazePath {
    public static void main(String[] args) {
//        mazePath("",3,3);

//        System.out.println(mazePathList("",3,3));

        System.out.println(mazePathCount("",3,3));
    }
    public static void mazePath(String process,int row, int col){
        if(row==1 && col==1){
            System.out.println(process);
            return;
        }
        if(row>1){
            mazePath(process+"V",row-1,col);
        }
        if(col>1){
            mazePath(process+"H",row,col-1);
        }
    }

    private static ArrayList mazePathList(String process, int row, int col){
        if(row==1 && col==1){
            ArrayList list = new ArrayList();
            list.add(process);
            return list;
        }
        ArrayList list = new ArrayList();
        if(row>1){
            list.addAll(mazePathList(process+"v",row-1,col));
        }
        if(col>1){
            list.addAll(mazePathList(process+"H",row,col-1));
        }
        return list;
    }

    public static int mazePathCount(String process,int row, int col){
        if(row==1 && col==1){
            System.out.println(process);
            return 1;
        }
        int count=0;
        if(row>1){
            count+=mazePathCount(process+"V",row-1,col);
        }
        if(col>1){
            count+=mazePathCount(process+"H",row,col-1);
        }
        return count;
    }
}
