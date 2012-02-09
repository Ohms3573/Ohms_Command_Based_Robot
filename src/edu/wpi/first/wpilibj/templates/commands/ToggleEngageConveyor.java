/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Paul
 */
public class ToggleEngageConveyor extends CommandBase {
    private boolean direction; // True for engage; False for disengage
    
    public ToggleEngageConveyor() {
        // Use requires() here to declare subsystem dependencies
        requires(ballConveyor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if(ballConveyor.isConveyorDisengaged()) direction = true;
        else direction = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (direction)
            ballConveyor.engageConveyor();
        else
            ballConveyor.disengageConveyor();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (direction)
            return ballConveyor.isConveyorEngaged();
        else
            return ballConveyor.isConveyorDisengaged();
    }

    // Called once after isFinished returns true
    protected void end() {
        ballConveyor.ballConveyor(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        ballConveyor.ballConveyor(false);
    }
}
