package frc.team6014.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;

abstract public class ControlSystem {
    XboxController xbox = new XboxController(0);
    XboxController xboxDrive = new XboxController(1);
    GenericHID.Hand rightStick = GenericHID.Hand.kRight;
    GenericHID.Hand leftStick = GenericHID.Hand.kLeft;

    abstract public double getDriveX();
    abstract public double getDriveY();


    boolean prevReverseButton = false;
    double reverseFactor = 1.0;
    abstract public boolean getReverseButton();

    public double getReverseFactor() {
        boolean curReverseButton = getReverseButton();
        if(curReverseButton && !prevReverseButton) {
            reverseFactor*=-1.0;
        }
        prevReverseButton = curReverseButton;
        return reverseFactor;
    }

    abstract public double getElevator();
    abstract public boolean getIntake();
    abstract public boolean getLaunch();
    abstract public boolean getFlipIntake();
}