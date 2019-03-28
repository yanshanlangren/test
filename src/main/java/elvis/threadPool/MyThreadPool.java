package elvis.threadPool;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.concurrent.*;

public class MyThreadPool extends ThreadPoolExecutor{

    public static MyThreadPool that;

    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    public void afterExecute(Runnable r, Throwable t){
        super.afterExecute(r, t);
        if(r instanceof MyTask){
            MyTask m = (MyTask) r;
            System.out.println("this is myTask. id="+m.getId());
        }
        if(t!=null){
            t.printStackTrace();
        }
    }


    public static void main(String[] args){
        /**
         * 核心线程数量 corePoolSize
         * 最大线程数量 maximumPoolSize
         * 线程闲置杀死时间 keepAliveTime
         * 时间单位 TimeUnit
         * 任务队列 BlockingQueue
         */
        that = new MyThreadPool(20,100,500, TimeUnit.MILLISECONDS,new SynchronousQueue<>());
        for(int i=0;i<100;i++){
            MyTask task = new MyTask(i);
            that.submit(task);
        }
        System.out.println(LocalDateTime.now() +"\tAll tasks created.");
        that.shutdown();
        System.out.println(LocalDateTime.now() +"\tExit.");
//        that.afterExecute(new Thread(){
//            @Override
//            public void run(){
//                System.out.println("afterExecute!");
//            }
//        },new Exception());

        ThreadPoolExecutor defaultPool = new ThreadPoolExecutor(20,100,500,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>());
    }
}
