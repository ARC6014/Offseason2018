package frc.team6014.robot;

abstract public class ControlSystem {

    abstract public double getDriveX();
    abstract public double getDriveY();


    boolean prevReverseButton = false;
    double reverseFactor = 1.0;
    abstract public boolean getReverseButton();

    public double getReverseFactor() {
        boolean curReverseButton = getReverseButton();
        if (curReverseButton && !prevReverseButton) {
            reverseFactor *= -1.0;
        }
        prevReverseButton = curReverseButton;
        return reverseFactor;
    }
    abstract public double getFlipNegative();
    abstract public double getFlipPositive();

    public double getFlipFactor() {
        if(Math.abs(getFlipPositive()-getFlipNegative())<0.05) {
            return 0;
        } else {
            return getFlipPositive()-getFlipNegative();
        }
    }

    abstract public double getElevator();
    abstract public boolean getIntake();
    abstract public boolean getLaunch();
}