package edu.itc.se.lab01.Task2;

public class SynchronizedCounter implements Counter{
    private long count;

    @Override
    public void increment() {
        count++;
        
    }

    @Override
    public long get() {
        return count;
    }

   
}
