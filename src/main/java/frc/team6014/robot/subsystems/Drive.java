package frc.team6014.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.team6014.robot.RobotMap;
import frc.team6014.robot.Robot;

public class Drive extends Subsystem
{
    public final double defSpeed = 0.9;
    public double maxSpeed = 0.9;

    VictorSPX frontLeft = RobotMap.frontLeft;
    VictorSPX rearLeft = RobotMap.rearLeft;
    VictorSPX frontRight = RobotMap.frontRight;
    VictorSPX rearRight = RobotMap.rearRight;

    /*private final int leftEncoderCPR = 2048;
    private final int rightEncoderCPR = 2048;
    private final double wheelDiam = 0.1524;//In meters, actually 6 inches*/



    /*public double getLeftEncoderRev() {
        return Robot.drive.getLeftEncoderPos()/(double)(leftEncoderCPR);
    }

    public double getRightEncoderRev() {
        return Robot.drive.getRightEncoderPos()/(double)(rightEncoderCPR);
    }

    public double getLeftDistance() {
        return 2*getLeftEncoderRev()*wheelDiam*Math.PI;
    }

    public double getRightDistance() {
        return 2*getRightEncoderRev()*wheelDiam*Math.PI;
    }*/



    public Drive() {
        frontRight.setInverted(true);
        rearRight.setInverted(true);

        rearLeft.follow(frontLeft);
        rearRight.follow(frontRight);

        frontLeft.configNeutralDeadband(0.02, 20);
        frontRight.configNeutralDeadband(0.02, 20);

        /*frontLeft.setSensorPhase(true);
        frontRight.setSensorPhase(true);

        frontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 20);
        frontRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 20);
        */
        this.setMaxOutput(maxSpeed);
    }



    @Override
    public void initDefaultCommand() {
    }


    /*public int getLeftEncoderPos() {
        return frontLeft.getSelectedSensorPosition(0);
    }
    public int getRightEncoderPos() {
        return frontRight.getSelectedSensorPosition(0);
    }

    public void resetEncoders() {
        frontLeft.setSelectedSensorPosition(0,0,20);
        frontRight.setSelectedSensorPosition(0, 0, 20);
    }*/

    public void setMaxOutput(double speed) {
        maxSpeed = speed;
    }
    private double limit(double value) {
        if (value > 1.0) {
            return 1.0;
        }
        if (value < -1.0) {
            return -1.0;
        }
        return value;
    }



    public void arcadeDrive(double speed, double rotation) {
        double left,right;
        //speed = Math.copySign(speed*speed, speed);
        //rotation = Math.copySign(rotation*rotation, rotation);

        double maxInput = Math.copySign(Math.max(Math.abs(speed), Math.abs(rotation)), speed);
        if (speed >= 0.0) {
            // First quadrant, else second quadrant
            if (rotation >= 0.0) {
                left = maxInput;
                right = speed - rotation;
            } else {
                left = speed + rotation;
                right = maxInput;
            }
        } else {
            // Third quadrant, else fourth quadrant
            if (rotation >= 0.0) {
                left = speed + rotation;
                right = maxInput;
            } else {
                left = maxInput;
                right = speed - rotation;
            }
        }
        frontLeft.set(ControlMode.PercentOutput, limit(left)*maxSpeed);
        frontRight.set(ControlMode.PercentOutput, limit(right)*maxSpeed);
    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
        frontLeft.set(ControlMode.PercentOutput, limit(leftSpeed)*maxSpeed);
        frontRight.set(ControlMode.PercentOutput, limit(rightSpeed)*maxSpeed);
    }


}
