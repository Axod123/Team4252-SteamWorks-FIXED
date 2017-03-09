package org.usfirst.frc.team4252.robot.RIP;

/**
 * @author David Moss
 */
import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.hal.HAL;
import edu.wpi.first.wpilibj.hal.FRCNetComm.tResourceType;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class VictorFIX extends PWMSpeedController
{
	/**
	 * This is a class for a speed controller to allow for minute adjustments to our
	 * imperfect Victor 888s. This is just for making adjustments to the bandwidth
	 * stuff in output. I don't really understand how it all works, so hopefully you do.
	 * 
	 * check the Victor.class to find out what the numbers in setBounds() do.
	 * 
	 * @param channel
	 */
	public VictorFIX(final int channel) {
		super(channel);
		
		setBounds(2.0, 1.525, 1.507, 1.49, 1.5);
	    setPeriodMultiplier(PeriodMultiplier.k2X);
	    setSpeed(0.0);
	    setZeroLatch();
		
		LiveWindow.addActuator("VictorFIX", getChannel(), this);
	    HAL.report(tResourceType.kResourceType_Victor, getChannel());
	}
	
}