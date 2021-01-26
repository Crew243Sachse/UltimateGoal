package org.c243sachse.state.base;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Interface to define how one will interact with the state. An interface was chosen
 * so that one could interchange with different base classes.
 */
public interface StateMachine {
    /**
     * Provides a means to update the telemetry and should be called each loop.
     * Though less then ideal - two things actually will occur in this method,
     * the telemetry will be populated, and the state will be checked and next one
     * passed if the state is complete.
     *
     * @param telemetry
     * @return This will be the current operational DriveState. If the current
     * state is complete, then it should call the next state's "start()" method
     * and return the next state.
     */
    StateMachine update(Telemetry telemetry);

    /**
     * This provides a means to chain states together. It should only be called
     * within the "init()" method of the OpMode. The intent here is that a "Fluent"
     * interface. The method should return the state that was passed in after storing
     * it internally.
     *
     * @param next
     * @return the instance that is passed into the method.
     */
    StateMachine addNext(StateMachine next);

    /**
     * The initial state will have this method called in the "start()" method.
     * Additionally when a state completes, it should call this method on the next
     * state.
     */
    void start();
}
