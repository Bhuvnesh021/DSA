package threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerProblem {
    private int counter = 0;
    private Queue<Integer> queue = new LinkedList<>();
    private int MAX = 500;
    private ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        ProducerConsumerProblem problem = new ProducerConsumerProblem();
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    problem.produce();
                }
            }
        });
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    problem.consume();
                }
            }
        });
        producer.start();
        consumer.start();
    }
    private void produce() {

            try {
               if(queue.size() > 10) {
                   lock.lock();
               }
                System.out.println("produce : "+counter++);
                queue.add(counter);
            }finally {
                lock.unlock();
            }


    }
    private void consume(){
        try{
            if(lock.tryLock()) lock.lock();
            System.out.println("consume " +queue.poll());
        }finally {
            lock.unlock();
        }
    }
}
