package org.c243sachse.hardware;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Shooter implements UpdatingSystem {
    private final Servo feed;
    private long shootTime = -1;

    public Shooter(HardwareMap map){
        feed = map.get(Servo.class, "ringFeed");
    }

    @Override
    public void update(Telemetry telemetry) {
        if (System.currentTimeMillis() > shootTime) {
            feed.setPosition(0);
            shootTime = -1;
        }
    }

    public void fire(){
        if (shootTime == -1){
            shootTime = System.currentTimeMillis() + 5000;
            feed.setPosition(.4);
        }
    }
}
