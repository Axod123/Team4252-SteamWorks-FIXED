package org.usfirst.frc.team4252.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;

import org.usfirst.frc.team4252.robot.Robot;

public class OpenGrabber extends InstantCommand
{
	
	public OpenGrabber() {
		requires(Robot.gearGrabber);
	}
	
	@Override
	protected void execute() {
		Robot.gearGrabber.pOpen();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
	@Override
	protected void end() {
		Robot.gearGrabber.pClose();
	}
}