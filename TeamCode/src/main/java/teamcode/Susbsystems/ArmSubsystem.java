package teamcode.Susbsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.checkerframework.checker.units.qual.A;

public class ArmSubsystem {
    private DcMotor pivotMotor, extendMotor, intakeMotor;

    private Servo grabServo, launchServo, wristServo;

    public ArmSubsystem(HardwareMap hardwareMap) {

        pivotMotor = hardwareMap.get(DcMotor.class, "pivotMotor");
        extendMotor = hardwareMap.get(DcMotor.class, "extendMotor");
        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
        grabServo = hardwareMap.get(Servo.class, "grabServo");
        launchServo = hardwareMap.get(Servo.class, "launchServo");
        wristServo = hardwareMap.get(Servo.class, "wristServo");

        pivotMotor.setPower(0);
        extendMotor.setPower(0);
        intakeMotor.setPower(0);
    }

    public void extendM(double power) {
        extendMotor.setPower(power);
    }

}