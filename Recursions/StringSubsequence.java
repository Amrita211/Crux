package Recursions;

import java.util.ArrayList;
import java.util.Collections;

public class StringSubsequence {
    public static void main(String[] args) {

    subseq("","abc");

        System.out.println("lexicographically order subsequence");
    ArrayList<String> list = new ArrayList<>();
    list = subseqOrder("","abc");
    Collections.sort(list);
        System.out.println(list);

        System.out.println("NO. of susequences:-");
        System.out.println(subseqCount("","abc"));

    }

    // subsequence
    public static void subseq(String process,String unprocess){
        if(unprocess.isEmpty()){
            System.out.println(process);
            return;
        }
        char ch = unprocess.charAt(0);
        unprocess = unprocess.substring(1);
        subseq(process+ch,unprocess);
        subseq(process,unprocess);
    }

    // subsequence in lexicographical order
    public static ArrayList subseqOrder(String process,String unprocess){
        ArrayList list = new ArrayList();
        if(unprocess.isEmpty()){
            list.add(process);
            return list;
        }
        ArrayList list1 = new ArrayList();
        char ch = unprocess.charAt(0);
        unprocess = unprocess.substring(1);
        list1.addAll(subseqOrder(process + ch, unprocess));
        list1.addAll(subseqOrder(process,unprocess));
        return list1;
    }

    //
    public static int subseqCount(String process,String unprocess){
        if(unprocess.isEmpty()){
            return 1;
        }
        int count=0;
        char ch = unprocess.charAt(0);
        unprocess = unprocess.substring(1);
        count+=subseqCount(process+ch,unprocess);
        count+=subseqCount(process,unprocess);
        return count;
    }


}
