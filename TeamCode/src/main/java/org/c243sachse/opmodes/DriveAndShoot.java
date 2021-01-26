package org.c243sachse.opmodes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.c243sachse.opmodes.base.CrewOpModeBase;

@TeleOp(name = "Drive and Shoot")
public class DriveAndShoot extends CrewOpModeBase {

    @Override
    public void loop() {
        updateShooter();
        updateDrive();
        robot.updateSystem(telemetry);
    }

    private void updateDrive() {
        robot.drive.setWeightedDrivePower(
                new Pose2d(
                        -gamepad1.left_stick_y,
                        -gamepad1.left_stick_x,
                        -(gamepad1.right_stick_x / 4)
                )
        );
    }
}
