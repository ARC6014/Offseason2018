/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team6014.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap 
{
    public static VictorSPX frontLeft = new VictorSPX(4);
    public static VictorSPX rearLeft = new VictorSPX(2);
    public static VictorSPX frontRight = new VictorSPX(5);
    public static VictorSPX rearRight = new VictorSPX(13);


    public static VictorSPX elevatorLeft = new VictorSPX(9);
    public static VictorSPX elevatorRight = new VictorSPX(8);

    public static VictorSPX intakeLeft = new VictorSPX(11);
    public static VictorSPX intakeRight = new VictorSPX(6);
    public static VictorSPX flipper = new VictorSPX(7);


}
