package org.c243sachse.state;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public interface StateMachine {
    StateMachine update(Telemetry telemetry);
    StateMachine addNext(StateMachine next);
    void start();
}
