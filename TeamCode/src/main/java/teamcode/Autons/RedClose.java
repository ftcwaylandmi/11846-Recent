package teamcode.Autons;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.checkerframework.checker.units.qual.A;

import teamcode.Susbsystems.ArmSubsystem;
import teamcode.Susbsystems.MecanumSubsystem;
import teamcode.Susbsystems.SensorSubsystem;

@Autonomous
public class RedClose extends LinearOpMode {

    MecanumSubsystem mecanumSubsystem;
    ArmSubsystem armSubsystem;
    SensorSubsystem sensorSubsystem;
@Override
    public void runOpMode() throws InterruptedException{
        mecanumSubsystem = new MecanumSubsystem(hardwareMap);
        armSubsystem = new ArmSubsystem(hardwareMap);
        sensorSubsystem = new SensorSubsystem(hardwareMap);

        waitForStart();

        mecanumSubsystem.ForwardA(1,20);
        sensorSubsystem.GetColor();
        if(sensorSubsystem.GetColor() == 2){
            mecanumSubsystem.ForwardA(1,5);
        }else if(sensorSubsystem.GetColor() == 1){
            mecanumSubsystem.ForwardA(-1,10);
        }
    }

}
