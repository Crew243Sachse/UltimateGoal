package org.c243sachse.state;

import org.c243sachse.hardware.Robot;
import org.c243sachse.state.base.RobotStateMachineBase;

public class ShootingState extends RobotStateMachineBase {
    public ShootingState(Robot robot) {
        super(robot);
    }

    @Override
    public void start() {
        robot.shooter.fire();
    }
}
