import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//集齐七颗龙珠召唤神龙
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(7,()->{
            System.out.println("集齐七颗龙珠召唤神龙");
        });

        for (int i = 1; i <=7 ; i++) {
            new Thread(()->{

                try {
                    System.out.println(Thread.currentThread().getName()+"号龙珠被手机");
                    cb.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
