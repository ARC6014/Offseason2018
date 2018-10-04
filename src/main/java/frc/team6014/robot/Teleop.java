package frc.team6014.robot;

public class Teleop {
    public static void init() {
        Robot.lidar.start();
    }

    public static void periodic() {
        Robot.lidar.sample();
        int[][] vision = Robot.lidar.getVision();

        for (int i = 0; i < vision.length; i++) {
            for (int j = 0; j < vision[i].length; j++) {
                System.out.print(vision[i][j] + " ");
            }
            System.out.println("");
        }
     }
}