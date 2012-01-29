/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Kenny
 */
public class ToggleBridgingArm extends CommandBase {
    private static boolean state; //True if deployed; otherwise false.
    
    public ToggleBridgingArm() {
        // Use requires() here to declare subsystem dependencies
        super("Toggling Bridging Arm");
        requires(bridgingArm);
        setTimeout(RobotMap.bridgingArmTime);
        state = bridgingArm.getState();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        state = !state; // We want to go in the opposite direction of where we are
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(state) { // If true, we want to lower the arm
            bridgingArm.lowerArm();
        }
        else {
            bridgingArm.raiseArm();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        bridgingArm.stopArm();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        bridgingArm.stopArm();
    }
}
