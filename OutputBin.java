import java.util.LinkedList;
import java.util.Queue;

public class OutputBin {
    private final int capacity = 3;
    private Queue<Popcorn> output;

    public OutputBin() {
        output = new LinkedList<>();
    }

    public synchronized void placeBag(Popcorn bag) {
        // If the output bin is full, wait for the space to open up
        while (output.size() >= capacity) {
            try {
                System.out.println("Waiting to place bag" + Thread.currentThread().getName());
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        // filled += 1; // Simulate placing the bag in the output bin
        output.offer(bag);
        System.out.println("Current bags : " + output.size());
        notifyAll();

    }

    public synchronized Popcorn grabBag() {
        // If the output bin is empty, wait for the output bin to be filled
        while (output.size() == 0) {
            try {
                System.out.println("Waiting to pickup bag" + Thread.currentThread().getName());
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Popcorn bag = output.poll();
        System.out.println("Current bags : " + output.size());
        notifyAll();
        return bag;
    }
}
