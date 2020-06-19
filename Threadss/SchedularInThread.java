package Threadss;

public class SchedularInThread extends Thread {

    public void run(){
        for (int i = 0; i <5 ; i++) {
            try{
                Thread.sleep(1000);
            }
            catch (Exception e){
                System.out.println(e);
            }
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        SchedularInThread t1 = new SchedularInThread();
        SchedularInThread t2 = new SchedularInThread();
        SchedularInThread t3 = new SchedularInThread();

        t1.start();
        try{
            t1.join();
        }
        catch(Exception e){
            System.out.println(e);
        }
        t2.start();
        t3.start();
    }
}
