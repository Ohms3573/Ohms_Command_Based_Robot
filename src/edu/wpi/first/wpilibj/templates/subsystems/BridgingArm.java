package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;

public class BridgingArm extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    private Relay bridgingArm;
    private boolean state;
    
    public BridgingArm() {
        bridgingArm = new Relay(RobotMap.bridgingArmPort);
        state = false;
    }

    public void initDefaultCommand() {} // Do nothing
    
    public void lowerArm() {
        SmartDashboard.putString("BridgingArm","Lowered");
        bridgingArm.set(Relay.Value.kForward);
        state = true;
    }
    
    public void raiseArm() {
        SmartDashboard.putString("BridgingArm","Raised");
        bridgingArm.set(Relay.Value.kReverse);
        state = false;
    }
    
    public void stopArm() {
        SmartDashboard.putString("BridgingArm","Off");
        bridgingArm.set(Relay.Value.kOff);
    }
    
    /**
     * Gets the state of the bridging arm
     * @return True if the arm is lowered; false otherwise.
     */
    public boolean getState() {
        return state;
    }
}
