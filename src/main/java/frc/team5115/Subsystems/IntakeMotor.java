package frc.team5115.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.team5115.Constants.*;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class IntakeMotor extends SubsystemBase{
    private double intakeSpeed = .8;
    private TalonSRX intake;
    private double speed;

    public IntakeMotor(){
        intake = new TalonSRX(INTAKE_MOTOR_ID);    
        speed = 0.5;
    }

    public void forwardIntake(){
        intake.set(ControlMode.PercentOutput, speed);
    }

    public void reverseIntake(){
        intake.set(ControlMode.PercentOutput, speed);
    }
    
    public void stop(){
        intake.set(ControlMode.PercentOutput, 0);
    }
    
}
