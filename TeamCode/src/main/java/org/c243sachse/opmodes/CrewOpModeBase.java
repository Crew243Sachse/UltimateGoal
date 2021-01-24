package org.c243sachse.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.c243sachse.hardware.Robot;
import org.c243sachse.util.LynxVersionReport;

public abstract class CrewOpModeBase extends OpMode {
    private LynxVersionReport lynxVersionReport;
    protected Robot robot;

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
}
