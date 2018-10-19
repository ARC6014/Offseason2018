package frc.team6014.robot.subsystems;

import frc.team6014.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

/**
 * A subsystem for controlling the arm and its components.
 */
public class Elevator extends Subsystem {
    VictorSPX elevatorMain = RobotMap.elevatorLeft;
    VictorSPX elevatorRight = RobotMap.elevatorRight;

    //public double defSpeed = 0.6;
    //public double maxSpeed = 0.8;

    public Elevator() {
        elevatorMain.setInverted(true);
        elevatorRight.setInverted(true);
        elevatorRight.follow(elevatorMain);
        }

    @Override
    public void initDefaultCommand() {
    }

    public void setElevatorSpeed(double speed) {
        elevatorMain.set(ControlMode.PercentOutput, speed);
    }

}