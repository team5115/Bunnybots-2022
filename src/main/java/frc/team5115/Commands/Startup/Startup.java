package frc.team5115.Commands.Startup;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.team5115.Classes.Software.IntakeMotor;
import frc.team5115.Classes.Software.Latch;

public class Startup extends ParallelCommandGroup {
    IntakeMotor intake;
    Latch latch;
  
    public Startup(Latch a, IntakeMotor intake){
        this.intake = intake;
        latch = a;
        addCommands(
            //shoot preloaded ball
            new StartupIntake(intake, latch)
            );
            //Substitute for limelight code
            //new DriveToPoint(drivetrain),
      }
  
  }