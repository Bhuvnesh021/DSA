package threads;

import java.util.concurrent.locks.ReentrantLock;

public class CounterIncrementProblem {
    int counter = 0;
    ReentrantLock reentrantLock = new ReentrantLock();
    public static void main(String[] args) {
        CounterIncrementProblem lock = new CounterIncrementProblem();

        Thread t1 =  new Thread(new Runnable() {
            @Override
            public void run() {
                lock.increment();
            }
        });
        Thread t2 =  new Thread(new Runnable() {
            @Override
            public void run() {
                lock.increment();
            }
        });
        t1.start();
        t2.start();
    }
    private void increment() {
        reentrantLock.lock();
        for (int i = 0; i < 5; i++) {
            System.out.println("Counter Incremented By : "+ Thread.currentThread().getName());
            counter++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        reentrantLock.unlock();

    }

}
