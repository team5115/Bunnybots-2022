package frc.team5115.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import static frc.team5115.Constants.*;

import frc.team5115.Commands.*;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.team5115.Commands.NewAuto.AutoCommandGroup;
import frc.team5115.Commands.NewAuto.Adjust.AdjustDistance;
import frc.team5115.Subsystems.Software.Drivetrain;
import frc.team5115.Subsystems.Software.IntakeMotor;
import frc.team5115.Subsystems.Software.Latch;

public class RobotContainer {

    public Drivetrain drivetrain;
    public final Joystick joy = new Joystick(0);
    public Latch latch; 
    public Timer timer;
    public IntakeMotor intakemotor;
    public AutoCommandGroup autocommandgroup;
    public Stopeverything stop;

    public RobotContainer() {
        drivetrain = new Drivetrain();
        intakemotor = new IntakeMotor();
        latch = new Latch();
        autocommandgroup = new AutoCommandGroup(latch, drivetrain, intakemotor);
        timer = new Timer();
        timer.reset();
        configureButtonBindings();
        stop = new Stopeverything(intakemotor, latch);
    }

    public void configureButtonBindings() {
        new JoystickButton( joy, 1).whenPressed(new InstantCommand(intakemotor::forwardIntake));
        new JoystickButton( joy, 2).whenPressed(new InstantCommand(intakemotor::reverseIntake));
        //new JoystickButton( joy, 1).whenHeld(new InstantCommand(intakemotor::forwardIntake)).whenReleased(intakemotor::stop);
        //new JoystickButton( joy, 3).whenHeld(new InstantCommand(latch::open)).whenReleased(new InstantCommand(latch :: close));
        new JoystickButton(joy, 4).whenPressed(new InstantCommand(drivetrain::switchThrottle));


        //new JoystickButton(joy, SHOOTER_BUTTON_ID).whileHeld(new DelayShootGroupAuto(intake, feeder, shooter)).whenReleased(new Stopeverything(intake, feeder, shooter));
        //new JoystickButton(joy, 10).whileHeld(new AdjustDistance(drivetrain, camera)).whenReleased(new InstantCommand(drivetrain::letGo));
    }


    public void setDriveDefault(){
        drivetrain.setDefaultCommand(new driveDefaultCommand(drivetrain, joy));
        //drivetrain.setDefaultCommand(new driveDefaultCommand(drivetrain, joy).perpetually());
    }
 
   static class driveDefaultCommand extends CommandBase {
        Drivetrain drivetrain;
        Joystick joy;
        Latch camera;

        public driveDefaultCommand(Drivetrain drivetrain, Joystick joystick) {
            addRequirements(drivetrain);
            this.drivetrain = drivetrain;
            joy = joystick;
        }

        @Override
        public void execute() {
           //drivetrain.MecanumSimpleDrive(joy.getRawAxis(4), joy.getRawAxis(1), joy.getRawAxis(0));
           drivetrain.TankDrive(joy.getRawAxis(4), joy.getRawAxis(1));
           //drivetrain.DistanceDetectionAverage();
        }    
    }


    public void startTeleop(){
        System.out.println("Starting teleop");
        stop.schedule();
        //NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(0);
        //drivetrain.resetEncoder();
        if (autocommandgroup != null) {
            autocommandgroup.cancel();
          }
  
    }

    public void stopEverything(){
        stop.schedule();
        drivetrain.stop();
    }

    public void startAuto(){
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(1);
        //drivetrain.resetEncoder();
        if (autocommandgroup != null) {
            autocommandgroup.schedule();
          }
        
    }

    public void autoPeriod(){
       // drivetrain.DistanceDetectionAverage();

        }
    public void teleopPeriodic(){
    }

    }
