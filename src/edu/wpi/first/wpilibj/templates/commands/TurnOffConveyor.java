package edu.wpi.first.wpilibj.templates.commands;

public class TurnOffConveyor extends CommandBase {
    
    public TurnOffConveyor() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        super("Ball Conveyor is off");
        requires(ballConveyor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        ballConveyor.turnOffBallConveyor();
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
