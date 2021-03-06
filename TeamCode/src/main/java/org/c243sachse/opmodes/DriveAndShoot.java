package org.c243sachse.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.c243sachse.opmodes.base.CrewOpModeBase;

//@Disabled()
@TeleOp(name = "Drive and Shoot")
public class DriveAndShoot extends CrewOpModeBase {
    private final double moveScale = 1;
    private final double rotateScale = 1;

    @Override
    public void loop() {
        updateShooter();
        updateDrive();
        robot.updateSystem(telemetry);
    }

    private void updateDrive() {
        robot.drive.driveFieldCentric(
                gamepad1.right_stick_x * moveScale,
                gamepad1.right_stick_y * moveScale,
                gamepad1.left_stick_x * rotateScale
        );
//        robot.drive.setWeightedDrivePower(
//                new Pose2d(
//                        (gamepad1.right_stick_x * moveScale),
//                        (gamepad1.right_stick_y * moveScale),
//                        -(gamepad1.left_stick_x * rotateScale)
//                )
//        );
    }
}
