package frc.team5115.Commands.NewAuto.Adjust;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import static frc.team5115.Constants.*;

import frc.team5115.Robot.*;
import frc.team5115.Subsystems.Software.Drivetrain;
import frc.team5115.Subsystems.Software.IntakeMotor;
import frc.team5115.Subsystems.Software.Drivetrain.*;

public class AdjustDriveCommandGroup extends SequentialCommandGroup {
        Drivetrain drivetrain;
        IntakeMotor intake;

    

    public AdjustDriveCommandGroup(Drivetrain drivetrain, IntakeMotor intake){
        this.drivetrain = drivetrain;
        this.intake = intake;
        addCommands(
        //Adjusts Angle
        //new AdjustAngle(drivetrain),

       new AdjustDistance(drivetrain, intake)

     //   new Stop(drivetrain)
        );
        
}
}
