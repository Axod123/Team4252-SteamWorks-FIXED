package org.usfirst.frc.team4252.robot.controller;
/**
 * @author David Moss
 */
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;

/**
 * 
 * @author David
 *	I wouldn't recommend using this class.
 *	In order to use a ps3 controller, you need to do some janky
 *	stuff with drivers and stuff. It isn't worth it. I only left
 *	this here as an example of a good way to make controllers.
 */
public class PS3 {
	public static Joystick PS = new Joystick(0);
	public static int XButton = 1; //I found that in SampleBot, making the buttons ints was easier to use.
	public static int OButton = 2;
	public static int SqButton = 3;
	public static int TiButton = 4;
	public static int LBumper = 5;
	public static int RBumper = 6;
	public static int Select = 7;
	public static int StartButton = 8;
	public static int RightStickClick = 9;
	public static int LeftStickClick = 10;
	
	public static double y = PS.getRawAxis(1);
	public static double x = PS.getRawAxis(0) * -1;
	
	/**XboxController lel is just for making the triggers work.
	 *To call upon the triggers in an if statement, do this:
	 *"hand" is an enum value. It is either kLeft or kRight. I think you can figure out why that is.
	 *if (lel.getTrigger(hand)) {
	 *<Whatever you want to happen goes here>
	 *}
	 */
	public static XboxController lel = new XboxController (0);
	
	/**
	 * Makes the controller (lel) vibrate.
	 */
	public static void ContVib(XboxController cont)	{
		cont.setRumble(RumbleType.kRightRumble, 1);
		cont.setRumble(RumbleType.kLeftRumble, 1);
	}
}
