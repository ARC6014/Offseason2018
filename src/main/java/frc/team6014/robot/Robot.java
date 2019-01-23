/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.team6014.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.team6014.robot.autonomous.commandgroups.*;
//import frc.team6014.robot.subsystems.Lidar;
import frc.team6014.robot.subsystems.Drive;
import frc.team6014.robot.subsystems.Intake;
import frc.team6014.robot.subsystems.MotionController;
import frc.team6014.robot.subsystems.Elevator;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
// If you rename or move this class, update the build.properties file in the project root
public class Robot extends TimedRobot 
{

    //public static Lidar lidar;
    public static Drive drive;
    public static Elevator elevator;
    public static ControlSystem oi;
    public static Intake intake;
    public static MotionController motionController;
    private Command autonomousCommand;
    private SendableChooser<Command> chooser = new SendableChooser<>();

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit()
    {
        oi = new BasicControl();
        drive = new Drive();
        intake = new Intake();
        elevator = new Elevator();
        motionController = new MotionController();
        //chooser.addDefault("Default Auto", new ExampleCommand());
        //chooser.addObject("My Auto", new MyAutoCommand());

        chooser.addDefault("Run Everywhere", new AutoDecisionTreeTest());
        chooser.addObject("Delayed", new DelayedAuto());
        chooser.addObject("Switch Left", new AutoSwitchDecisionTreeLeft());
        chooser.addObject("Switch Middle", new AutoSwitchDecisionTreeMiddle());
        chooser.addObject("Switch Right", new AutoSwitchDecisionTreeRight());
        SmartDashboard.putData("Auto Mode", chooser);

        //CameraServer.getInstance().startAutomaticCapture();
    }

    @Override
    public void robotPeriodic() {
        SmartDashboard.putNumber("Heading", motionController.getHeading());
        SmartDashboard.putNumber("Accel X", motionController.getAccelX());
        SmartDashboard.putNumber("Accel Y", motionController.getAccelY());
        SmartDashboard.putNumber("Accel Z", motionController.getAccelZ());
        SmartDashboard.putNumber("Drive X",oi.getDriveX());
        SmartDashboard.putNumber("Drive Y",oi.getDriveY());
        SmartDashboard.putNumber("Elevator Y",oi.getElevator());
        SmartDashboard.putNumber("Flip Factor",oi.getFlipFactor());
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    @Override
    public void disabledInit() 
    {
        
    }

    @Override
    public void disabledPeriodic() 
    {
        Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString code to get the auto name from the text box below the Gyro
     *
     * <p>You can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons
     * to the switch structure below with additional strings & commands.
     */
    @Override
    public void autonomousInit() 
    {
        autonomousCommand = chooser.getSelected();

        /*
         * String autoSelected = SmartDashboard.getString("Auto Selector",
         * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
         * = new MyAutoCommand(); break; case "Default Auto": default:
         * autonomousCommand = new ExampleCommand(); break; }
         */

        // schedule the autonomous command (example)
        if (autonomousCommand != null)
        {
            autonomousCommand.start();
        }
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() 
    {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() 
    {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) 
        {
            autonomousCommand.cancel();
        }
        Teleop.init();
    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() 
    {
        Scheduler.getInstance().run();
        Teleop.periodic();
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() 
    {
        
    }

    public static String getGameData() {
        return DriverStation.getInstance().getGameSpecificMessage();
    }
}
