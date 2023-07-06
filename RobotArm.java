public class RobotArm implements Runnable {
    private OutputBin outputBin;

    public RobotArm(OutputBin outputBin) {
        this.outputBin = outputBin;
    }

    public void run() {
        while(true) {
            Popcorn bag = outputBin.grabBag();
            System.out.println("Picked up popcorn bag: " + bag.getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
