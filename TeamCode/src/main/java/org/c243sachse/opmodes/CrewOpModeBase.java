package org.c243sachse.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.c243sachse.hardware.Robot;
import org.c243sachse.util.LynxVersionReport;

public abstract class CrewOpModeBase extends OpMode {
    private LynxVersionReport lynxVersionReport;
    protected Robot robot;
    protected double forwardRatio = 16/11;

    protected void updateShooter() {
        if (gamepad1.a) robot.shooter.fire();
        if (gamepad1.dpad_up) robot.shooter.arm();
        if (gamepad1.dpad_down) robot.shooter.disarm();
        robot.shooter.updateSystem(telemetry);
    }

    @Override
    public void init() {
        lynxVersionReport = new LynxVersionReport(hardwareMap);
        robot = Robot.getInstance(hardwareMap);
    }

    @Override
    public void init_loop() {
        lynxVersionReport.report(telemetry);
        telemetry.addLine();
        telemetry.addLine("--------------");
        telemetry.addLine();
        super.init_loop();
    }

    @Override
    public void loop() {
        robot.updateSystem(telemetry);
    }
}
