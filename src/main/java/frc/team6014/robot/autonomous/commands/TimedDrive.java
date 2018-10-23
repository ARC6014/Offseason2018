package frc.team6014.robot.autonomous.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;

import frc.team6014.robot.Robot;

public class TimedDrive extends TimedCommand {
    private double y,x;
    public TimedDrive(double timeout, double y, double x) {
        super(timeout);
        requires(Robot.drive);
        this.y = y;
        this.x = x;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        Robot.drive.arcadeDrive(y,x);
    }

    @Override
    protected void end() {
        Robot.drive.arcadeDrive(0,0);
    }

    @Override
    protected void interrupted() {
        end();
    }

}
