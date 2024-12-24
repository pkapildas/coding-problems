package misc;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LruCache {
    private record  LruNode(String key, String value){}
    private final Lock lock = new ReentrantLock();
    private final Map<String,LruNode> map = new HashMap<>();
    private final Deque<LruNode> deque = new LinkedList<>();
    private final int capacity;

    public LruCache(int capacity) {
        this.capacity = capacity;
    }
    public String get(String key){
        try{
            lock.lockInterruptibly();;
            if (map.containsKey(key)) {
                LruNode node = map.get(key);
                deque.removeFirstOccurrence(node);
                deque.offerLast(node);
                return node.value;
            }

        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        finally {
            lock.unlock();
        }
        return  null;
    }

    public  void put(String key, String value){
        try{
            lock.lockInterruptibly();;
            if (map.containsKey(key)) {
                LruNode node = map.remove(key);
                deque.removeFirstOccurrence(node);
            } else  if(map.size()==capacity){
                LruNode node = deque.removeFirst();
                map.remove(node);
            }
            LruNode node = new LruNode(key,value);
            map.put(key, node);
            deque.offerLast(node);

        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        finally {
            lock.unlock();
        }
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("----- cache contents -------\n");
        for (Map.Entry<String, LruNode> entry : this.map.entrySet()) {
            stringBuilder.append(entry.getKey()+ " : " + entry.getValue().value + "\n");
        }
        stringBuilder.append("----------------------------\n");
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        LruCache lruCache = new LruCache(3);
        lruCache.put("k1","v1");
        lruCache.put("k1","v0");
        lruCache.put("k2","v2");
        lruCache.put("k3","v3");
        lruCache.put("k3","v4");

        System.out.println(lruCache.toString());

        lruCache.put("k4","v4");
        lruCache.put("k4","e4");
        lruCache.put("k5","v5");
        lruCache.put("k6","v6");
        lruCache.put("k7","v7");
        lruCache.put("k8","v8");
        lruCache.put("k9","v9");
        System.out.println(lruCache.toString());
    }
}
