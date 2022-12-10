package frc.team5115.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.team5115.Classes.Software.Drivetrain;
import frc.team5115.Classes.Software.IntakeMotor;
import frc.team5115.Classes.Software.Latch;
import frc.team5115.Commands.Auto.AutoCommandGroup;
import frc.team5115.Commands.Intake.*;
import frc.team5115.Commands.Startup.StartupIntake;
import edu.wpi.first.wpilibj.Timer;

public class RobotContainer {

    public Drivetrain drivetrain;
    public final Joystick joy = new Joystick(0);
    public Latch latch; 
    public Timer timer;
    public IntakeMotor intakemotor;
    public AutoCommandGroup autocommandgroup;
    public StartupIntake start;
    public IntakeForward intakeCommandF;
    public IntakeReverse intakeCommandR;

    public RobotContainer() {
        drivetrain = new Drivetrain();
        intakemotor = new IntakeMotor();
        latch = new Latch();
        autocommandgroup = new AutoCommandGroup(latch, drivetrain, intakemotor);
        timer = new Timer();
        timer.reset();
        configureButtonBindings();
        start = new StartupIntake(intakemotor, latch);

    }

    public void configureButtonBindings() {
        new JoystickButton( joy, 1).whenPressed(new IntakeForward(intakemotor));
        new JoystickButton( joy, 2).whenPressed(new IntakeReverse(intakemotor));
        //new JoystickButton( joy, 1).whenHeld(new InstantCommand(intakemotor::forwardIntake)).whenReleased(intakemotor::stop);
        new JoystickButton( joy, 3).whenHeld(new InstantCommand(latch::open)).whenReleased(new InstantCommand(latch::close));
        new JoystickButton(joy, 4).whenPressed(new InstantCommand(drivetrain::switchThrottle));


        //new JoystickButton(joy, SHOOTER_BUTTON_ID).whileHeld(new DelayShootGroupAuto(intake, feeder, shooter)).whenReleased(new Stopeverything(intake, feeder, shooter));
        //new JoystickButton(joy, 10).whileHeld(new AdjustDistance(drivetrain, camera)).whenReleased(new InstantCommand(drivetrain::letGo));
    }

    public void startTeleop(){
        start.schedule();
        System.out.println("Starting teleop");
        //NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(0);
        //drivetrain.resetEncoder();
        autocommandgroup.cancel();

    }

    public void stopEverything(){
        //stop.schedule();
        drivetrain.stop();
    }

    public void startAuto(){
        //NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(1);
        //drivetrain.resetEncoder();
        autocommandgroup.schedule();

    }

    public void autoPeriod(){
       // drivetrain.DistanceDetectionAverage();

        }
    public void teleopPeriodic(){
        drivetrain.TankDrive(joy.getRawAxis(4), joy.getRawAxis(1));
    }
    }
