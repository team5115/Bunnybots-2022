package frc.team5115.Classes.Hardware;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.team5115.Constants.*;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxRelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class HardwareIntakeMotor extends SubsystemBase{
    private CANSparkMax intake;
    private RelativeEncoder intakeEncoder;
    private double startEncoderValue;

    public HardwareIntakeMotor(){
        intake = new CANSparkMax(LEFT_CLIMBER_MOTOR_ID, MotorType.kBrushless);    
        intakeEncoder = intake.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor, 42);
    }

    public double getCurrent(){
        return intake.getOutputCurrent();
    }

    public boolean getFault(CANSparkMax.FaultID f){
        return intake.getFault(f);
    }

    public void resetEncoder(){
        startEncoderValue = intakeEncoder.getPosition();
    }

    public double getEncoder(){
        return (intakeEncoder.getPosition()-startEncoderValue);
    }

    public double getEncoderDeg(){
       return (getEncoder())*(360/42);
    }

    public double getEncoderRad(){
        return (getEncoderDeg()/180)*Math.PI;
    }

    public double getVelocity(){
        return intakeEncoder.getVelocity();
    }

    public void setSpeed(double x){
        intake.set(x);
    }
}
