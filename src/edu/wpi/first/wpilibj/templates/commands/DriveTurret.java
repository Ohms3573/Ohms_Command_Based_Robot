package edu.wpi.first.wpilibj.templates.commands;

public class DriveTurret extends CommandBase {
    
    public DriveTurret() {
        // Use requires() here to declare subsystem dependencies
        requires(turret);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        turret.driveTurret(oi.getGunnerStick());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
