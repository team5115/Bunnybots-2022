package frc.team5115.Commands.NewAuto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.team5115.Commands.NewAuto.Adjust.AdjustDriveCommandGroup;
import frc.team5115.Subsystems.Software.Drivetrain;
import frc.team5115.Subsystems.Software.IntakeMotor;
import frc.team5115.Subsystems.Software.Latch;
import frc.team5115.Commands.NewAuto.Adjust.AdjustDriveCommandGroup;
import frc.team5115.Commands.Startup;


public class AutoCommandGroup extends SequentialCommandGroup {
  Drivetrain drivetrain;
  IntakeMotor intake;
  Latch latch;

  public AutoCommandGroup(Latch a, Drivetrain drivetrain, IntakeMotor intake){
      latch = a;
      this.intake = intake;
      this.drivetrain = drivetrain;
      addCommands(
          //shoot preloaded ball
          new AdjustDriveCommandGroup(drivetrain, intake),
          new Startup(latch, intake)
          );
          //Substitute for limelight code
          //new DriveToPoint(drivetrain),
    }

}
