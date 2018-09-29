package frc.team6014.robot;

public class AlternativeControl extends ControlSystem {

    public double getDriveX() { return xboxDrive.getX(rightStick); }
    public double getDriveY() { return -xboxDrive.getY(leftStick); }
    public boolean getReverseButton() { return xboxDrive.getYButton(); }

    public double getElevator() { return xbox.getY(rightStick); }
    public boolean getIntake() { return xbox.getBumper(leftStick); }
    public boolean getLaunch() { return xbox.getBumper(rightStick); }
    public boolean getFlipIntake() { return xbox.getXButton(); }
}