package org.c243sachse.opmodes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.c243sachse.hardware.Shooter;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

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

    private void updateShooter() {
        if (gamepad1.a) robot.shooter.fire();
        if (gamepad1.dpad_up) robot.shooter.arm();
        if (gamepad1.dpad_down) robot.shooter.disarm();
        robot.shooter.updateSystem(telemetry);
    }
}
