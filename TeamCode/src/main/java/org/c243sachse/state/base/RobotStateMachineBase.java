package org.c243sachse.state.base;

import org.c243sachse.hardware.Robot;

public abstract class RobotStateMachineBase extends StateMachineBase {
    protected final Robot robot;

    protected RobotStateMachineBase(Robot robot) {
        super(robot);
        this.robot = robot;
    }
}
