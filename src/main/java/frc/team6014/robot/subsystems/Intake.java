package frc.team6014.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.team6014.robot.RobotMap;
import frc.team6014.robot.Robot;

public class Intake extends PIDSubsystem {
    VictorSPX intakeMain = RobotMap.intakeLeft;
    VictorSPX intakeRight = RobotMap.intakeRight;
    VictorSPX flipper = RobotMap.flipper;


    public Intake() {
        super(0.12,0,0.18,0.08);
        intakeRight.set(ControlMode.Follower,intakeMain.getDeviceID());
        setAbsoluteTolerance(3);
        getPIDController().setContinuous(false);
        //intakeMain.setInverted(true);
        //flipper.setInverted(true);
    }

    //final double countsPerRevolution = 546;
    private double outPID = 0;
    //private boolean dropping;
    //double dropVelocity = -10;

    @Override
    public void initDefaultCommand() {
    }


    /*
    public double getCurrentAngle() {
        int count = hingeEncoder.get();
        return count*360/countsPerRevolution;
    }

    public double getCurrentRate() {
        return Encoder.getRate() * 360 / countsPerRevolution;
    }
     */

    public double returnPIDInput() {
        return 1;
    }



    protected void usePIDOutput (double output) {this.outPID = output;}

    public void intakePID() {this.setIntakeSpeed(outPID);}
    public void setIntakeSpeed(double speed) { intakeMain.set(ControlMode.PercentOutput,speed);}

    public void flipperPID() {this.setFlipperSpeed(outPID);}
    public void setFlipperSpeed(double speed) { flipper.set(ControlMode.PercentOutput,speed);}

    /*

    public void drop() {
        getPIDController().setPID(0.1, 0, 0);
        setAbsoluteTolerance(5);
        setSetpoint(dropVelocity);
        dropping = true;
    }

    */

}
