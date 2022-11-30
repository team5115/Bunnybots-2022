package frc.team5115.Subsystems.Hardware;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.team5115.Constants.*;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxRelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class HardwareIntakeMotor extends SubsystemBase{
    private CANSparkMax intake;
    private RelativeEncoder intakeEncoder;

    public HardwareIntakeMotor(){
        intake = new CANSparkMax(LEFT_CLIMBER_MOTOR_ID, MotorType.kBrushless);    
        intakeEncoder = intake.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor, 42);
    }

    public double getCurrent(){
        return intake.getOutputCurrent();
    }

    public double getEncoder(){
        return intakeEncoder.getPosition();
    }

    public double getEncoderDeg(){
       return (intakeEncoder.getPosition())*(360/42);
    }

    public double getEncoderRad(){
        return (getEncoderDeg()/180)*Math.PI*2;
    }

    public void setSpeed(double x){
        intake.set(x);
    }
}
