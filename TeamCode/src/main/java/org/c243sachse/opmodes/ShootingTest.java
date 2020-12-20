package org.c243sachse.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.c243sachse.hardware.Shooter;

@TeleOp(name = "Shooting Test")
public class ShootingTest extends OpMode {
    private Shooter shooter;

    @Override
    public void init() {
        shooter = new Shooter(hardwareMap);
    }

    @Override
    public void start() {
        super.start();
        shooter.arm();
    }

    @Override
    public void loop() {
        if (gamepad1.a) shooter.fire();
        if (gamepad1.dpad_up) shooter.arm();
        if (gamepad1.dpad_down) shooter.disarm();
        shooter.updateSystem(telemetry);
    }
}
