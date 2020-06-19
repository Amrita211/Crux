package Threadss;

// Thread implements the Runnable Interface
public class ThreadInterface implements Runnable{

    public void run(){
        System.out.println("Thread can implements Runnable interface");
    }
    public static void main(String[] args) {
    ThreadInterface t1 = new ThreadInterface();
    Thread thr = new Thread(t1);
    t1.run();
    }
}
