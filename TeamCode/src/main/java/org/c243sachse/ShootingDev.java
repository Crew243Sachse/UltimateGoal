package org.c243sachse;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@TeleOp(name = "Setup Shooter")
public class ShootingDev extends LinearOpMode {
    DcMotorEx flywheel;
    Servo shoot;

    @Override
    public void runOpMode() throws InterruptedException {

        flywheel = hardwareMap.get(DcMotorEx.class, "flywheel");
        flywheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        shoot = hardwareMap.get(Servo.class, "shoot");

        waitForStart();
        while (opModeIsActive()){
            if (gamepad1.b) {
                shoot.setPosition(.35);
                sleep(250);
                shoot.setPosition(0);
                sleep(2000);
            }
            if(gamepad1.x) {
                flywheel.setVelocity(4000 * 360, AngleUnit.DEGREES);
            }
            if (gamepad1.y) {
                flywheel.setVelocity(0, AngleUnit.DEGREES);
            }
        }
    }
}
