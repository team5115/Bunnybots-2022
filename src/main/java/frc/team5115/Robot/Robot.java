package frc.team5115.Robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.cameraserver.CameraServer;

public class Robot extends TimedRobot {
    private RobotContainer robotContainer;
    public Timer timer;

    @Override
    public void robotInit() {
        robotContainer = new RobotContainer();
        timer = new Timer();
        timer.start();
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

    @Override
    public void disabledInit() {
        robotContainer.stopEverything();
    }

    @Override
    public void disabledPeriodic() {
    }

    @Override
    public void autonomousInit() {
        robotContainer.startAuto();
    }


    public void autonomousPeriodic() {
        robotContainer.autoPeriod();
    }

    public void teleopInit () {
        robotContainer.startTeleop();
        CameraServer.startAutomaticCapture();
    }
    
    public void teleopPeriodic () {
       // robotContainer.Camera();
       robotContainer.teleopPeriodic();
    }

    public void testInit () {
        CommandScheduler.getInstance().cancelAll();
    }

    public void testPeriodic () {
        
    }

    public void practiceInit(){
        robotContainer.startAuto();
    }

    public void practicePeriodic(){
        autonomousInit();
        if(timer.get()<15){
            autonomousPeriodic();
        }
        else{
        teleopPeriodic();
        }
        if(timer.get() == 15){
            teleopInit();
        }
    }
}
