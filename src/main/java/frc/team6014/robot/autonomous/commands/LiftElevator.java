/*
package frc.team6014.robot.autonomous.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;

import frc.team6014.robot.Robot;

public class LiftElevator extends TimedCommand {

    private double speed;

    public LiftElevator(double timeout, double speed) {
        super(timeout);
        this.speed = speed;
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        Robot.elevator.setElevatorSpeed(speed);
    }

    @Override
    protected void end() {
        Robot.elevator.setElevatorSpeed(0);
    }

    @Override
    protected void interrupted() { end();}
}
*/
