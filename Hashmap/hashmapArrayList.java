package Hashmap;

import java.util.ArrayList;
import java.util.LinkedList;

public class hashmapArrayList {
    ArrayList<LinkedList<Entity>> entities =  new ArrayList<>();
    int size=0;
    float lf = 0.5f;
    public hashmapArrayList(){
        for (int i = 0; i <3 ; i++) {
            entities.add(new LinkedList<>());
        }
    }
    // insertion
    public  void putting(String key, String value){
        if((float)size/entities.size()>lf){
            rehash();
        }
        int hashcode = Math.abs(key.hashCode()%entities.size());
        LinkedList<Entity> list = entities.get(hashcode);
        for(Entity enti:list){
            if(enti.key.equals(key)){
                enti.value=value;
            }
        }
        list.add(new Entity(key,value));
        size++;
    }


    private void rehash() {
        ArrayList<LinkedList<Entity>> old = entities;
        entities = new ArrayList<>();
        for (int i = 0; i <old.size()*2 ; i++) {
            entities.add(new LinkedList<>());
        }
        size=0;
        for(LinkedList<Entity> list:old){
            for(Entity entity:list){
                putting(entity.key,entity.value);

            }
        }
    }

    
    // getting the value for a specific key
    public String getting(String key){
        int hashcode = Math.abs(key.hashCode()%entities.size());
        LinkedList<Entity> list = entities.get(hashcode);
        for(Entity enti : list){
            if(enti.key.equals(key)){
                return enti.value;
            }
        }
        return null;
    }

    // remove an Entity for a specific key
    public void remove(String key){
        Entity target=null;
        int hashcode = Math.abs(key.hashCode()%entities.size());
        LinkedList<Entity> list  = entities.get(hashcode);
        for(Entity enti:list){
            if(enti.key.equals(key)){
                target=enti;
                break;
            }
        }
        list.remove(target);
        size--;
    }

    public  class Entity{
        String key;
        String value;
        public Entity(String key, String value){
            this.key=key;
            this.value=value;
        }
    }
    public static void main(String[] args) {
        hashmapArrayList map = new hashmapArrayList();
        map.putting("fruit","apple");
        map.putting("animal","rat");
        map.putting("bird","sparrow");
        map.putting("human","abcd");

        System.out.println(map.getting("animal"));

        map.remove("human");
        System.out.println(map.getting("human"));
    }
}
