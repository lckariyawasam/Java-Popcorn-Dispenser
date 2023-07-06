public class Cooker implements Runnable {
    private OutputBin outputBin;

    public Cooker(OutputBin outputBin) {
        this.outputBin = outputBin;
    }

    public void run() {
        while(true) {
            Popcorn bag = cook();
            outputBin.placeBag(bag);
        }
    }

    public Popcorn cook() {
        try {
            Thread.sleep(5000); // Simulate the time taken to cook
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
        System.out.println(Thread.currentThread().getName() + " produced a bag");
        return new Popcorn("Popcorn Produced by " + Thread.currentThread().getName());
    }
}
