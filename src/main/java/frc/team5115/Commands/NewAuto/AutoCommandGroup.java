package frc.team5115.Commands.NewAuto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.team5115.Commands.Stopeverything;
import frc.team5115.Commands.NewAuto.Adjust.AdjustDriveCommandGroup;
import frc.team5115.Subsystems.*;
import frc.team5115.Commands.NewAuto.Adjust.AdjustDriveCommandGroup;


public class AutoCommandGroup extends SequentialCommandGroup {
  Drivetrain drivetrain;
  IntakePneum intake;
  Latch latch;

  public AutoCommandGroup(IntakePneum a, Drivetrain drivetrain, Latch latch){
      intake = a;
      this.latch = latch;
      this.drivetrain = drivetrain;
      addCommands(
          //shoot preloaded ball
          new AdjustDriveCommandGroup(drivetrain, latch)
          );
          //Substitute for limelight code
          //new DriveToPoint(drivetrain),
    }

}
