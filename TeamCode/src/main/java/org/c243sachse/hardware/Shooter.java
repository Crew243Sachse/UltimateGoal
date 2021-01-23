package org.c243sachse.hardware;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Shooter implements UpdatingSystem {
    private final double targetVelocity = 2200;
    private final DcMotorEx flywheel;
    private final Servo feed;
    private long shootTime = -1;

    public Shooter(HardwareMap map){
        feed = map.get(Servo.class, "ringFeed");
        flywheel = map.get(DcMotorEx.class, "flywheel");
    }

    @Override
    public void updateSystem(Telemetry telemetry) {
        if (System.currentTimeMillis() > shootTime && isArmed()) {
            feed.setPosition(0);
            shootTime = -1;
        }
    }

    public void fire(){
        if (shootTime == -1){
            arm();
            shootTime = System.currentTimeMillis() + 600;
            feed.setPosition(6);
        }
    }

    public void arm() {
        flywheel.setVelocity(targetVelocity);
    }

    public void disarm(){
        flywheel.setVelocity(0);
    }

    public boolean isArmed(){
        return flywheel.getVelocity() > targetVelocity - 100;
    }
}
