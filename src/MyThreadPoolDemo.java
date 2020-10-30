

import java.util.concurrent.*;

//手写线程池
public class MyThreadPoolDemo {
    public static void main(String[] args) {
       ExecutorService threadpool = new ThreadPoolExecutor(2,
                5,
                3L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        try {
            for (int i = 1; i <=12 ; i++) {
                threadpool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"号业务员 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadpool.shutdown();
        }


    }




//
//    private static void test() {
//        ExecutorService threadpool = Executors.newFixedThreadPool(3);
//        ExecutorService threadpoo2 = Executors.newSingleThreadExecutor();
//        ExecutorService threadpoo3 = Executors.newCachedThreadPool();
//
//        try {
//            for (int i = 1; i <=30 ; i++) {
//                threadpoo3.execute(()->{
//                    System.out.println(Thread.currentThread().getName()+"业务员执行任务");
//                });
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            threadpoo3.shutdown();
//        }
//    }
}
