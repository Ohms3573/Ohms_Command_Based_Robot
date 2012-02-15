/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Kenny
 */
public class ToggleConveyor extends CommandBase {
    
    public ToggleConveyor() {
        // Use requires() here to declare subsystem dependencies
        requires(ballConveyor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if(ballConveyor.getState()) {
            ballConveyor.turnOnBallConveyor();
        }
        else {
            ballConveyor.turnOnBallConveyor();
        }
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
        //THIS MUST BE CHECkED
        ballConveyor.reverseEngagerDirection();
        initialize();
        //THIS MUST BE CHECKED
        
    }
}
