package frc.team6014.robot;
import java.lang.Math;
import frc.team6014.robot.autonomous.commands.LiftElevator;
import frc.team6014.robot.autonomous.commands.TimedStraightDrive;


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
        //Robot.drive.arcadeDrive(Robot.oi.getDriveY()*Robot.oi.getReverseFactor(),Robot.oi.getDriveX());

        boolean elevatorBusy = false;

        //Automatic Drop
        if (Robot.oi.getDropAction() == true) {

            elevatorBusy = true;

            long timeoutDrop = System.currentTimeMillis() + 200;
            while (System.currentTimeMillis() < timeoutDrop) {
                Robot.elevator.setElevatorSpeed(-0.5);
            }
            Robot.elevator.setElevatorSpeed(0);

            elevatorBusy = false;

            long timeoutDrive = System.currentTimeMillis() + 300;
            while (System.currentTimeMillis() < timeoutDrive) {
                Robot.drive.arcadeDrive(0.80,0);
            }
            Robot.drive.arcadeDrive(0,0);
        }

        //Automatic Lift
        if (Robot.oi.liftLevel_1() == true) {
            elevatorBusy = true;
            long timeoutLift = System.currentTimeMillis() + 1100;
            while (System.currentTimeMillis() < timeoutLift) {
                Robot.elevator.setElevatorSpeed(1);
            }
            Robot.elevator.setElevatorSpeed(0);
            elevatorBusy = false;
        }


        if (elevatorBusy == false) {
            if (Robot.oi.getHoldFactor() == 1) {
                if (Math.abs(Robot.oi.getElevator()) <= 0.02) {
                    Robot.elevator.setElevatorSpeed(0.1);
                } else {
                    Robot.elevator.setElevatorSpeed(Robot.oi.getElevator());
                }
            } else {
                Robot.elevator.setElevatorSpeed(Robot.oi.getElevator());
            }
        }



        /*
        if(Robot.oi.getHoldElevator()) {
            Robot.elevator.setElevatorSpeed(0.1);
        } else {
            Robot.elevator.setElevatorSpeed(Robot.oi.getElevator());
        }
        */


        if(Robot.oi.getIntake()) {
            Robot.intake.setIntakeSpeed(0.65);
        } else if(Robot.oi.getLaunch()) {
            Robot.intake.setIntakeSpeed(-1.00);
        } else {
            Robot.intake.setIntakeSpeed(0);
        }


        if(Robot.oi.getFlip() == 0) {
            Robot.intake.setFlipperSpeed(0.05);
        } else {
            Robot.intake.setFlipperSpeed(Robot.oi.getFlip()*0.5);
        }

     }
}