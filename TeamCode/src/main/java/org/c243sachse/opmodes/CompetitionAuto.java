package org.c243sachse.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.c243sachse.hardware.Robot;
import org.c243sachse.state.MoveToShootingPositionState;
import org.c243sachse.state.ShootingState;
import org.c243sachse.state.base.StateMachineOpModeBase;

@Disabled()
@Autonomous(name = "Competition")
public class CompetitionAuto extends StateMachineOpModeBase {
    @Override
    public void init() {
        Robot robot = Robot.getInstance(hardwareMap);
        stateMachine = new MoveToShootingPositionState(robot)
                .addNext(new ShootingState(robot))
                .addNext(new ShootingState(robot))
                .addNext(new ShootingState(robot));
    }
}
