package org.c243sachse;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.c243sachse.subsystems.shooter.TeleopShooter;

@TeleOp(name = "Shooting Dev")
public class ShootingDevelopment extends OpMode {
    private TeleopShooter shooter;
    private boolean firePressed = false;

    @Override
    public void init() {
        shooter = new TeleopShooter(hardwareMap, gamepad1);
    }

    @Override
    public void loop() {
        shooter.update(telemetry);
    }
}
