package misc;

import java.util.LinkedList;
import java.util.Queue;

public class CustomBlockingQueue {
    private Queue<Integer> queue;
    private int capacity;

    public CustomBlockingQueue( int capacity) {
        this.queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public boolean addElement(int item){
       synchronized (queue){
           while (queue.size() == capacity){
               try {
                   queue.wait();
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
           queue.add(item);
           queue.notifyAll();

       }
       return true;
         }
   public int removeItem() {
        synchronized (queue){
            while (queue.size() == 0){
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
          int item =  queue.poll();
            queue.notifyAll();
            return item;

        }
    }


}
