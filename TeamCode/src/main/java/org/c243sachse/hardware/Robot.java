package org.c243sachse.hardware;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot implements UpdatingSystem {
    public final Drive drive;
    public final Shooter shooter;
    public final WobbleLift wobbleLift;

    public Robot(HardwareMap hardwareMap){
        drive = new Drive(hardwareMap);
        shooter = new Shooter(hardwareMap);
        wobbleLift = new WobbleLift(hardwareMap);
    }

    @Override
    public void updateSystem(Telemetry telemetry) {
        drive.updateSystem(telemetry);
        shooter.updateSystem(telemetry);
        wobbleLift.updateSystem(telemetry);
    }
}
