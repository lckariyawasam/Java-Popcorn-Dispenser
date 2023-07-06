public class PopcornDispenser {
    public static void main(String[] args) {
        OutputBin outputBin = new OutputBin();

        Thread cooker1 = new Thread(new Cooker(outputBin), "Cooker 1");
        Thread cooker2 = new Thread(new Cooker(outputBin), "Cooker 2");
        Thread robotArm = new Thread(new RobotArm(outputBin), "Robot Arm");

        
        cooker1.start();
        cooker2.start();
        robotArm.start();
    }
}
