package org.c243sachse.opmodes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.c243sachse.opmodes.base.CrewOpModeBase;

@TeleOp(name = "Drive and Shoot")
public class DriveAndShoot extends CrewOpModeBase {
    private final double moveScale = .6;
    private final double rotateScale = .3;

    @Override
    public void loop() {
        updateShooter();
        updateDrive();
        robot.updateSystem(telemetry);
    }

    private void updateDrive() {
        
        robot.drive.setWeightedDrivePower(
                new Pose2d(
                        (gamepad1.right_stick_x * moveScale),
                        (gamepad1.right_stick_y * moveScale),
                        -(gamepad1.left_stick_x * rotateScale)
                )
        );
    }
}
