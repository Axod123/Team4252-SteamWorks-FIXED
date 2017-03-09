package org.usfirst.frc.team4252.robot.subsystems;
/**
 * @author David Moss
 */

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.AnalogInput;

/**
 * This is your basic Ultrasonic Rangefinder code. All this does (for now) is declare an ultrasonic,
 * set a double to calculate the reading the reading off the ultrasonic in centimeters, and makes a
 * method for putting this reading on the SmartDashboard. Swag.
 */
public class Rangefinder extends Subsystem	{
	// Analog Module 0
    private final static AnalogInput rangeFinder = new AnalogInput(0);
    
    /**
     * There is no default state for this subsystem
     */
    public void initDefaultCommand() {
        
    }
    
    /**
     * @return voltage of rangeFinder
     */
    private static double getVoltage() {
        return rangeFinder.getVoltage();
    }
    
    /**
     * 9.766mV = 1 inch
     * http://www.maxbotix.com/articles/016.htm
     * @return Distance in inches
     */
    private static double getDistanceInInches() {
        return getMillivolts() / 9.766;
    }
    
    /**
     * 1 V = 1000mV
     * @return Measured voltage in millivolts
     */
    private static double getMillivolts() {
        return getVoltage() * 1000;
    }
    private static double getDistanceInMM()	{
    	return getDistanceInInches() * 0.0254;
    }
    
    @SuppressWarnings("deprecation")
	public static void updateStatus()	{
    	SmartDashboard.putDouble("Inches from Obj", getDistanceInMM());
    }
    



	
}