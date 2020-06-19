package Hashmap;

public class hashmapArray {
    Entity[] entities = new Entity[100];
    // putting key and value in the entity

    public void putting(String key , String value){
        int hashcode = Math.abs(key.hashCode()%entities.length);
        entities[hashcode] = new Entity(key, value);
    }

    // getting a value for a specific key
    public String getting(String key){
        int hashcode = Math.abs(key.hashCode()%entities.length);
        if(entities[hashcode]!=null && entities[hashcode].key.equals(key)){
            return entities[hashcode].value;
        }
        return null;
    }

    // remove a Entity for a specific key


    public String remove(String key){
        Entity target=null;
        int hashcode = Math.abs(key.hashCode()%entities.length);
        if(entities[hashcode]!=null && entities[hashcode].key.equals(key)){
            target=entities[hashcode];
            entities[hashcode] = null;
        }
        String temp = target.value;
        return temp;
    }

    // displaying the hashmap
//    public void display(){
//        for(Entity enti:entities){
//            int hashcode = Math.abs(enti.key);
//            String key1 = entities[hashcode].key;
//            String value1 = entities[hashcode].value;
//            System.out.println(enti.key+" "+ enti.value);
//        }
//    }

    public class Entity{
        String key;
        String value;
        public Entity(String key, String value){
            this.key=key;
            this.value=value;
        }
    }
    public static void main(String[] args) {
        hashmapArray map = new hashmapArray();
        map.putting("fruit","apple");
        map.putting("animal","rat");
        map.putting("bird","sparrow");
        map.putting("human","abcd");

        System.out.println(map.getting("animal"));

        System.out.println(map.remove("bird"));

        System.out.println("after removal");
        System.out.println(map.getting("bird"));

    }
}
