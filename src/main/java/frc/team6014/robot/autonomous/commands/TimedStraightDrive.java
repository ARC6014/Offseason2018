package frc.team6014.robot.autonomous.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;

import frc.team6014.robot.Robot;

public class TimedStraightDrive extends TimedCommand {

    private double speed,angle;
    public TimedStraightDrive(double timeout, double speed, double angle) {
        super(timeout);
        requires(Robot.motionController);
        requires(Robot.drive);
        this.speed = speed;
        this.angle = angle;
    }

    @Override
    protected void initialize() {
        Robot.motionController.setAngle(angle);

        Robot.motionController.enable();
    }

    @Override
    protected void execute() {
        Robot.motionController.pidDrive(speed);
    }

    @Override
    protected void end() {
        Robot.motionController.disable();
        Robot.drive.arcadeDrive(0, 0);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
