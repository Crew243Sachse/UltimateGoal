package org.c243sachse.use.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.c243sachse.use.robot.RobotHardware;
import org.c243sachse.use.robot.TeleopHolonomic;

@TeleOp(name = "Drive Test", group = "Kirk")
public class TeleDrive extends OpMode {
    private RobotHardware robotHardware;
    private TeleopHolonomic drive;

    @Override
    public void init() {
        robotHardware = RobotHardware.getInstance(hardwareMap);
        drive = robotHardware.getTeleDrive();
    }

    @Override
    public void loop() {
        drive.drive(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
    }
}
