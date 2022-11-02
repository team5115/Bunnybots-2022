package frc.team5115.Subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Latch extends SubsystemBase {
    Servo servo; 
    double shoot = 45;
    double climb = 90;
    double neutral = 0; 
    boolean stop = false;
    
    
    public Latch(){
        servo = new Servo(0);
      //  servo.setAngle(neutral);
    }

    public void findDesirable(){
        int x = 0;
        while(!stop){
            x += 1;
            servo.set(x);
        }
    }

    public void foundDesirable(){
        stop = true;
    }

    public void openGate(){
        servo.setAngle(180);
    }

    public void closeGate(){
        servo.setAngle(0);
    }



    public void getAngle(){
       // System.out.println("servo angle"+servo.getAngle());}
}
}