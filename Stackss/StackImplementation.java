package Stackss;

public class StackImplementation {

    int[] st ;
    int defaultsize=4;
    int top;
    int size=0;
    public StackImplementation(){
        this.st = new int[defaultsize];
        this.top=-1;
    }

    // insertion in stack
    public void insert(int value){
        if(isfull()){
            System.out.println("bharaa hua hai");
            return;
        }
        st[++top]=value;
        size++;
    }

    // remove element from the top of the stack
   public int remove(){ // throws Exception{
        if(isempty()){
//            throw new Exception("khaali hai");
            System.out.println("khaali hai");
            return -1;
        }
        int temp = st[top--];
        size--;
        return temp;
    }

    // displaying
    public void display(){
        for(int i=top;i>=0 ;i--){
            System.out.println(st[i]);
        }
    }
    private boolean isempty() {
        return size==0;
    }

    private boolean isfull() {
        return size==defaultsize;
    }

    public static void main(String[] args) throws Exception {
        StackImplementation stack = new StackImplementation();
        stack.insert(2);
        stack.insert(4);
        stack.insert(1);
        stack.insert(66);

        System.out.println();
        stack.display();

        System.out.println();
        System.out.println(stack.remove());

        System.out.println();
        stack.display();

    }
}
