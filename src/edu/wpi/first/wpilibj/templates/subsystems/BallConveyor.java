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
    private DigitalInput conveyorSwitch;
    private Relay.Value direction;
    public boolean past;
    
    public BallConveyor() {
        ballConveyor = new Jaguar(RobotMap.ballConveyorPort);
        conveyorTilt = new Relay(RobotMap.conveyorTiltPort);
        conveyorSwitch = new DigitalInput(RobotMap.conveyorSwitchPort);
        direction = Relay.Value.kForward;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TurnOnConveyor());
    }
        
    public void toggleEngageConveyor(){
        if(!conveyorSwitch.get() && !past){
            conveyorTilt.set(direction);
        }
        else if(conveyorSwitch.get() && !past){
            past = !past;
        }
        else if(!conveyorSwitch.get() && past){
            //do nothing
        }
        else if(conveyorSwitch.get() && past){
            conveyorTilt.set(Relay.Value.kOff);
        }
    }
    public void engageConveyor(){
        conveyorTilt.set(direction);
    }
    
    public boolean checkIsFinished(){
        return conveyorSwitch.get() && past;
    }
    
    public void turnOnBallConveyor(){
        ballConveyor.set(RobotMap.ballConveyorSpeed);
    }
    public void turnOffBallConveyor(){
        ballConveyor.set(0);
    }

    public boolean getState() {
        return ballConveyor.get() == 0;
    }

    public void reverseEngagerDirection() {
        if(direction == Relay.Value.kForward){
            direction = Relay.Value.kReverse;
        }
        else direction = Relay.Value.kForward;
    }
    
}