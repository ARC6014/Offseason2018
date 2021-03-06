package frc.team6014.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.team6014.robot.RobotMap;
import frc.team6014.robot.Robot;

public class Intake extends Subsystem
{
    VictorSPX intakeMain = RobotMap.intake;
    //VictorSPX intakeRight = RobotMap.intakeRight;
    //VictorSPX flipperRight = RobotMap.flipperRight;
    VictorSPX flipperLeft = RobotMap.flipperLeft;


    public Intake() {
        //flipperLeft.setInverted(true);
        //flipperRight.follow(flipperLeft);
        //intakeRight.follow(intakeMain);
    }


    @Override
    public void initDefaultCommand() {
    }


    public void setIntakeSpeed(double speed) { intakeMain.set(ControlMode.PercentOutput,speed);}

    public void setFlipperSpeed(double speed) { flipperLeft.set(ControlMode.PercentOutput,speed);}


}
