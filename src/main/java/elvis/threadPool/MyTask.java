package elvis.threadPool;

import java.time.LocalDateTime;

public class MyTask implements Runnable{

    public MyTask(){
        super();
    }

    public MyTask(int id){
        this.id = id;
        System.out.println(LocalDateTime.now()+"\tMyThread : "+id+" created");
    }

    public int getId(){
        return this.id;
    }

    private int id = 0;

    @Override
    public void run() {
        try {
            System.out.println(LocalDateTime.now()+"\tMyThread : "+id+" running");
            Thread.sleep(1000);
            MyThreadPool.that.getActiveCount();
//            System.out.println(LocalDateTime.now()+"\tMyThread : "+id+": ActiveCount="+MyThreadPool.that.getActiveCount());
//            System.out.println(LocalDateTime.now()+"\tMyThread : "+id+": CompletedTaskCount="+MyThreadPool.that.getCompletedTaskCount());
//            System.out.println(LocalDateTime.now()+"\tMyThread : "+id+": TaskCount="+MyThreadPool.that.getTaskCount());
//            System.out.println(LocalDateTime.now()+"\tMyThread : "+id+": QueueSize="+MyThreadPool.that.getQueue().size());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
