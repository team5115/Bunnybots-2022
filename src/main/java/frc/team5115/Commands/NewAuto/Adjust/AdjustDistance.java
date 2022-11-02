package frc.team5115.Commands.NewAuto.Adjust;

import java.lang.Math;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team5115.Subsystems.*;
import static frc.team5115.Constants.*;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Timer;


public class AdjustDistance extends CommandBase {
    Drivetrain drivetrain;
    Latch latch;
    Timer timer;

    public AdjustDistance(Drivetrain drivetrain, Latch latch) {
        this.drivetrain = drivetrain;
        this.latch = latch;
    }

    @Override
        public void initialize(){
            timer.reset();
            timer.start();
            //NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(1);
        }


    @Override
        public void execute() {
            drivetrain.autodrive();
            //System.out.print("adjusting distance");
            //System.out.println(drivetrain.getY());

        }

    @Override
        public void end(boolean interupted){
            drivetrain.stop();
            
            //camera.setClimbAngle();
            //NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(0);
        }

    
    @Override
        public boolean isFinished() {
            //if(drivetrain.letgo){
            //     return true;
            //}
            
            if(drivetrain.EncoderDistance() > 5){
                return true;
            }

            if(timer.get() >  5){
                return true;
            }
            return false;
        }
}
