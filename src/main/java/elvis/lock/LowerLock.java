package elvis.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁可以降级, 不能升级
 */

public class LowerLock {
    public static void main(String[] args) throws InterruptedException {
        final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        lock.writeLock().lock();
        System.out.println("got write lock.");
        new Thread() {
            @Override
            public void run(){
                lock.writeLock().lock();
                System.out.print("I got write lock");
                lock.writeLock().unlock();
            }
        }.start();
        Thread.sleep(3000);
        lock.readLock().lock();
        System.out.println("got read lock.");
        lock.readLock().unlock();
        lock.writeLock().unlock();
    }
}
