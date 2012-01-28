package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;

    //////////////////////////
    //  ___         _       //
    // | _ \___ _ _| |_ ___ //
    // |  _/ _ \ '_|  _(_-< //
    // |_| \___/_|  \__/__/ //
    //                      //
    //////////////////////////   
    // Joysticks
    public static final int driverStick = 1;
    public static final int gunnerStick = 2;
    
    // Jaguars
    public static final int fLeftMotorPort = 1;
    public static final int rLeftMotorPort = 2;
    public static final int fRightMotorPort = 3;
    public static final int rRightMotorPort = 4;
    public static final int ballConveyorPort = 5;
    
    // Victors
    public static final int gunLeftPort = 7;
    public static final int gunRightPort = 7;
    
    // Relays
    public static final int turretTurnPort = 1;
    public static final int turretElevationPort = 2;
    public static final int conveyorTiltPort = 3;
    public static final int BridgingArmPort = 4;
}
