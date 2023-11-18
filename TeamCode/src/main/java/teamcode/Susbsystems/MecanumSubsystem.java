package teamcode.Susbsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class MecanumSubsystem {

    public DcMotorEx leftFront, leftRear, rightFront, rightRear;

    public void Drive(double v, double v1, double v2, double v3){
        leftFront.setPower(v);
        leftRear.setPower(v1);
        rightFront.setPower(v2);
        rightRear.setPower(v3);
    }

    public MecanumSubsystem(HardwareMap hardwareMap){

        leftFront = hardwareMap.get(DcMotorEx.class,"leftFront");
        leftRear = hardwareMap.get(DcMotorEx.class,"leftRear");
        rightFront = hardwareMap.get(DcMotorEx.class,"rightFront");
        rightRear = hardwareMap.get(DcMotorEx.class,"rightRear");

        Drive(0,0,0,0);

        leftFront.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        leftRear.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        rightRear.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        leftFront.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        leftRear.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        rightRear.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        leftFront.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        leftRear.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        rightRear.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

        leftFront.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        leftRear.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        rightRear.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

    }

    private double converttoec(double inches) {
        double convert = 537.7 / (Math.PI * 3.77953);
        return convert;
    }

    private void wait(double time) {
        ElapsedTime elapsedTime = new ElapsedTime();
        elapsedTime.reset();
        while (elapsedTime.milliseconds() < time) {

        }
    }

    public void ForwardM(double p){
        Drive(p,p,p,p);
    }

    public void TurnM(double p){
        Drive(p,-p,p,-p);
    }

    public void SlideM(double p){
        Drive(-p,-p,p,p);
    }

    public void ForwardA(double p, double i){
        ForwardM(p);
        converttoec(i);
        ForwardM(0);
    }

    public void TurnA(double p, double i){
        TurnM(p);
        converttoec(i);
        TurnM(0);
    }

    public void SlideA(double p, double i){
        SlideM(p);
        converttoec(i);
        SlideM(0);
    }

}
