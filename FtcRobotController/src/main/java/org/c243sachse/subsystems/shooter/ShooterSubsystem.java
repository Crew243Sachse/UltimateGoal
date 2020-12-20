package org.c243sachse.subsystems.shooter;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.c243sachse.subsystems.SubSystem;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ShooterSubsystem implements SubSystem {
    private final DcMotorEx flywheel;
    private final Servo feed;
    private long shootTime = -1;

    public ShooterSubsystem(HardwareMap hardwareMap){
        feed = hardwareMap.get(Servo.class, "ringFeed");
        flywheel = hardwareMap.get(DcMotorEx.class, "flywheel");
    }

    @Override
    public void update(Telemetry telemetry) {
        if (isShooting() && System.currentTimeMillis() > shootTime){
            feed.setPosition(0);
            shootTime = -1;
        }
        telemetry.addLine("Shooter");
        telemetry.addData("Flywheel", flywheel.getVelocity());
        telemetry.addData("Feed", feed.getPosition());
    }

    public void fire() {
        feed.setPosition(.5);
        shootTime = System.currentTimeMillis() + 1000;
    }

    public boolean isShooting() {
        return shootTime > 0;
    }
}
