package Threadss;

public class ThreadObject extends Thread {
    public void run(){
        System.out.println("threadObject will extend thread class ");
    }
    public void newrun(){
        System.out.println(" just for demo !...");
    }
    public static void main(String[] args) {
        ThreadObject t1 = new ThreadObject();
        t1.run();
        t1.newrun();
    }
}
