package org.usfirst.frc.team4252.robot.controller;
/**
 * @author David Moss
 */
import edu.wpi.first.wpilibj.Joystick;

public class LogitechCNT {
	public static Joystick Logitech = new Joystick(0);
	public static int XButton = 1; //I found that in SampleBot, making the buttons ints was easier to use.
	public static int AButton = 2;
	public static int BButton = 3;
	public static int YButton = 4;
	public static int LBumper = 5;
	public static int RBumper = 6;
	public static int LTrigger = 7;
	public static int RTrigger = 8;
	public static int BackButton = 9;
	public static int StartButton = 10;
	public static int LStickClick = 11;
	public static int RStickClick = 12;
	
	public static double y1 = Logitech.getRawAxis(1), x1 = Logitech.getRawAxis(0) * -1;
	
	/**
	 * You might notice on this controller that the right stick is
	 * kind of wonky. Because of this, I don't recommend using it.
	 * However, here are the values for that stick if you ever get a
	 * new controller, and have a reason to use it. TankDrive maybe?
	 */
	public static double y2 = Logitech.getRawAxis(3), x2 = Logitech.getRawAxis(2) * -1;
	
	public static void flipAxis (boolean borp)	{
		if (borp = true)	{
			y1 *= 1;
		}
		else if (borp = false)	{
			y1 = Logitech.getRawAxis(1);
		}
	}
}
