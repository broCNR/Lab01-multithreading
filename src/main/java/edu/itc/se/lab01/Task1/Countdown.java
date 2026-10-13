package edu.itc.se.lab01.Task1;

/**
 * Countdown
 */
public class Countdown extends Thread{
    Countdown(String name){
        super(name);
    }
    static void countdown(String name){
        try {
            for (int i = 3; i > 0; i--) {
            System.out.println(name +  " : " + i);
            Thread.sleep(1000);
        }   
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        System.out.println(name  + ": liftoff");
    }

    @Override 
    public void run(){
        countdown(getName());
    }
}
