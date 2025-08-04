package threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class ProducerConsumer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int CAPACITY = 5;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    private int value = 0;

    public void produce() throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (queue.size() == CAPACITY) {
                    System.out.println("Queue is full, producer waiting...");
                    notFull.await();
                }
                queue.offer(value);
                System.out.println("Produced: " + value);
                value++;
                notEmpty.signal(); // Notify consumer
            } finally {
                lock.unlock();
            }
            Thread.sleep(500); // Simulate delay
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (queue.isEmpty()) {
                    System.out.println("Queue is empty, consumer waiting...");
                    notEmpty.await();
                }
                int consumed = queue.poll();
                System.out.println("Consumed: " + consumed);
                notFull.signal(); // Notify producer
            } finally {
                lock.unlock();
            }
            Thread.sleep(800); // Simulate delay
        }
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();

        Thread producerThread = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
