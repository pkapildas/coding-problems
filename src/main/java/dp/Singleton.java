package dp;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * ensure only one object will be created
 * two kid of implementation
 *    1. early Implementation - create at load time
 *    2.Lazy Implementation  - create when required.
 *
 *    usage for DB connection , Logging, driver Objects , Caching and ThreadPool
 *    saves Memory
 */
public class Singleton  implements Serializable {
    protected Object readResolve(){
        return instance;
    }
    private static volatile Singleton instance  = null;
    private Singleton() {
        if(instance!=null){
            throw new IllegalStateException("cant create via reflection");
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public static Singleton getInstance() {
        if(instance ==null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                    System.out.println("Object Created");

                }
            }
        }

        return instance;
    }
    public void message(){
        System.out.println("Singletone");
    }

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
      /*  Thread t1  = new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton singleton = Singleton.getInstance();
                singleton.message();
            }
        });
        t1.start();

        Thread t2  = new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton singleton = Singleton.getInstance();
                singleton.message();
            }
        });
        t2.start();

    */
        Singleton singleton1 = Singleton.getInstance();
        singleton1.message();
        //singleton1.clone()
     /*   Constructor<?>[] declaredConstructors = Singleton.class.getDeclaredConstructors();
        for(Constructor constructor : declaredConstructors){
            constructor.setAccessible(true);
            singleton1 = (Singleton) constructor.newInstance();
*/
       // }


    }
    //
}
