import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) throws InterruptedException {
        MyCache myCache = new MyCache();

        for (int i = 1; i <=5 ; i++) {
            int num = i;
            new Thread(()->{
                myCache.put(String.valueOf(num),String.valueOf(num));
            },String.valueOf(i)).start();
        }

        TimeUnit.SECONDS.sleep(3);

        for (int i = 1; i <=5 ; i++) {
            int num = i;
            new Thread(()->{
                myCache.get(String.valueOf(num));
            },String.valueOf(i)).start();
        }

    }
}

class MyCache{
    private volatile Map<String,Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //写方法
    public void put(String key,Object value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"开始写"+key+"!!!!");
            Thread.sleep(3000);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写结束"+key+"!!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }


    //读方法
    public void get(String key){
            readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"开始读"+key+"!!!!");
            Thread.sleep(3000);
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName()+"读结束"+result+"!!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}