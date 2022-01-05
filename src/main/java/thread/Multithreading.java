package thread;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Multithreading extends Thread {
    private String name;

    public Multithreading(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + ": Test");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Logger.getLogger(Multithreading.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
