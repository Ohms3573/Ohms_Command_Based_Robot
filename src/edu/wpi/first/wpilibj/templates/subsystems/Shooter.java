package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

public class Shooter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    private Jaguar ballConveyor;
    private Victor gunLeft;
    private Victor gunRight;
    private Relay turretTurn;
    private Relay conveyorTilt;
    private DigitalInput conveyorEngagedSwitch;
    
    public Shooter() {
        ballConveyor = new Jaguar(RobotMap.ballConveyorPort);
        gunLeft = new Victor(RobotMap.gunLeftPort);
        gunRight = new Victor(RobotMap.gunRightPort);
        turretTurn = new Relay(RobotMap.turretTurnPort);
        conveyorTilt = new Relay(RobotMap.conveyorTiltPort);
        conveyorEngagedSwitch = new DigitalInput(RobotMap.conveyorTiltSwitchPort);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void ballConveyor(boolean onOff) {
        if(onOff) {
            ballConveyor.set(RobotMap.ballConveyorSpeed);
        }
        else {
            ballConveyor.set(0.0);
        }
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
    
    public boolean isConveyorEngaged() {
        return !conveyorEngagedSwitch.get(); // Limit switches are false when closed
    }
    
    public void engageConveyor() {
        if(isConveyorEngaged()) {
            conveyorTilt.set(Relay.Value.kOff);
        }
        else {
            conveyorTilt.set(Relay.Value.kForward);
        }
    }
    
    public void disengageConveyor() {
        conveyorTilt.set(Relay.Value.kReverse);
    }
    
    public void turretTurnLeft() {
        turretTurn.set(Relay.Value.kForward);
    }
    
    public void turretTurnRight() {
        turretTurn.set(Relay.Value.kReverse);
    }
    
    
}
