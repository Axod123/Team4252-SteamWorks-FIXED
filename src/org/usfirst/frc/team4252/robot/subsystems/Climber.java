package org.usfirst.frc.team4252.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem
{
	public static Spark CMot = new Spark(6);
	
	public Climber()	{
		CMot.setSafetyEnabled(false);
	}
	
	@Override
	protected void initDefaultCommand() {
	}
	
	public static void start()	{
		CMot.setSpeed(1.0);
	}
	public static void emergencyStop()	{
		CMot.setSpeed(0.0);
	}
	
}