package Hashmap;

import LinkedLists.Linkedlistt;

import java.util.LinkedList;

public class hashmapLinked  {
    LinkedList<Entity> entities = new LinkedList<>();
    // putting value in the Entity
    public void putting(String key, String value){
        for(Entity enti: entities){
            if(enti.key.equals(key)){
                enti.value=value;
                return;
            }
        }
        entities.add(new Entity(key,value));
    }

    // getting a value of specific key
    public String getting(String key){
        for(Entity enti: entities){
            if(enti.key.equals(key)){
                return enti.value;
            }
        }
        return null;
    }

    // remove a specific key
    public String remove(String key){
        Entity target=null;
        for(Entity enti: entities){
           if(enti.key.equals(key)){
               target = enti;
               break;
           }
        }
        String temp = target.key;
        entities.remove(target);
        return temp;
    }

    // display the hashmap

    @Override
    public String toString() {
      String s=" ";
      s+=" { ";
      for(Entity enti : entities){
          s+= (enti.key +" = "+enti.value +", ");
      }
      s+= " }";
      return s;
    }
// another method for display
    public void display(){
        System.out.print("{ ");
        for(Entity enti: entities){
            System.out.print(enti.key +" = " +enti.value+" , ");
        }
        System.out.print(" }");
    }
    public class Entity{
        String key;
        String value;
        public Entity(String key, String value){
            this.key = key;
            this.value=value;

        }
    }
    public static void main(String[] args) {
    hashmapLinked map = new hashmapLinked();
    map.putting("fruit","apple");
    map.putting("animal","rat");
    map.putting("bird","sparrow");
    map.putting("human","abcd");

        System.out.println(map.getting("bird"));
        System.out.println(map.getting("bdbvdj"));

        System.out.println("remove a key:-");
        System.out.println(map.remove("human"));

        System.out.println("after removal ");
        System.out.println(map.getting("human"));

        System.out.println(map);

        map.display();
    }
}
