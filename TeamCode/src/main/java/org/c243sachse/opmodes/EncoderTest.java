package org.c243sachse.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import java.util.Arrays;
import java.util.List;

@TeleOp(name = "Encoder Test")
public class EncoderTest extends OpMode {
    private DcMotorEx leftFront, leftRear, rightRear, rightFront;
    private int leftFrontOffset, leftRearOffset, rightRearOffset, rightFrontOffset;
    private List<DcMotorEx> motors;

    @Override
    public void init() {
        leftFront = hardwareMap.get(DcMotorEx.class, "leftFront");
        leftRear = hardwareMap.get(DcMotorEx.class, "leftRear");
        rightRear = hardwareMap.get(DcMotorEx.class, "rightRear");
        rightFront = hardwareMap.get(DcMotorEx.class, "rightFront");

        motors = Arrays.asList(leftFront, leftRear, rightRear, rightFront);
        for (DcMotorEx motor : motors) {
            motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        }
    }

    @Override
    public void loop() {
        resetEncoders();
        sendTelemetry();
        testMotors();
    }

    private void testMotors() {
        if (gamepad1.dpad_up) {
            leftFront.setPower(0.25);
        } else {
            leftFront.setPower(0);
        }
        if (gamepad1.dpad_left) {
            leftRear.setPower(0.25);
        } else {
            leftRear.setPower(0);
        }
        if (gamepad1.dpad_down) {
            rightRear.setPower(0.25);
        } else {
            rightRear.setPower(0);
        }
        if (gamepad1.dpad_right) {
            rightFront.setPower(0.25);
        } else {
            rightFront.setPower(0);
        }
    }

    private void resetEncoders() {
        if (gamepad1.a) {
            leftFrontOffset = leftFront.getCurrentPosition();
            leftRearOffset = leftRear.getCurrentPosition();
            rightFrontOffset = rightFront.getCurrentPosition();
            rightRearOffset = rightRear.getCurrentPosition();
        }
    }

    private void sendTelemetry() {
        telemetry.addLine("Encoder Positions");

        telemetry.addData("Left Front", leftFront.getCurrentPosition() - leftFrontOffset);
        telemetry.addData("Left Rear", leftRear.getCurrentPosition() - leftRearOffset);
        telemetry.addData("Right Front", rightFront.getCurrentPosition() - rightFrontOffset);
        telemetry.addData("Right Rear", rightRear.getCurrentPosition() - rightRearOffset);
    }
}
