package frc.team5115.Commands.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team5115.Subsystems.Software.IntakeMotor;
import frc.team5115.Subsystems.Hardware.HardwareIntakeMotor;
import frc.team5115.Subsystems.Software.Latch;

import edu.wpi.first.wpilibj.Timer;

public class IntakeReverse extends CommandBase{
    public IntakeMotor intake;
    public Latch latch;
    public Timer timer; 

    public IntakeReverse(IntakeMotor a){
        intake = a;
        timer = new Timer();
    }
    public void initialize() {
        intake.reverseIntake();
    }

    public void execute(){
        System.out.println(intake.getEncoder());
    }

    public void end(boolean interrupted){
        intake.stopNegative();
        System.out.println("Stoped 2");
    }

    public boolean isFinished() {
        if(intake.getEncoder()>-1){
            return true;
        }
        return false;
      }


}