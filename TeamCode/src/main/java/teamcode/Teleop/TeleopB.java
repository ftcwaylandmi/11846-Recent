package teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import teamcode.Susbsystems.ArmSubsystem;
import teamcode.Susbsystems.MecanumSubsystem;
import teamcode.Susbsystems.SensorSubsystem;

@TeleOp
public class TeleopB extends OpMode {

    ArmSubsystem armSubsystem;
    MecanumSubsystem mecanumSubsystem;

    public void init(){
        armSubsystem = new ArmSubsystem(hardwareMap);
        mecanumSubsystem = new MecanumSubsystem(hardwareMap);
    }

    @Override
    public void loop(){

        double pivot = gamepad2.left_stick_y;
        double extend = gamepad2.right_stick_y;
        double intake = gamepad2.right_trigger;

        armSubsystem.pivotM(pivot);
        armSubsystem.extendM(extend);
        armSubsystem.intake(intake);

        if(gamepad2.a){
            armSubsystem.launch();
        }else if(gamepad2.y){
            armSubsystem.grabPixel();
        }else if(gamepad2.b){
            armSubsystem.releasePixel();
        }else if(gamepad2.dpad_up){
            armSubsystem.scorePixelWrist();
        }else if(gamepad2.dpad_down){
            armSubsystem.grabPixelWrist();
        }
    }
}
