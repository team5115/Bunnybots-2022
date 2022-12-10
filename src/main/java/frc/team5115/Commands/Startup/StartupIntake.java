package frc.team5115.Commands.Startup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team5115.Classes.Software.IntakeMotor;
import frc.team5115.Classes.Software.Latch;
import edu.wpi.first.wpilibj.Timer;
import com.revrobotics.CANSparkMax;

public class StartupIntake extends CommandBase{
    public IntakeMotor intake;
    public Latch latch;
    public Timer timer; 

    public StartupIntake(IntakeMotor a, Latch b){
        intake = a;
        latch = b;
        timer = new Timer();
    }
    public void initialize() {
        //latch.close();
        intake.startUp();
        timer.delay(0.1);

    }

    @Override
    public void execute(){
        System.out.println(intake.getEncoder());
    }

    @Override
    public void end(boolean interrupted){
        System.out.println("Stopped Startup");
        intake.startUp();
        intake.stop();
        System.out.println(intake.getEncoder());
    }

    @Override
    public boolean isFinished() {
        if(intake.getSpeed()<1){
            return true;
        }



        return false;
      }


}
