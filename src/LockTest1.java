import java.util.concurrent.TimeUnit;

public class LockTest1 {


    private static Object object1 = new Object();
    private static Object object2 = new Object();


    public static void main(String[] args) {
            new Thread(()->{
                synchronized (object1){

                    try {
                        System.out.println("A线程已加载");
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println("A准备加载B线程");
                        synchronized (object2){
                            System.out.println("A线程已获得B");
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"A").start();


        new Thread(()->{
            synchronized (object2){

                try {
                    System.out.println("B线程已加载");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("B准备加载A线程");

                    synchronized (object1){
                        System.out.println("B线程已加获得A");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();


    }
}
