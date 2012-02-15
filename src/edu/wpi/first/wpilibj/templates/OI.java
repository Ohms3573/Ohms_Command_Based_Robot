
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.ToggleBridgingArm;
import edu.wpi.first.wpilibj.templates.commands.ToggleConveyor;
import edu.wpi.first.wpilibj.templates.commands.ToggleEngageConveyor;
import edu.wpi.first.wpilibj.templates.commands.TurnOffGun;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    Joystick driverStick;
    Joystick gunnerStick;
    
    JoystickButton conveyorToggle;
    JoystickButton conveyorEngage;
    JoystickButton gunToggle;
    JoystickButton bridgingArmToggle;
    JoystickButton autoAlign;
    
    public OI() {
        driverStick = new Joystick(RobotMap.driverStickPort);
        gunnerStick = new Joystick(RobotMap.gunnerStickPort);
        
        bridgingArmToggle = new JoystickButton(driverStick, RobotMap.bridgingArmToggleNumber);
        bridgingArmToggle.whenPressed(new ToggleBridgingArm());
        
        conveyorToggle = new JoystickButton(gunnerStick, RobotMap.conveyorToggleNumber);
        conveyorToggle.whenPressed(new ToggleConveyor());
        
        conveyorEngage = new JoystickButton(gunnerStick,RobotMap.conveyorEngageNumber);
        conveyorEngage.whenPressed(new ToggleEngageConveyor());
        
        gunToggle = new JoystickButton(gunnerStick, RobotMap.gunToggleNumber);
        gunToggle.whileHeld(new TurnOffGun());
        
        autoAlign = new JoystickButton(gunnerStick, RobotMap.autoAlignNumber);
    }
    
//    Button armDownButton = new JoystickButton(stick, 4);
    
//    armDownButton.whileHeld(new JogArmDownCommand());

    public Joystick getDriverStick() {
        return driverStick;
    }
    
    public Joystick getGunnerStick() {
        return gunnerStick;
    }
    
}

