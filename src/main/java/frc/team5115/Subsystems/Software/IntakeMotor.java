package frc.team5115.Subsystems.Software;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.team5115.Subsystems.Hardware.HardwareIntakeMotor;
import static frc.team5115.Constants.*;

public class IntakeMotor extends SubsystemBase{
    private HardwareIntakeMotor intake;
    private double currentLimit = 1000;

    public IntakeMotor(){
        intake = new HardwareIntakeMotor();
    }

    public void forwardIntake(){
        while(intake.getEncoder()>-10){
            if(intake.getCurrent()>currentLimit){
                intake.setSpeed(0);
                break;
            }
            System.out.println(intake.getEncoder());
            intake.setSpeed(-.1);
            
        }
    }

    public void reverseIntake(){
        while(intake.getEncoder()<=-1){
            if(intake.getCurrent()>currentLimit){
                intake.setSpeed(0);
                break;
            }
            intake.setSpeed(0.2);
    }
    }
}
