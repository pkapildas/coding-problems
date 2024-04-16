package concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.StampedLock;

public class BlockingQueue<T> {
    private Queue<T> queue = new LinkedList<>();
    private int capacity;
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public void put(T element)  throws InterruptedException{
        lock.lock();
        try {
            while (queue.size() == capacity){
                notFull.await();
            }
            queue.add(element);
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException{
        lock.lock();
        try{
            while (queue.isEmpty()){
                notEmpty.wait();
            }
            return queue.remove();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Integer> qu = new BlockingQueue<Integer>(5);
        try {
            qu.put(10);
            qu.put(11);
            Integer take = qu.take();

            System.out.println("-- element --"+take);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
