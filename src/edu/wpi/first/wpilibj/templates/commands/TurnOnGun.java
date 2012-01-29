package edu.wpi.first.wpilibj.templates.commands;

public class TurnOnGun extends CommandBase {
    private final static boolean ON = true;
    private final static boolean OFF = false;
    
    public TurnOnGun() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        super("Gun is on");
        requires(gunFlywheels);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        gunFlywheels.gun(ON);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
