package sample.multi.threading;

/**
 * Created by kopelevi on 03/09/2015.
 */
public class RunnableDemo implements Runnable {

    private String threadName = "";

    public RunnableDemo(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println("Started Running..." + threadName);
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Print- " + threadName + ": " + i  );
                Thread.sleep((int) Math.random() * 5000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interuppted..." + threadName);
        }
        System.out.println("Finished Running..." + threadName);
    }


    public static void main(String[] args) {

        new Thread(new RunnableDemo("Thread1")).start();
        new Thread(new RunnableDemo("Thread2")).start();
        new Thread(new RunnableDemo("Thread3")).start();
    }
}


