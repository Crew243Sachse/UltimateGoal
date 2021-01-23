package org.c243sachse.opmodes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.c243sachse.hardware.Shooter;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@TeleOp(name = "Drive and Shoot")
public class DriveAndShoot extends OpMode {
    //private SampleMecanumDrive drive;
    private Shooter shooter;

    @Override
    public void init() {
        //drive = new SampleMecanumDrive(hardwareMap);
        shooter = new Shooter(hardwareMap);
    }

    @Override
    public void loop() {
        updateShooter();
        updateDrive();
        telemetry.update();
    }

    private void updateDrive() {
//        drive.setWeightedDrivePower(
//                new Pose2d(
//                        -gamepad1.left_stick_y,
//                        -gamepad1.left_stick_x,
//                        -(gamepad1.right_stick_x / 4)
//                )
//        );
//
//        drive.update();
//
//        Pose2d poseEstimate = drive.getPoseEstimate();
//        telemetry.addData("x", poseEstimate.getX());
//        telemetry.addData("y", poseEstimate.getY());
//        telemetry.addData("heading", poseEstimate.getHeading());
    }

    private void updateShooter() {
        if (gamepad1.a) shooter.fire();
        if (gamepad1.dpad_up) shooter.arm();
        if (gamepad1.dpad_down) shooter.disarm();
        shooter.updateSystem(telemetry);
    }
}
