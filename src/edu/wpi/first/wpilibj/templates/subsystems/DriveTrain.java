package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.DriveWithJoystick;

public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    
    
    RobotDrive driveTrain;
    
    public DriveTrain() {
        driveTrain = new RobotDrive(RobotMap.fLeftMotorPort, RobotMap.rLeftMotorPort, 
                RobotMap.fRightMotorPort, RobotMap.rRightMotorPort);
        driveTrain.setSafetyEnabled(false);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveWithJoystick());
    }
    
    public void driveWithJoystick(Joystick driveStick) {
        driveTrain.arcadeDrive(driveStick);
    }
}
