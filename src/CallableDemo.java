import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyThread implements Runnable{
    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"----Callable----");
        TimeUnit.SECONDS.sleep(4);
        return 200;
    }
}

/**
 *
 *
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
       FutureTask<Integer> ft = new FutureTask<>(new MyThread2());
        FutureTask<Integer> ft2 = new FutureTask<>(()->{
            System.out.println(Thread.currentThread().getName()+"----Callable----");
            TimeUnit.SECONDS.sleep(4);
            return 1024;
        });

       new Thread(ft,"zhang3").start();

        new Thread(ft2,"li4").start();
        System.out.println(Thread.currentThread().getName());

        System.out.println(ft.get());
        System.out.println(ft2.get());


    }
}
