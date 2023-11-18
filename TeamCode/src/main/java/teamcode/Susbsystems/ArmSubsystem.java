package teamcode.Susbsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.checkerframework.checker.units.qual.A;

public class ArmSubsystem {
    ArmConstants armConstants;
    private DcMotor pivotMotor, extendMotor, intakeMotor;

    private Servo launchServo, grabServo;
    public Servo wristServo;
    private double servoSlush = 0;

    public ArmSubsystem(HardwareMap hardwareMap) {

        armConstants = new ArmConstants();

        pivotMotor = hardwareMap.get(DcMotor.class, "pivotMotor");
        extendMotor = hardwareMap.get(DcMotor.class, "extendMotor");
        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
        grabServo = hardwareMap.get(Servo.class, "grabServo");
        launchServo = hardwareMap.get(Servo.class, "airplaneServo");
        wristServo = hardwareMap.get(Servo.class, "wristServo");

        pivotMotor.setPower(0);
        extendMotor.setPower(0);
        intakeMotor.setPower(0);
    }

    public void extendM(double power) {
        extendMotor.setPower(power);
    }

    public void pivotM(double power) {
        pivotMotor.setPower(power);
    }

    public void intakeM(double power) {
        intakeMotor.setPower(power);
    }

    public void airplaneLaunch() {
        launchServo.setPosition(0);
    }

    public void grabOpen() {
        grabServo.setPosition(0);
    }

    public void grabClose() {
        grabServo.setPosition(1);
    }

    public void wristGrab(){
        wristServo.setPosition(ArmConstants.PSC.PICKUP_IN);
    }

    public void wristScore(){
        wristServo.setPosition(ArmConstants.PSC.SCORE);
    }
   }