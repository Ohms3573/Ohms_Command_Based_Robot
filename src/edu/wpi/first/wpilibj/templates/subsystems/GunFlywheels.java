package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.TurnOnGun;

public class GunFlywheels extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    private Victor gunLeft;
    private Victor gunRight;
    
    public GunFlywheels() {
        gunLeft = new Victor(RobotMap.gunLeftPort);
        gunRight = new Victor(RobotMap.gunRightPort);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TurnOnGun());
    }
    
    public void gun(boolean onOff) {
        if(onOff) {
            gunLeft.set(RobotMap.gunFlywheelSpeed);
            gunRight.set(-1 * RobotMap.gunFlywheelSpeed);
        }
        else {
            gunLeft.set(0.0);
            gunRight.set(0.0);
        }
    }    
}
