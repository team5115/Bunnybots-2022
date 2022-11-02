package frc.team5115.Commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team5115.Subsystems.*;


public class Stopeverything extends CommandBase{
    public IntakePneum intake;
    public Latch latch;

    public Stopeverything(IntakePneum a, Latch b){
        intake = a;
        latch = b;
    }
    public void initialize() {
        intake.stop();
        latch.closeGate();

    }

    public boolean isFinished() {
        return true;
      }


}
