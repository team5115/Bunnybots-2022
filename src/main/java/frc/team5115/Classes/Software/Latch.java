package frc.team5115.Classes.Software;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Latch extends SubsystemBase{
    private DoubleSolenoid latch1 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);    
    private DoubleSolenoid latch2 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);    
    
    public Latch(){
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
