package org.c243sachse;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.c243sachse.hardware.Shooter;

@TeleOp(name = "Shooting Dev")
public class ShooterDev extends OpMode {
    Shooter shooter;

    @Override
    public void init() {
        shooter = new Shooter(hardwareMap);
    }

    @Override
    public void loop() {
        shooter.updateSystem(telemetry);
        if (gamepad1.a){
            shooter.fire();
        }
    }
}
