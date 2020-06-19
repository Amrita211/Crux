package Threadss;

public class CurrentThread extends  Thread {

    public void run(){
//        System.out.println("current thread : "+Thread.currentThread().getName());
//        System.out.println("Priority is : "+ Thread.currentThread().getPriority());

        if(Thread.currentThread().isDaemon()){
            System.out.println("Daemon thread hai ...");
        }
        else{
            System.out.println("user thread hai");
        }
    }
    public static void main(String[] args) {
        CurrentThread t1 = new CurrentThread();
        CurrentThread t2 = new CurrentThread();
        CurrentThread t3 = new CurrentThread();

        // set priority ( 1 to 10 ki range hoti hai)
//        t1.setPriority(MIN_PRIORITY);
//        t2.setPriority(MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.setDaemon(true);  // Daemon thread is to just provide service to the user thread for baackground support
        t3.start();       //daemon thread should be set before starting it ...otherwise it will throw exception


    }
}
