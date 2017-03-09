package org.usfirst.frc.team4252.robot.subsystems;
/**
 * @author David Moss
 */
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive extends Subsystem	{
	public static Victor frontLeftMotor = new Victor (0);	//Here I am declaring our speed controllers
	public static Victor rearLeftMotor = new Victor (1);	//on this bot we used Victor SCs so you have to
	public static Victor frontRightMotor = new Victor (2);	//declare them as such. The int is the PWM Port.
	public static Victor rearRightMotor = new Victor (3);	//See RobotBuilder for the complete list of SCs
	public static RobotDrive IDEKStand = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
	
	public void initDefaultCommand()	{
		Drive.IDEKStand.setSafetyEnabled(true);
	}
	
	/**
	 * Prints output (-1.0 to 1.0) to SmartDashboard.
	 */
	private static void Status()	{
		
		SmartDashboard.putNumber("Output FL Mot: ", frontLeftMotor.getSpeed());
		SmartDashboard.putNumber("Output FR Mot: ", frontRightMotor.getSpeed());
		SmartDashboard.putNumber("Output RL Mot: ", rearLeftMotor.getSpeed());
		SmartDashboard.putNumber("Output RR Mot: ", rearRightMotor.getSpeed());
	}
	
	public static void updateStatus()	{
		Drive.Status();
	}
}