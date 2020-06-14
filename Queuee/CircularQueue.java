package Queuee;

public class CircularQueue {
    int[] qu;
    int defaultsize=10;
    int front;
    int end;
    int size=0;
    public CircularQueue(){
        this.qu= new int[defaultsize];
        this.front=0;
        this.end=0;
    }
    // insertion
    public void insertion(int value){
        if(isfull()){
            System.out.println("queue is full");
            return;
        }
        qu[end++] = value;
        end = (end)%qu.length;
        size++;
    }
    public boolean isfull(){
        return size==qu.length;
    }

    // deletion
    public int remove(){
        if(isempty()){
            System.out.println("Empty hai");
            return -1;
        }
        int temp = qu[front++];
        front = front%qu.length;
        size--;
        return temp;
    }
    public boolean isempty(){
        return size==0;
    }

    // dislay
    public void display(){
        for(int i=0;i<size;i++){
            System.out.print(qu[(front+i)%qu.length]+" ");
        }
    }
    public static void main(String[] args) {
    CircularQueue obj = new CircularQueue();
        for (int i = 0; i <10; i++) {
            obj.insertion(i);
        }
        obj.display();

        System.out.println();
        System.out.println(obj.remove());
        System.out.println(obj.remove());
        System.out.println(obj.remove());

        obj.insertion(12);

        System.out.println();
        obj.display();
    }
}
