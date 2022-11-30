package frc.team5115.Commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team5115.Subsystems.Software.IntakeMotor;
import frc.team5115.Subsystems.Software.Latch;

public class Stopeverything extends CommandBase{
    public IntakeMotor intake;
    public Latch latch;

    public Stopeverything(IntakeMotor a, Latch b){
        intake = a;
        latch = b;
    }
    public void initialize() {
        //latch.close();
        intake.reverseIntake();

    }

    public boolean isFinished() {
        return true;
      }


}
