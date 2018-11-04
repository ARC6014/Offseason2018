package frc.team6014.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class BasicControl extends ControlSystem {

    XboxController xbox = new XboxController(0);
    GenericHID.Hand rightStick = GenericHID.Hand.kRight;
    GenericHID.Hand leftStick = GenericHID.Hand.kLeft;

    public double getDriveX() { return xbox.getX(leftStick); }
    public double getDriveY() { return -xbox.getY(leftStick); }
    public boolean getReverseButton() { return xbox.getYButton(); }

    public double getElevator() { return -xbox.getY(rightStick); }
    public boolean getHoldElevator() { return xbox.getXButton(); }
    public boolean getIntake() { return xbox.getBumper(leftStick); }
    public boolean getLaunch() { return xbox.getBumper(rightStick); }
    public double getFlipPositive() { return xbox.getTriggerAxis(leftStick); }
    public double getFlipNegative() { return xbox.getTriggerAxis(rightStick); }
}