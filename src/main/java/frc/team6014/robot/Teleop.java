package frc.team6014.robot;

public class Teleop {
    public static void init() {
        //Robot.lidar.start();
    }

    public static void periodic() {
        /*Robot.lidar.sample();
        int[][] vision = Robot.lidar.getVision();

        for (int i = 0; i < vision.length; i++) {
            for (int j = 0; j < vision[i].length; j++) {
                System.out.print(vision[i][j] + " ");
            }
            System.out.println("");
        }*/
        Robot.drive.arcadeDrive(Robot.oi.getDriveY()*Robot.oi.getReverseFactor(),Robot.oi.getDriveX());
        if(Robot.oi.getHoldElevator()) {
            Robot.elevator.setElevatorSpeed(0.1);
        } else {
            Robot.elevator.setElevatorSpeed(Robot.oi.getElevator());
        }
        if(Robot.oi.getIntake()) {
            Robot.intake.setIntakeSpeed(0.65);
        } else if(Robot.oi.getLaunch()) {
            Robot.intake.setIntakeSpeed(-1.00);
        } else {
            Robot.intake.setIntakeSpeed(0);
        }
        Robot.intake.setFlipperSpeed(Robot.oi.getFlipFactor());
     }
}