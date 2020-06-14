package Queuee;

public class SimpleQueue {
    int[] que ;
    int defaultsize=10;
    int size=0;
    int front;
    int end;
    public SimpleQueue(){
        this.que = new int[defaultsize];
        this.front=0;
        this.end=0;
    }

    // insertion of elements
    private  void insertion(int value) throws Exception{
        if(isfull()){
            throw new Exception("Bharaa hua hai");
        }
        que[end++]=value;
        size++;
    }
    public  boolean isfull(){
        return size==defaultsize;
    }

    // deletion
    public int remove(){
        if(isempty()){
            System.out.println("khaali hai");
            return -1;
        }
        int temp = que[front++];
        size--;
        return temp;
    }
    public boolean isempty(){
        return size==0;
    }

    // displaying
    public void diplay(){
        for (int i = front; i <end ; i++) {
            System.out.print(que[i]+" ");
        }
    }
    public static void main(String[] args) throws Exception {
        SimpleQueue obj = new SimpleQueue();
        for (int i = 0; i <10 ; i++) {
            obj.insertion(i);
        }
//        try {
//            for (int i = 0; i <11 ; i++) {
//                obj.insertion(i);
//            }
//        }
//        catch (Exception e){
//            System.out.println(e);
//        }

        System.out.println();
        System.out.println(obj.remove());
        System.out.println();
        obj.diplay();
    }
}
