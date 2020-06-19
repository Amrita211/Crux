package Hashmap;

import java.util.HashMap;

public class HashmapDemo {
    public static void main(String[] args) {
        HashMap<Character,Integer> map = new HashMap<>();
        System.out.println(frequencyChar(map,"aabcddef"));
    }

    private static HashMap<Character, Integer> frequencyChar(HashMap<Character, Integer> map , String str) {
        for(int i=0; i<str.length();i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
        }
        return map;
    }
}
