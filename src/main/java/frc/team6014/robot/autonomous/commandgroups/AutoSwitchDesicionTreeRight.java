package frc.team6014.robot.autonomous.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.team6014.robot.Robot;
import frc.team6014.robot.autonomous.commands.Delay;
import frc.team6014.robot.autonomous.commands.Intake;
import frc.team6014.robot.autonomous.commands.TimedStraightDrive;
import frc.team6014.robot.autonomous.commands.TurnToAngle;
import frc.team6014.robot.autonomous.commands.Flipper;
//import frc.team6014.robot.autonomous.commands.LiftElevator;
import frc.team6014.robot.autonomous.commands.TimedDrive;

public class AutoSwitchDesicionTreeRight extends CommandGroup {
    public void AutoSwitchDesicionTreeLeft() {
        String gameSwitchData = Robot.gameData.substring(0, 1);
        if (gameSwitchData.length() > 0) {
            if (gameSwitchData.equals("R")) {

            } else if (gameSwitchData.equals("L")) {

            } else {
                System.out.println("NO GAME DATA");
            }
        }
    }
}
