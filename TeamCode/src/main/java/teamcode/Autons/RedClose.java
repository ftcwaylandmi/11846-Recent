package teamcode.Autons;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.checkerframework.checker.units.qual.A;

import teamcode.Susbsystems.ArmSubsystem;
import teamcode.Susbsystems.MecanumSubsystem;
import teamcode.Susbsystems.SensorSubsystem;

@Autonomous(name = "RedClose", group = "Autons")
public class RedClose extends LinearOpMode {


    @Override
    public void runOpMode() throws InterruptedException {

        MecanumSubsystem drive = new MecanumSubsystem(hardwareMap);
        ArmSubsystem arm = new ArmSubsystem(hardwareMap);
        SensorSubsystem sensor = new SensorSubsystem(hardwareMap);

        if (isStopRequested()) return;


    }
}