package frc.team5115.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.team5115.Constants.*;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class IntakePneum extends SubsystemBase{
    private double intakeSpeed = .8;
    private DoubleSolenoid intake;

    public IntakePneum(){
        intake = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);    
    }

    public void forwardIntake(){
        intake.set(Value.kForward);
    }

    public void reverseIntake(){
        intake.set(Value.kReverse);
    }
    
    public void stop(){
        intake.set(Value.kOff);
    }
    
}
