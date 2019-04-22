package elvis.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class UpgradeLock {
    public static void main(String[] args){
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        lock.readLock().lock();
        System.out.println("got read lock.");
        lock.writeLock().lock();
        System.out.println("got write lock.");
    }
}
