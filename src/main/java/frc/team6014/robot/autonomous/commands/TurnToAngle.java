package frc.team6014.robot.autonomous.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;

import frc.team6014.robot.Robot;


public class TurnToAngle extends TimedCommand {
    private double speed;
    private double angle;


    public TurnToAngle(double timeout, double angle, double rotationSpeed) {
        super(timeout);
        requires(Robot.motionController);
        requires(Robot.drive);
        this.speed = rotationSpeed;
        this.angle = angle;
    }

    @Override
    protected void initialize() {
        Robot.drive.setMaxOutput(Robot.drive.maxSpeed*speed);
        Robot.motionController.setAngle(angle);
        Robot.motionController.enable();
    }

    @Override
    protected void execute() { Robot.motionController.pidDrive(0); }

    @Override
    protected void end() {
        Robot.motionController.disable();
        Robot.drive.setMaxOutput(Robot.drive.defSpeed);
        Robot.drive.arcadeDrive(0, 0);
    }

    @Override
    protected void interrupted() {
        Robot.motionController.disable();
        Robot.drive.setMaxOutput(Robot.drive.defSpeed);
        Robot.drive.arcadeDrive(0, 0);
    }
}
