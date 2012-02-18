package edu.wpi.first.wpilibj.templates.subsystems;

import com.sun.squawk.util.Arrays;
import com.sun.squawk.util.Comparer;
import edu.wpi.first.wpilibj.camera.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 * @author Paul
 */
public class Camera extends Subsystem{
    private AxisCamera camera;
    private ColorImage colorImage;
    private ParticleAnalysisReport s_particles[];
    private final ParticleComparer particleComparer = new ParticleComparer();
    
    
    public void initDefaultCommand() {
        if(RobotMap.cameraIsEnabled){
            camera = AxisCamera.getInstance();
            SmartDashboard.putString("Camera", "Initialized");
        }
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
     
    public double[][] getCameraInput(){ 
        //returns all possible targets center of mass x, y, degreesoff, and area
        
        double[][] cameraInfo = {};
        if (camera.freshImage()) {	    // check if there is a new image
            try {
                colorImage = camera.getImage(); // get the image from the camera

                /**
                 * The color threshold operation returns a bitmap (BinaryImage) where pixels are present
                 * when the corresponding pixels in the source (HSL) image are in the specified
                 * range of H, S, and L values.
                 */
                BinaryImage binImage = colorImage.thresholdHSL(242, 255, 36, 255, 25, 255);

                /**
                 * Find blobs (groupings) of pixels that were identified in the color threshold operation
                 */
                s_particles = binImage.getOrderedParticleAnalysisReports();

                /**
                 * Free the underlying color and binary images.
                 * You must do this since the image is actually stored
                 * as a C++ data structure in the underlying implementation to maximize processing speed.
                 */
                colorImage.free();
                binImage.free();

                if (s_particles.length > 0) {
                    /**
                     * sort the particles using the custom comparitor class (see below)
                     */
                    Arrays.sort(s_particles, particleComparer);

                    for (int i = 0; i < s_particles.length; i++) {
                        ParticleAnalysisReport circ = s_particles[i];

                        /**
                         * Compute the number of degrees off center based on the camera image size
                         */
                        double degreesOff = -((54.0 / 640.0) * ((circ.imageWidth / 2.0) - circ.center_mass_x));
                        
                        cameraInfo[i][0]=circ.center_mass_x;
                        cameraInfo[i][1]=circ.center_mass_y;
                        cameraInfo[i][2]=degreesOff;
                        cameraInfo[i][3]=circ.particleArea;
                    }
                }
            } catch (AxisCameraException ex) {
                ex.printStackTrace();
            } catch (NIVisionException ex) {
                ex.printStackTrace();
            }
        }
        return cameraInfo;
    }
    
    class ParticleComparer implements Comparer {

        public int compare(ParticleAnalysisReport p1, ParticleAnalysisReport p2) {
            float p1Ratio = p1.boundingRectWidth / p1.boundingRectHeight;
            float p2Ratio = p2.boundingRectWidth / p2.boundingRectHeight;

            if (Math.abs(p1Ratio - p2Ratio) < 0.1) {
                return -(Math.abs((p1.imageWidth / 2) - p1.center_mass_x))
                        - Math.abs(((p2.imageWidth / 2) - p2.center_mass_x));
            } else {
                if (Math.abs(p1Ratio - 1) < Math.abs(p2Ratio - 1)) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }

	// overloaded method because the comparitor uses Objects (not Particles)
        public int compare(Object o1, Object o2) {
            return compare((ParticleAnalysisReport) o1, (ParticleAnalysisReport) o2);
        }
    }
}
