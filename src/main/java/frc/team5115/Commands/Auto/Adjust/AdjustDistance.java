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
    }

    @Override
        public void initialize(){
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
        public void end(boolean interrupted){
            drivetrain.stop();
            
            //camera.setClimbAngle();
            //NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(0);
        }

    
    @Override
        public boolean isFinished() {
            //if(drivetrain.letgo){
            //     return true;
            //}
            
                //move 51.5 inches

            if(timer.get() >  Math.pow(5, 1)){
                return true;
            }
            return false;
        }
}

