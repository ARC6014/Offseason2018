/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team6014.robot.subsystems;

import com.armabot.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * LIDAR: Detects the locations of the closest objects in each direction around the robot with lasers.
 * Parses the information into a grid that is then returned.
 */
public class Lidar extends Subsystem
{
    // Subsystem needed override
    @Override
    public void initDefaultCommand(){}

    // Default constructor
    public Lidar() {
        sweeper = SweepJNI.constructSimple();
    }

    // Constructor for custom portName/bitrate
    public Lidar(String portName, int bitrate) {
        sweeper = SweepJNI.construct(portName, bitrate);
    }

    // Starts scanning
    public void start() { SweepJNI.startScanning(sweeper); }

    // Stops scanning
    public void stop() {
        SweepJNI.stopScanning(sweeper);
    }

    // Resets the scanner
    public void reset() {
        SweepJNI.reset(sweeper);
    }

    // Gets the speed of the motor of the laser scanner, in Hz
    public int getMotorSpeed() {
        return SweepJNI.getMotorSpeed(sweeper);
    }

    // Sets the speed of the motor of the laser scanner, in Hz
    public void setMotorSpeed(int speed) {
        SweepJNI.setMotorSpeed(sweeper, speed);
    }

    // Gets and parses the scan results and forms them into a 2D grid
    public void sample() {
        // Gets scan results and creates an array to which the values will be copied over
        // by turning the polar coordinates Cartesian
        SweepSample[] samples = SweepJNI.getScan(sweeper);
        ScanPoint[] samplePoints =  new ScanPoint[samples.length];

        // Sets extrema to worst-case robot location
        int maxX = 0;
        int maxY = 0;
        int minX = 0;
        int minY = 0;

        // For each sample, does the following:
        for (int i = 0; i < samples.length; i++) {
            // SEE IF RADIAN&DEGREE ERROR
            // Calculates and sets the x- and y-values of each of the sampled points onto the new array,
            // alongside the strengths of those points
            samplePoints[i].x = (int) Math.round((double) Math.cos(samples[i].angle) * (double) samples[i].distance);
            samplePoints[i].y = (int) Math.round((double) Math.sin(samples[i].angle) * (double) samples[i].distance);
            samplePoints[i].strength = samples[i].signalStrength;

            // Alters extrema's values if needed
            if (samplePoints[i].x > maxX) {
                maxX = samplePoints[i].x;
            }
            else if (samplePoints[i].x < minX) {
                minX = samplePoints[i].x;
            }
            if (samplePoints[i].y > maxY) {
                maxY = samplePoints[i].y;
            }
            else if (samplePoints[i].y < minY) {
                minY = samplePoints[i].y;
            }
        }

        // Prepares a grid of appropriate size to store the coordinate-strength combinations
        scanMap = new int[maxX - minX + 1][maxY - minY + 1];
        // Sets the robot's position to be -1
        scanMap[-1 * minX][-1 * minY] = -1;

        // For each point sampled, puts it onto the grid with its strength value
        for (ScanPoint point : samplePoints) {
            scanMap[-1 * minX + point.x][-1 * minY + point.y] = point.strength; // IS STRENGTH AN INT?
        }
    }

    // Returns the board state grid
    public int[][] getVision()  {
        return scanMap;
    }


    private int[][] scanMap; // -1 str is robot
    private long sweeper;

    // Cartesian scanned point class; used in place of a C struct
    private class ScanPoint {
        public int x, y, strength;
        public ScanPoint () {}
        public ScanPoint (int x, int y, int strength) {
            this.x = x;
            this.y = y;
            this.strength = strength;
        }
    }
}