import java.util.concurrent.*;

public class MyThreadPoolDemo1 {

    public static void main(String[] args) {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(3,
                5,
                12L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());


        for (int i = 0; i <10 ; i++) {
            pool.execute(()->{
                System.out.println(Thread.currentThread().getName()+"号业务员操作业务");
            });
        }

        pool.shutdown();

    }
}
