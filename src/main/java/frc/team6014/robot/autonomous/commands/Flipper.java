package frc.team6014.robot.autonomous.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;

import frc.team6014.robot.Robot;

public class Flipper extends TimedCommand {
    double speed;

    public Flipper(double timeout, double speed) {
        super(timeout);
        this.speed = speed;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        Robot.intake.setFlipperSpeed(speed);
    }

    @Override
    protected void end() {
        Robot.intake.setFlipperSpeed(0);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
