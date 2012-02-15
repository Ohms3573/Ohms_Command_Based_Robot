package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Paul
 */
public class AutoAlignTurret extends CommandBase{
    
    public AutoAlignTurret(){
        requires(camera);
        requires(turret);
    }
    protected void initialize() {
        
    }

    protected void execute() {
        double[][] blobs = camera.getCameraInput();
        
        turret.alignTurretWithCamrera(1, blobs);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }    
    
}
