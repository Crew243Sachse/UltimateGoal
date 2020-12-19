package org.c243sachse.use.robot;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

import org.c243sachse.use.utils.RunClock;

public class RingShooter {
    private double shootPower = 0.5;
    private double shootOpen = .35;

    private DcMotorEx flywheel;
    private Servo ringShooter;
    private long flywheelStartTime, shootStartTime;
    private RunClock clock = new RunClock();

    public RingShooter(DcMotorEx flywheel, Servo ringShooter) {
        this.flywheel = flywheel;
        this.ringShooter = ringShooter;
    }

    public void startShooter() {
        ringShooter.setPosition(0);
        flywheel.setPower(shootPower);
        flywheelStartTime = clock.seconds();
    }

    public void stopShooter() {
        ringShooter.setPosition(0);
        flywheel.setPower(0);
        flywheelStartTime = 0;
    }

    public void shoot() {
        if (isRunning() || isShooting()) {
            return;
        }
        ringShooter.setPosition(shootOpen);
        shootStartTime = clock.milliSeconds();
    }

    public void update() {
        long current = clock.milliSeconds();
        if (shootStartTime == 0) return;

        if (shootStartTime + 250 < current && ringShooter.getPosition() > .2) {
            ringShooter.setPosition(0);
            return;
        }

        if (shootStartTime + 500 < current) {
            shootStartTime = 0;
        }
    }

    public boolean isRunning() {
        return flywheelStartTime + 1 < clock.seconds();
    }

    public boolean isShooting() {
        return shootStartTime > 0;
    }
}
