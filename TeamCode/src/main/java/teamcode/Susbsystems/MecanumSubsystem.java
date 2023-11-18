package teamcode.Susbsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.sql.Driver;

public class MecanumSubsystem {

    private DcMotor frontLeft, frontRight, rearLeft, rearRight;

    public MecanumSubsystem(HardwareMap hardwareMap) {

        frontLeft = hardwareMap.get(DcMotor.class, "left_front");
        frontRight = hardwareMap.get(DcMotor.class, "right_front");
        rearLeft = hardwareMap.get(DcMotor.class, "left_rear");
        rearRight = hardwareMap.get(DcMotor.class, "right_rear");

        Drive(0,0,0,0);
    }

    public void Drive(double fL, double fR, double rL, double rR) {
        frontLeft.setPower(fL);
        frontRight.setPower(fR);
        rearLeft.setPower(rL);
        rearRight.setPower(rR);
    }

    public void Forward(double power) {
        Drive(power,power,power,power);
    }

    public void Strafe(double power) {
        Drive(-power, -power, power, power);
    }

    public void Turn(double power) {
        Drive(power, -power, power, -power);
    }
}
