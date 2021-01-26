package org.c243sachse.state.base;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public abstract class StateMachineOpModeBase extends OpMode {
    protected StateMachine stateMachine;

    @Override
    public void start() {
        stateMachine.start();
    }

    @Override
    public void loop() {
        stateMachine = stateMachine.update(telemetry);
    }
}
