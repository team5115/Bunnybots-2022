package frc.team5115.Classes.Hardware;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.team5115.Classes.Acessory.*;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import static frc.team5115.Constants.*; 

public class HardwareDrivetrain{
// tell electrical to make pdp ids the same as can ids

    private TalonSRX frontLeft = new TalonSRX(FRONT_LEFT_MOTOR_ID);
    private TalonSRX frontRight = new TalonSRX(FRONT_RIGHT_MOTOR_ID);
    private TalonSRX backLeft = new TalonSRX(BACK_LEFT_MOTOR_ID);
    private TalonSRX backRight = new TalonSRX(BACK_RIGHT_MOTOR_ID);
    private switchDirection throttle;

    public HardwareDrivetrain(){
        frontLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        frontRight.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        backLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        backRight.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        resetEncoder();
        throttle = new switchDirection(1);
    }

    public double getEncoder(int id){
        TalonSRX talon;
        talon = new TalonSRX(id);
        return (talon.getSelectedSensorPosition()*ENCODER_CALIBRATION);
    }

    public void setThrottle(double throttle){
        this.throttle.setThrottle(throttle);
    }
    
    public void switchThrottle(){
        throttle.switchThrottle();
    }

    //ONE BY ONE CHECK THE DRIVE MOTORS TO CHECK IF THEYRE REVERSED

    public void plugAndChugDrive(double frontleftspeed, double frontrightspeed, double backleftspeed, double backrightspeed){
        frontLeft.set(ControlMode.PercentOutput, frontleftspeed);//*throttle.getThrottle());
        frontRight.set(ControlMode.PercentOutput, frontrightspeed);//*throttle.getThrottle());
        backLeft.set(ControlMode.PercentOutput, backleftspeed);//*throttle.getThrottle());
        backRight.set(ControlMode.PercentOutput, backrightspeed);//*throttle.getThrottle());
    }

    public void resetEncoder(){
        backLeft.setSelectedSensorPosition(0);
        backRight.setSelectedSensorPosition(0);
    }
}