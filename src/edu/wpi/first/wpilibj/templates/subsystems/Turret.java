package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

public class Turret extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    private Relay turretTurn;
    
    public Turret() {
        turretTurn = new Relay(RobotMap.turretTurnPort);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void turretTurnLeft() {
        turretTurn.set(Relay.Value.kForward);
    }
    
    public void turretTurnRight() {
        turretTurn.set(Relay.Value.kReverse);
    }
    
    public void driveTurret(Joystick stick) {
        double x = stick.getX();
        if(x < 0) {
            turretTurnLeft();
        }
        else if(x > 0) {
            turretTurnRight();
        }
    }
}
