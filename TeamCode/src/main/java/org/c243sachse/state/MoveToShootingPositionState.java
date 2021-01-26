package org.c243sachse.state;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;

import org.c243sachse.hardware.Robot;
import org.c243sachse.state.base.RobotStateMachineBase;

public class MoveToShootingPositionState extends RobotStateMachineBase {
    public MoveToShootingPositionState(Robot robot) {
        super(robot);
    }

    @Override
    public void start() {
        Trajectory trajectory = robot.drive.trajectoryBuilder(new Pose2d())
                .lineTo(new Vector2d(26, 11))
                .build();
        robot.drive.followTrajectoryAsync(trajectory);
        robot.shooter.arm();
    }
}
