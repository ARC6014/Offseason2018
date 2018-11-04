package frc.team6014.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;

public class AlternativeControl extends ControlSystem {

    XboxController xbox = new XboxController(0);
    XboxController xboxDrive = new XboxController(1);
    GenericHID.Hand rightStick = GenericHID.Hand.kRight;
    GenericHID.Hand leftStick = GenericHID.Hand.kLeft;

    public double getDriveX() { return xboxDrive.getX(rightStick); }
    public double getDriveY() { return -xboxDrive.getY(leftStick); }
    public boolean getReverseButton() { return xboxDrive.getYButton(); }

    public double getElevator() { return -xbox.getY(rightStick); }
    public boolean getHoldElevator() { return xbox.getXButton(); }
    public boolean getIntake() { return xbox.getBumper(leftStick); }
    public boolean getLaunch() { return xbox.getBumper(rightStick); }
    public double getFlipPositive() { return xboxDrive.getTriggerAxis(leftStick); }
    public double getFlipNegative() { return xboxDrive.getTriggerAxis(rightStick); }
}