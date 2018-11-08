package frc.team6014.robot.autonomous.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team6014.robot.Robot;
import frc.team6014.robot.autonomous.commands.TimedDrive;
import frc.team6014.robot.autonomous.commands.TimedStraightDrive;
import frc.team6014.robot.autonomous.commands.TurnToAngle;

public class AutoDecisionTreeTest extends CommandGroup {
    public AutoDecisionTreeTest() {
        addSequential(new TimedDrive(1.6,0.8,0));
        /*String gameSwitchData = Robot.getGameData();
        try {
            gameSwitchData = gameSwitchData.substring(0,1);
        } catch(StringIndexOutOfBoundsException e) {}
        if (gameSwitchData.length() > 0) {
            if (gameSwitchData.equals("R")) {
                addSequential(new TimedDrive(1.6,0.8,0));
            }

            else if (gameSwitchData.equals("L")) {
                addSequential(new TimedDrive(1.6,0.8,0));
            }

            else {
                System.out.println("NO GAME DATA");
                addSequential(new TimedDrive(1.6,0.8,0));
            }
        }*/
    }
}
