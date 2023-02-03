package frc.team5115.Classes.Acessory;

public class switchDirection{

    double throttle;
    double throttleOriginal;
    private static double reverseDirectionCount = 0;

    public switchDirection(double throttle){
        this.throttleOriginal = throttle;
        this.throttle = throttleOriginal;
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
