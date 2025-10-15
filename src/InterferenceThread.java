import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class InterferenceThread extends Thread {
    private final InterferenceExample checker;
    private static int i;

    public static final ReentrantLock lock=new ReentrantLock();


    InterferenceThread(InterferenceExample checker) {
        this.checker = checker;
    }

    private void increment(){
        i++;
    }

    int getI() {
        return i;
    }

    public void run() {
        while (!checker.stop()) {
            lock.lock();
            increment();
            lock.unlock();
        }
    }
}