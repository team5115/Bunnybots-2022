package frc.team5115.Subsystems.Acessory;

public class switchDirection{

    double throttle;
    double throttleOriginal;
    private double reverseDirectionCount = 0;

    public switchDirection(double throttle){
        this.throttleOriginal = throttle;
    }
    public void switchThrottle(){
        throttle = throttleOriginal;
        reverseDirectionCount++;
        if(reverseDirectionCount % 2 == 0){
            throttle = throttleOriginal;
        }
        else{
            throttle = -throttleOriginal;
        } 

    }
    public double getThrottle(){
        return throttle;
    }

    public void setThrottle(double throttle){
        this.throttleOriginal = throttle;
    }
}
