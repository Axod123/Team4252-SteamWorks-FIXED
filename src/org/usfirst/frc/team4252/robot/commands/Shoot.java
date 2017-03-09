package org.usfirst.frc.team4252.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4252.robot.Robot;

public class Shoot extends Command
{
	
	public Shoot() {
		requires(Robot.shooter);
	}
	
	@Override
	protected void execute() {
		Robot.shooter.fire();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	protected void end() {
		Robot.shooter.stop();
	}
	
	
}