import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;


class target{
    ReentrantLock lock1 = new ReentrantLock();
    ReentrantLock lock2= new ReentrantLock();
    void getA(){
        lock1.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"线程已加载，正在等待加载B线程");
            TimeUnit.SECONDS.sleep(2);

            getB();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock1.unlock();
        }

    }
    void getB(){
        lock2.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"线程已加载，正在等待加载A线程");
            TimeUnit.SECONDS.sleep(2);
            getA();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock2.unlock();
        }
    }
}





public class LockDeadDemo {

    public static void main(String[] args) {
        target target = new target();
        new Thread(()->{
            target.getB();
        }, "A").start();


        new Thread(()->{
            target.getA();
        }, "B").start();


    }
}
