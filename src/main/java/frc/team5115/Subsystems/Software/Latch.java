package frc.team5115.Subsystems.Software;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.team5115.Constants.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Latch extends SubsystemBase{
    private Compressor comp = new Compressor(PneumaticsModuleType.CTREPCM);
    private DoubleSolenoid latch1 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);    
    private DoubleSolenoid latch2 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);    
    
    public Latch(){
    }

    public void setPressureLimit(double x){
    }

    public void open(){
        latch1.set(Value.kForward);
        latch2.set(Value.kForward);
    }

    public void close(){
        latch1.set(Value.kReverse);
        latch2.set(Value.kReverse);

    }
    
}
