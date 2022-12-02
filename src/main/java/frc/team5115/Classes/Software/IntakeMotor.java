package frc.team5115.Classes.Software;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.team5115.Classes.Hardware.HardwareIntakeMotor;

public class IntakeMotor extends SubsystemBase{
    private HardwareIntakeMotor intake;

    public IntakeMotor(){
        intake = new HardwareIntakeMotor();
    }

    public void forwardIntake(){
        /*if(intake.getVelocity() < 2){
            break;
        }*/
        intake.setSpeed(-0.2);
    }

    public double getEncoder(){
        return intake.getEncoder();
    }

    public void reverseIntake(){
            /*if(intake.getVelocity() < 2){
                break;
            }*/
            intake.setSpeed(0.2);
    }

    public void startUp(){
        intake.setSpeed(0.2);
        intake.resetEncoder();
    }

    public void stop(){
        intake.setSpeed(0.0);
    }

    public void stopNegative(){
        intake.setSpeed(-0.0);
    }
}
