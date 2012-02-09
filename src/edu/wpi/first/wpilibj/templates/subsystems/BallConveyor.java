package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.TurnOnConveyor;

public class BallConveyor extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    private Jaguar ballConveyor;
    private Relay conveyorTilt;
    private DigitalInput conveyorEngagedSwitch;
    private DigitalInput conveyorDisengagedSwitch;
    
    public BallConveyor() {
        ballConveyor = new Jaguar(RobotMap.ballConveyorPort);
        conveyorTilt = new Relay(RobotMap.conveyorTiltPort);
        conveyorEngagedSwitch = new DigitalInput(RobotMap.conveyorEngagedSwitchPort);
        conveyorDisengagedSwitch = new DigitalInput(RobotMap.conveyorDisengagedSwitchPort);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TurnOnConveyor());
    }
    
    public void ballConveyor(boolean onOff) {
        if(onOff) {
            ballConveyor.set(RobotMap.ballConveyorSpeed);
        }
        else {
            ballConveyor.set(0.0);
        }
    }
    
    public boolean isConveyorEngaged() {
        return !conveyorEngagedSwitch.get(); // Limit switches are false when closed
    }
    
    public boolean isConveyorDisengaged() {
        return !conveyorDisengagedSwitch.get();
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
        if(isConveyorDisengaged()) {
            conveyorTilt.set(Relay.Value.kOff);
        }
        else {
            conveyorTilt.set(Relay.Value.kReverse);
        }
    }
    
    public boolean getState() {
        return (ballConveyor.get() != 0);
    }
    
}
