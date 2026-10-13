package edu.itc.se.lab01.Task1;

/**
 * CountdownTask
 */
public class CountdownTask implements Runnable{
    @Override 
    public void run(){
        Countdown.countdown(Thread.currentThread().getName());
    }
}
