package frc.team5115.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.team5115.Subsystems.*;
import static frc.team5115.Constants.*;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.networktables.NetworkTableInstance;

public class RobotContainer {

    public Drivetrain drivetrain;
    public final Joystick joy = new Joystick(0);
    public Timer timer;

    public RobotContainer() {
        drivetrain = new Drivetrain();
        timer = new Timer();
        timer.reset();
        configureButtonBindings();
    }

    public void configureButtonBindings() {
    }

    public void setDriveDefault(){
        drivetrain.setDefaultCommand(new driveDefaultCommand(drivetrain, joy).perpetually());
    }

   static class driveDefaultCommand extends CommandBase {
        Drivetrain drivetrain;
        Joystick joy;

        public driveDefaultCommand(Drivetrain drivetrain, Joystick joystick) {
            addRequirements(drivetrain);
            this.drivetrain = drivetrain;
            joy = joystick;
          
        }

        @Override
        public void execute() {
           drivetrain.TankDrive(joy.getRawAxis(4), joy.getRawAxis(1), 1);
     
        }    
    }


    public void startTeleop(){
        System.out.println("Starting teleop");
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(0);
        //drivetrain.resetEncoder();
  
    }

    public void startAuto(){
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(1);
        //drivetrain.resetEncoder();

    }

    public void autoPeriod(){
      //  drivetrain.printEncoderDistance();
       // drivetrain.DistanceDetectionAverage();

        }
    public void teleopPeriodic(){
        //climber.print();
    }

    }
