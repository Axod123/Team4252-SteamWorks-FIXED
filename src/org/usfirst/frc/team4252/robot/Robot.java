package org.usfirst.frc.team4252.robot;

import edu.wpi.first.wpilibj.CameraServer;
/**
 * @author David Moss
 */
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4252.robot.subsystems.Climber;
import org.usfirst.frc.team4252.robot.subsystems.Drive;
import org.usfirst.frc.team4252.robot.controller.LogitechCNT;
import org.usfirst.frc.team4252.robot.subsystems.GearGrabber;
import org.usfirst.frc.team4252.robot.subsystems.Shooter;

public class Robot extends SampleRobot {
	final String MiddleField = "Auto 1";
	final String AnywhereElse = "Auto 2";

	SendableChooser<String> AutoChooser = new SendableChooser<>();

	// initialize subsystems
	public static Drive drive = new Drive();
	public static Shooter shooter = new Shooter();
	public static GearGrabber gearGrabber = new GearGrabber();
	public static Climber climber = new Climber();
	// public static Rangefinder rangeFinder = new Rangefinder();

	// initialize controller(s)
	public static LogitechCNT logitechCNT = new LogitechCNT() ;

	//not sure what this is but it works I guess.
	public Robot() {
		Drive.IDEKStand.setMaxOutput(1.0);
		Drive.IDEKStand.setExpiration(0.5);
	}

	@Override
	public void robotInit() {
		AutoChooser.addObject("Middle Field", MiddleField);
		AutoChooser.addDefault("Anywhere Else", AnywhereElse);

		SmartDashboard.putData("Auto modes", AutoChooser);
		
		CameraServer.getInstance().startAutomaticCapture();

		SmartDashboard.putData(shooter);
		SmartDashboard.putData(gearGrabber);
		SmartDashboard.putData(Scheduler.getInstance());
	}

	/**
	 * You can add additional auto modes by adding additional comparisons to the
	 * if-else structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomous() {
		while (isAutonomous() == true && isEnabled() == true) {
			String autoSelected = AutoChooser.getSelected(); // autoSelected is the autonomous mode that was selected.

			Drive.IDEKStand.setSafetyEnabled(false);
			//GearGrabber.Start();
			
			switch (autoSelected) {
			case AnywhereElse:
			default:
				Drive.IDEKStand.drive(-0.25, 0); // Moves forward until it crosses the line.
				Timer.delay(2.5);
				Drive.IDEKStand.drive(0, 0); // stop robot
				Timer.delay(15.0);
				break;
			case MiddleField:
				Drive.IDEKStand.drive(-0, 0); // Bot does not do anything at this time
				break;
			}	
		}
	}

	@Override
	public void operatorControl() {
		while (isOperatorControl() && isEnabled()) {
			
			Drive.IDEKStand.setSafetyEnabled(true);

			//GearGrabber.Start();

			// SmartDashboard.putDouble("Dist Away (cm): ",
			// Rangefinder.rangeCM);
			// updateStatus();

			Drive.IDEKStand.arcadeDrive(LogitechCNT.y1, LogitechCNT.x1);

			if (LogitechCNT.Logitech.getRawButton(LogitechCNT.AButton))	{
				GearGrabber.pClose();
			}
			if (LogitechCNT.Logitech.getRawButton(LogitechCNT.BButton)) {
				GearGrabber.pOpen();
			}
			
			
			if (LogitechCNT.Logitech.getRawButton(LogitechCNT.RTrigger)) {
				Shooter.fire(); 
			}
			if (LogitechCNT.Logitech.getRawButton(LogitechCNT.StartButton))	{
				LogitechCNT.flipAxis(true);
				Climber.start();
			}
			if (LogitechCNT.Logitech.getRawButton(LogitechCNT.BackButton))	{
				LogitechCNT.flipAxis(false);
				Climber.emergencyStop();
			} 
		}
	}

	/**
	 * This is test mode. It lets you test to make sure things are working.
	 * Something you could do is, if there are no errors, the bot moves or does
	 * something. What I used it for was making sure that everything was
	 * declared. I did this by enabling test mode on the DriveStation, and
	 * looking at the lights on the SCs. If they were blinking, they were not
	 * declared. If some blinked, then those were not declared. If they all stay
	 * on, without blinking, then they are all declared. If they are off, then
	 * you forgot to turn on the robot. If you forgot to turn on the robot, then
	 * your punishment is that you are now the new Programming Chief for Team
	 * 4252. May God have mercy on your soul.
	 */
	@Override
	public void test() {
	}
	/*
	public static void updateStatus() {
		Shooter.updateStatus();
		Drive.updateStatus();
		GearGrabber.updateStatus();
		// Rangefinder.updateStatus();
	}
	*/
}
