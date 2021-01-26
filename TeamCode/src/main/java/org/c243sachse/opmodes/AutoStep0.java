package org.c243sachse.opmodes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "position")
public class AutoStep0 extends CrewOpModeBase {
    @Override
    public void start() {
        super.start();
        Trajectory trajectory = robot.drive.trajectoryBuilder(new Pose2d())
//                .splineTo(new Vector2d(25, -6), 0)
                .lineTo(new Vector2d(26, 11))
                .build();
        robot.drive.followTrajectoryAsync(trajectory);
        robot.shooter.arm();
    }

    @Override
    public void loop() {
        super.loop();
        updateShooter();
    }
}
