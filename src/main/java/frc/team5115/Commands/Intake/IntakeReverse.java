package frc.team5115.Commands.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team5115.Classes.Software.IntakeMotor;
import frc.team5115.Classes.Software.Latch;
import edu.wpi.first.wpilibj.Timer;

public class IntakeReverse extends CommandBase{
    public IntakeMotor intake;
    public Latch latch;
    public Timer timer;

    public IntakeReverse(IntakeMotor a){
        intake = a;
        timer = new Timer();
        timer.start();
    }
    public void initialize() {
        intake.reverseIntake();
        timer.reset();

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

        if(timer.get()>5){
            return true;
        }


        return false;
      }


}
