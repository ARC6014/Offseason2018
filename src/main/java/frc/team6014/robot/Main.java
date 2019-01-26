package frc.team6014.robot;

import edu.wpi.first.wpilibj.RobotBase;

public class Main {
    private Main() {

    }

    public static void main(String[] args) {
        RobotBase.startRobot(Robot::new);
    }
}