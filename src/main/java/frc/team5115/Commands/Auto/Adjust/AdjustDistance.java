package frc.team5115.Commands.Auto.Adjust;

import java.lang.Math;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team5115.Classes.Software.Drivetrain;
import frc.team5115.Classes.Software.IntakeMotor;

import edu.wpi.first.wpilibj.Timer;


public class AdjustDistance extends CommandBase {
    Drivetrain drivetrain;
    IntakeMotor intake;
    Timer timer;

    public AdjustDistance(Drivetrain drivetrain, IntakeMotor intake) {
        this.drivetrain = drivetrain;
        this.intake = intake;
        timer = new Timer();
        timer.start();
    }

    @Override
        public void initialize(){
            //NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(1);
            timer.reset();
        }


    @Override
        public void execute() {
            drivetrain.autodrive();
            //System.out.print("adjusting distance");
            //System.out.println(drivetrain.getY());

        }

    @Override
        public void end(boolean interrupted){
            drivetrain.stop();
            System.out.println("ahhh");
            //camera.setClimbAngle();
            //NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(0);
        }

    
    @Override
        public boolean isFinished() {
            //if(drivetrain.letgo){
            //     return true;
            //}
            
                //move 51.5 inches

            if(timer.get() >  5){
                return true;
            }
            return false;
        }
}

