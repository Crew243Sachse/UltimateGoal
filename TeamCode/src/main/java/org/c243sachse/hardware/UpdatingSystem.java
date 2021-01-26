package org.c243sachse.hardware;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public interface UpdatingSystem {
    void updateSystem(Telemetry telemetry);
    boolean isBusy();
}
