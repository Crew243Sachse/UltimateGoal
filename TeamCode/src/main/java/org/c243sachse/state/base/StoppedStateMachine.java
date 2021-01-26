package org.c243sachse.state.base;

import org.c243sachse.hardware.UpdatingSystem;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class StoppedStateMachine implements StateMachine {
    private final UpdatingSystem system;

    public StoppedStateMachine(UpdatingSystem system){
        this.system = system;
    }

    @Override
    public StateMachine update(Telemetry telemetry) {
        telemetry.addLine("autonomous complete");
        telemetry.addLine();
        telemetry.addLine("^^^^^^^^^^^^^^^^");
        return this;
    }

    @Override
    public StateMachine addNext(StateMachine next) {
        return this;
    }

    @Override
    public void start() {
    }
}
