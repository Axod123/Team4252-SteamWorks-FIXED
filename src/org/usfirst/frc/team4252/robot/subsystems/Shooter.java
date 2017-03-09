package org.usfirst.frc.team4252.robot.subsystems;
/**
 * @author David Moss
 */
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class Shooter extends Subsystem {
	public static Spark sM1 = new Spark (5);
	public static Victor adj = new Victor (4);
	
	public void shooter()	{
		adj.setInverted(true);
	}
	 
	public void initDefaultCommand()	{
	}
	
	/**
	 * Do I seriously need to explain this one?
	 */
	public static void fire() {
		sM1.setSpeed(1.0);
		adjSTART();
	}
	public static void adjSTART()	{
		adj.setSpeed(0.25);
	}
	/**
	 * Stops the shooter motors from shooting. Sets their output to 0;
	 */
	public void stop()	{
		sM1.setSpeed(0.0);
		adj.setSpeed(0.0);
	}
	/**
	 * Prints output (-1.0 to 1.0) to SmartDashboard.
	 */
	public static void updateStatus()	{
		SmartDashboard.putNumber("Shooter Output M1", sM1.getSpeed());
		SmartDashboard.putNumber("Agitator Output", adj.getSpeed());
	}
	

}