package frc.team6014.robot.autonomous.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.team6014.robot.Robot;
import frc.team6014.robot.autonomous.commands.TimedStraightDrive;
import frc.team6014.robot.autonomous.commands.TurnToAngle;

public class AutoDesicionTreeTest extends CommandGroup {
    public AutoDesicionTreeTest() {
        String gameSwitchData = Robot.gameData.substring(0,2);
        if (gameSwitchData.length() > 0) {
            if (gameSwitchData.equals("RR")) {
                addSequential(new TimedStraightDrive(2,0.8,0));
                addSequential(new TurnToAngle(90,0.6,1.2));
            }

            else if (gameSwitchData.equals("RL")) {
                addSequential(new TimedStraightDrive(2,0.8,0));
                addSequential(new TurnToAngle(-90,0.6,1.2));
            }

            else if (gameSwitchData.equals("LL")) {
                addSequential(new TimedStraightDrive(2,0.8,0));
                addSequential(new TurnToAngle(90,0.6,1.2));
            }

            else if (gameSwitchData.equals("LR")) {
                addSequential(new TimedStraightDrive(2,0.8,0));
                addSequential(new TurnToAngle(90,0.6,1.2));
            }


            else {
                System.out.println("NO GAME DATA");
                addSequential(new TimedStraightDrive(2,0.8,0));
            }
        }

    }
}
