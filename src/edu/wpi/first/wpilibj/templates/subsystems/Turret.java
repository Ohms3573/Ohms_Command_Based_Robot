package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.DriveTurret;

public class Turret extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    private Relay turretTurn;
    
    public Turret() {
        turretTurn = new Relay(RobotMap.turretTurnPort);
    }

    public void initDefaultCommand() {
        SmartDashboard.putString("Turret","Initialized");
        setDefaultCommand(new DriveTurret());
    }
    
    public void turretTurnLeft() {
        turretTurn.set(Relay.Value.kForward);
    }
    
    public void turretTurnRight() {
        turretTurn.set(Relay.Value.kReverse);
    }
    
    public void turretStop() {
        turretTurn.set(Relay.Value.kOff);
    }
    
    public void driveTurret(Joystick stick) {
        double x = stick.getX();
        if(x < 0) {
            turretTurnLeft();
            SmartDashboard.putString("Turret","Turning Left");
        }
        else if(x > 0) {
            turretTurnRight();
            SmartDashboard.putString("Turret","Turning Right");
        }
    }
    
    public void alignTurretWithCamrera(int i,double[][] blobs) {
        SmartDashboard.putString("Turret","Aligning with Camera");
        double locationX = blobs[i][0];
        SmartDashboard.putDouble("TargetX",blobs[i][0]);
        SmartDashboard.putDouble("TargetY",blobs[i][1]);
        SmartDashboard.putDouble("Target Degrees Off",blobs[i][2]);
        SmartDashboard.putDouble("Target Area",blobs[i][3]);
        if(locationX > RobotMap.cameraConstant)
            turretTurnRight();
        else if(locationX < -RobotMap.cameraConstant) 
            turretTurnLeft();
        else turretStop();
        //IMPORTANT: Need potentiometer input to get correct rotation and keep code efficient
        //Otherwise while loop to update camera would consume the thread
        
        //where is the turret Y axis control?
        
        //blob area to distance conversion
        
        //distance to turret angle increase conversion
    }
}
