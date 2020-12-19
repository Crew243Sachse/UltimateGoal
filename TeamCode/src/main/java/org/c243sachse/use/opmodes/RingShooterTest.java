package org.c243sachse.use.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.c243sachse.use.robot.RingShooter;
import org.c243sachse.use.robot.RobotHardware;

@TeleOp(name = "RingShooterTest", group = "Kirk")
public class RingShooterTest extends OpMode {
    RobotHardware robotHardware;
    RingShooter shooter;

    @Override
    public void init() {
        robotHardware = RobotHardware.getInstance(hardwareMap);
        shooter = robotHardware.getShooter();
    }

//    @Override
//    public void start() {
//        super.start();
//        shooter.startShooter();
//    }
//
//    @Override
//    public void stop() {
//        super.stop();
//        shooter.stopShooter();
//    }

    @Override
    public void loop() {
        shooter.update();

        if (gamepad1.dpad_up) shooter.startShooter();
        if (gamepad1.dpad_down) shooter.stopShooter();
        if (gamepad1.dpad_right) shooter.shoot();

        robotHardware.reportUptime(telemetry);
    }
}
