import java.util.concurrent.TimeUnit;

public class LockTest {
    private static Object obA = new Object();
    private static Object obB = new Object();
    public static void main(String[] args) {

        new Thread(()->{
            synchronized (obA){
                System.out.println("A持有A锁,正在等待持有B锁");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized(obB) {
                    System.out.println("A获得B锁");
                }
            }
        },"A").start();

        new Thread(()->{
            synchronized (obB){
                System.out.println("B持有B锁,正在等待持有A锁");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized(obA) {
                    System.out.println("B获得A锁");
                }
            }
        },"B").start();


    }



}
