package org.c243sachse.subsystems.shooter;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class TeleopShooter extends ShooterSubsystem {
    private final Gamepad pad;

    public TeleopShooter(HardwareMap hardwareMap, Gamepad gamepad) {
        super(hardwareMap);
        pad = gamepad;
    }

    @Override
    public void update(Telemetry telemetry) {
        super.update(telemetry);
        if (!isShooting() && pad.a){
            fire();
        }
    }
}
