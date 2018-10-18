package frc.team6014.robot.autonomous.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;

import frc.team6014.robot.Robot;

public class Intake extends TimedCommand {

    private double speed;

    public Intake(double timeout, double speed){
        super(timeout);
        this.speed = speed;
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        Robot.intake.setIntakeSpeed(speed);
    }

    @Override
    protected void end() {
        Robot.intake.setIntakeSpeed(0);
    }

    @Override
    protected void interrupted() {
        end();
    }

}
