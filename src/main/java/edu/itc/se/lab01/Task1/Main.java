package edu.itc.se.lab01.Task1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        boolean sequential = args.length > 0 && args[0].equals("--sequential");

        Thread apollo  = new Countdown("apollo");
        Thread gemini  = new Thread(new CountdownTask(), "gemini");
        Thread mercury = new Thread(() -> { /* TODO: reuse CountdownTask logic */ }, "mercury");
        Thread artemis = Thread.ofVirtual().name("artemis").unstarted(new CountdownTask());
        Thread thread[] = {apollo, gemini, mercury, artemis};

        for (Thread th : thread) {

            try {
                if (sequential){
                th.run();
            }
            else{
                th.start();
            }
            } catch (Exception e) {
                // TODO: handle exception
            }
            
        }
        // TODO: start (or run) all four depending on 'sequential'
        System.out.println("Mission control: all launched");
        for (Thread th : thread) {
            try {
                th.join();
            } catch (Exception e) {
                // TODO: handle exception
            }
            

        }
        // TODO: join all four
        System.out.println("Mission control: all landed");
        // TODO: print name, isVirtual(), getState() of each
        for (Thread th : thread) {
            System.out.printf("%-8s virtual=%-5b state=%s%n", th.getName(), th.isVirtual(), th.getState());
        }
    }
}
