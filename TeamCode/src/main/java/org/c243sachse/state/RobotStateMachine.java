package org.c243sachse.state;

import org.c243sachse.hardware.Robot;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public abstract class RobotStateMachine implements StateMachine {
    private final Robot robot;
    protected StateMachine nextState;

    public RobotStateMachine(Robot robot){
        this.robot = robot;
    }

    @Override
    public StateMachine addNext(StateMachine next) {
        nextState = next;
        return nextState;
    }

    protected void updateRobot(Telemetry telemetry){
        robot.updateSystem(telemetry);
    }
}
