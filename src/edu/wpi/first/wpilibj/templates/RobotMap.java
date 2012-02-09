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
    // public static final int turretElevationPort = 2;
    public static final int conveyorTiltPort = 3;
    public static final int bridgingArmPort = 4;
    
    // Sensors
    public static final int conveyorEngagedSwitchPort = 6;
    public static final int conveyorDisengagedSwitchPort = 7;
    
    // Speeds
    public static final double gunFlywheelSpeed = 1.0;
    public static final double ballConveyorSpeed = 1.0;
    
    // Times
    public static final double conveyorTiltTime = 0.3;
    public static final double bridgingArmTime = 0.3;
    
    // Constants
    public static final double cameraConstant = 5;
    
    // Driver Buttons
    public static final int bridgingArmToggleNumber = 5;
    
    // Gunner Buttons
    public static final int conveyorToggleNumber = 7;
    public static final int gunToggleNumber = 6;
    public static final int conveyorEngageNumber = 8; //CHANGE ME!
    public static final int autoAlignNumber = 5; //CHANGE ME!
    
}
