package elvis.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁可以降级, 不能升级
 */

public class LowerLock {
    public static void main(String[] args){
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        lock.writeLock().lock();
        System.out.println("got  write lock.");
        lock.readLock().lock();
        System.out.println("got read lock.");
    }
}
