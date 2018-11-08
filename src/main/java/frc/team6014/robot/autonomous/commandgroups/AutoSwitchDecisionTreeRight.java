package frc.team6014.robot.autonomous.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team6014.robot.Robot;
import frc.team6014.robot.autonomous.commands.TimedStraightDrive;
import frc.team6014.robot.autonomous.commands.TurnToAngle;

public class AutoSwitchDecisionTreeRight extends CommandGroup {
    public AutoSwitchDecisionTreeRight() {
        String gameSwitchData = Robot.getGameData();
        try {
            gameSwitchData = gameSwitchData.substring(0,1);
        } catch(StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        if (gameSwitchData.length() > 0) {
            if (gameSwitchData.equals("L")) {
                addSequential(new TimedStraightDrive(2.0,0.8,0));
                addSequential(new TurnToAngle(1.2,0.6,-90));
                addSequential(new TimedStraightDrive(1.0,0.8, -90));
               // addSequential(new TurnToAngle(1.2,0.6,-180));
            } else if (gameSwitchData.equals("R")) {
                addSequential(new TimedStraightDrive(1.6,0.8,0));
                addSequential(new TurnToAngle(1.2,0.6,-90));
                //addSequential(new TimedStraightDrive(0.4,0.8,-90));
            } else {
                addSequential(new TimedStraightDrive(1.8,0.8,0));
                System.out.println("NO GAME DATA");
            }
        }
    }
}
