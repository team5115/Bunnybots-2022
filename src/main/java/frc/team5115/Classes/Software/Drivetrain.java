package frc.team5115.Classes.Software;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.team5115.Classes.Hardware.HardwareDrivetrain;

import static frc.team5115.Constants.*;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Timer;

public class Drivetrain extends SubsystemBase{
    
    public NetworkTable ShooterCam;
    public NetworkTableEntry ty;
    public NetworkTableEntry tx;
    public NetworkTableEntry tv;

    public boolean balldetected;

    private HardwareDrivetrain drivetrain = new HardwareDrivetrain();

    private double frontLeftSpeed;
    private double frontRightSpeed;
    private double backLeftSpeed;
    private double backRightSpeed;

    public double throttle;
    private Timer timer;
    //public double detector;
 
  //plugAndChugDrive(frontLeftSpeed, frontRightSpeed, backLeftSpeed, backRightSpeed);

    public Drivetrain() {
        timer = new Timer();
        timer.reset();
    }

    public void stop() {
        drivetrain.plugAndChugDrive(0, 0, 0, 0);
    }
    /*
    public void resetGyro(){
        gyro.reset();
    }
    */

    public void switchThrottle(){
        drivetrain.switchThrottle();
    }

    public void TankDrive(double x, double y) { 
        frontLeftSpeed = (x-y);
        frontRightSpeed = (x+y);
        drivetrain.plugAndChugDrive(frontLeftSpeed, frontRightSpeed, frontLeftSpeed, frontRightSpeed);
    } 

    public void MecanumSimpleDrive(double y, double x, double z) {
        frontLeftSpeed = (-x + y + z);
        backLeftSpeed = (-x + y - z);
        frontRightSpeed = (x +  y + z);
        backRightSpeed = (x + y - z);
        drivetrain.plugAndChugDrive(frontLeftSpeed, frontRightSpeed, backLeftSpeed, backRightSpeed);
    }  

    public void autodrive(){
        drivetrain.plugAndChugDrive(0.30, -0.30, 0.30, -0.30);
    }

    public void backwardsdrive(){
        drivetrain.plugAndChugDrive(-0.30, -0.30, -0.30, -0.30);
    }
    
    public void DistanceDetectionAverage(){
        ShooterCam = NetworkTableInstance.getDefault().getTable("limelight");
            ty = ShooterCam.getEntry("ty");
            tx = ShooterCam.getEntry("tx");
            tv = ShooterCam.getEntry("tv");
           //System.out.print(ty.getDouble(0));
           //System.out.print(tx.getDouble(0));
        } 

    public void AdjustAngle(){
        double xangle = -tx.getDouble(0); 
        double detector = tv.getDouble(0);
        frontLeftSpeed = -xangle*kD;
        if(frontLeftSpeed > 0.3){
            frontLeftSpeed = 0.3;
            System.out.println("capping speed");
        }
        if(frontLeftSpeed < -0.3){
            frontLeftSpeed = -0.3;
            System.out.println("capping speed");
        }
        if(!(detector == 1)){
            frontLeftSpeed = 0;
            System.out.print("nothing detected");
        }

        drivetrain.plugAndChugDrive(frontLeftSpeed, frontLeftSpeed, frontLeftSpeed, frontLeftSpeed);
        System.out.println("left speed "+ frontLeftSpeed);
        System.out.println("right speed "+ -frontLeftSpeed);
    }

    public double getX(){
        DistanceDetectionAverage();
        return tx.getDouble(0);
    }

    public double getY(){
        DistanceDetectionAverage();
        return ty.getDouble(0);
    }

    public void oliviaMode(){
        drivetrain.setThrottle(1);
    }

    public void adultMode(){
        drivetrain.setThrottle(1);
    }

    // public double getDistanceFromHub(){
    //     double yAngle = ty.getDouble(0);
    //     d = (AUTO_HIGH_GOAL_HEIGHT - AUTO_CAMERA_HEIGHT) / tan(toRadians(yAngle + AUTO_CAMERA_ANGLE));
    //     return d;
    // }

    public void AdjustDistance(){
        
        DistanceDetectionAverage();
        double dectector = tv.getDouble(0);
        if(dectector == 1){
        /**d = (AUTO_HIGH_GOAL_HEIGHT - AUTO_CAMERA_HEIGHT) / tan(toRadians(yangle + AUTO_CAMERA_ANGLE));
       
            leftSpd = (d-HUB_DISTANCE)*hD;
            rightSpd = -(d - HUB_DISTANCE)*hD;
            */
            double yangle = ty.getDouble(0); 

            frontLeftSpeed = -(TARGET_ANGLE - yangle)*hD;
            frontLeftSpeed = Math.max(-0.3, Math.min(0.3, frontLeftSpeed));
        drivetrain.plugAndChugDrive(frontRightSpeed, frontRightSpeed, frontLeftSpeed, frontRightSpeed);
        }
    }
}
