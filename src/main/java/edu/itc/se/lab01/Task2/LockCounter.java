package edu.itc.se.lab01.Task2;
import java.util.concurrent.locks.ReentrantLock;

public class LockCounter implements Counter{
    private long count;
    private final ReentrantLock lock = new ReentrantLock();
    @Override
    public void increment() {
        lock.lock();
        try{
            count++;
        }finally{
            lock.unlock();
        }
    }

    @Override
    public long get() {
        lock.lock();
        try{
            return count;
        }finally{
            lock.unlock();
        }
    }

}