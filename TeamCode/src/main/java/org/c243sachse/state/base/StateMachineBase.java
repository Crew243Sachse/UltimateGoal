package org.c243sachse.state.base;

import org.c243sachse.hardware.UpdatingSystem;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public abstract class StateMachineBase implements StateMachine {
    private final UpdatingSystem system;
    private StateMachine next;

    protected StateMachineBase(UpdatingSystem system){
        this.system = system;
        next = new StoppedStateMachine(system);
    }

    @Override
    public StateMachine update(Telemetry telemetry) {
        system.updateSystem(telemetry);
        if (system.isBusy()){
            return this;
        }
        next.start();
        return next;
    }

    @Override
    public StateMachine addNext(StateMachine next) {
        this.next = next;
        return next;
    }
}
