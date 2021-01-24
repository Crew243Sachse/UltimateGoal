package org.c243sachse.hardware;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot implements UpdatingSystem {
    private static Robot instance;
    public final Drive drive;
    public final Shooter shooter;
    public final WobbleLift wobbleLift;
    private final long startTime;

    private Robot(HardwareMap hardwareMap){
        drive = new Drive(hardwareMap);
        shooter = new Shooter(hardwareMap);
        wobbleLift = new WobbleLift(hardwareMap);
        startTime = System.currentTimeMillis() / 1000;
    }

    public static Robot getInstance(HardwareMap hardwareMap){
        if (instance == null){
            instance = new Robot(hardwareMap);
        }
        return instance;
    }

    @Override
    public void updateSystem(Telemetry telemetry) {
        drive.updateSystem(telemetry);
        shooter.updateSystem(telemetry);
        wobbleLift.updateSystem(telemetry);
        telemetry.addLine();
        telemetry.addLine();
        long current = System.currentTimeMillis() / 1000;
        long min = current / 60;
        long sec = current % 60;
        telemetry.addData("uptime", String.format("%d:%d", min, sec));
    }
}
