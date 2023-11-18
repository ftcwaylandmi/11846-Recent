package teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import teamcode.Susbsystems.ArmSubsystem;
import teamcode.Susbsystems.MecanumSubsystem;
import teamcode.Susbsystems.SensorSubsystem;

@TeleOp(name = "TeleOpMain", group = "TeleOp")
public class TeleopB extends OpMode {
    MecanumSubsystem mecanumSubsystem;
    ArmSubsystem armSubsystem;

    @Override
    public void init(){
        mecanumSubsystem = new MecanumSubsystem(hardwareMap);
        armSubsystem = new ArmSubsystem(hardwareMap);
    }

    @Override
    public void loop() {

        double forward = -gamepad1.left_stick_y;
        double turn = -gamepad1.right_stick_x;
        double strafe = -gamepad1.left_stick_x;
        double extend = -gamepad2.left_stick_y;
        double pivot = gamepad2.right_stick_y;
        double intake = gamepad1.right_trigger;

        armSubsystem.intakeM(intake);
        armSubsystem.extendM(extend);
        armSubsystem.pivotM(pivot);
        mecanumSubsystem.Forward(forward);
        mecanumSubsystem.Turn(turn);
        mecanumSubsystem.Strafe(strafe);

        if(gamepad2.dpad_left){
            armSubsystem.airplaneLaunch();
        }else if(gamepad2.right_bumper){
            armSubsystem.grabOpen();
        }else if(gamepad2.left_bumper){
            armSubsystem.grabClose();
        }else if(gamepad2.dpad_left){
            armSubsystem.increaseSlush((int) 0.1);
            armSubsystem.wristUp();
        }else if(gamepad2.dpad_down){
            armSubsystem.increaseSlush((int) -0.1);
            armSubsystem.wristDown();
        }
    }

}