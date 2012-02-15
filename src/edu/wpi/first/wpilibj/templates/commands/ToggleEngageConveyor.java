/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Paul
 */
public class ToggleEngageConveyor extends CommandBase {
    
    public ToggleEngageConveyor() {
        // Use requires() here to declare subsystem dependencies
        requires(ballConveyor);
    }

    // Called just before this Command runs the first time
    protected void initialize() { 
        SmartDashboard.putString("ConveyorEngagement", "Toggling");
        ballConveyor.past = false;
        ballConveyor.engageConveyor();
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        ballConveyor.toggleEngageConveyor();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ballConveyor.checkIsFinished();
    }

    // Called once after isFinished returns true
    protected void end() {
        SmartDashboard.putString("ConveyorEngagement", "Stationary");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        
    }
}
