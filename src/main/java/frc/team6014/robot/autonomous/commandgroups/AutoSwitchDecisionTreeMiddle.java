package frc.team6014.robot.autonomous.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team6014.robot.Robot;

public class AutoSwitchDecisionTreeMiddle extends CommandGroup {
    public AutoSwitchDecisionTreeMiddle() {
        String gameSwitchData = Robot.getGameData();
        try {
            gameSwitchData = gameSwitchData.substring(0,1);
        } catch(StringIndexOutOfBoundsException e) {}
        if (gameSwitchData.length() > 0) {
            if (gameSwitchData.equals("R")) {

            } else if (gameSwitchData.equals("L")) {

            } else {
                System.out.println("NO GAME DATA");
            }
        }
    }
}

