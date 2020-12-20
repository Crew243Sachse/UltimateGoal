package org.c243sachse.state;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class CompletedState implements StateMachine {
    @Override
    public StateMachine update(Telemetry telemetry) {
        telemetry.addLine("All states completed");
        return this;
    }

    @Override
    public StateMachine addNext(StateMachine next) {
        throw new UnsupportedOperationException("No additional states may follow this state");

    }

    @Override
    public void start() { }
}
