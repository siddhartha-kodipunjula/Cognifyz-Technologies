import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadedApplication {
    private static int counter = 0;
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Incrementer());
        Thread t2 = new Thread(new Decrementer());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final counter value: " + counter);
    }

    private static class Incrementer implements Runnable {
        public void run() {
            for (int i = 0; i < 100000; i++) {
                lock.lock();
                try {
                    counter++;
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private static class Decrementer implements Runnable {
        public void run() {
            for (int i = 0; i < 100000; i++) {
                lock.lock();
                try {
                    counter--;
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
