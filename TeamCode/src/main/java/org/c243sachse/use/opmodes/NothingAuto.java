package org.c243sachse.use.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.c243sachse.use.robot.RobotHardware;

@Autonomous(name = "NothingAuto", group = "Kirk")
public class NothingAuto extends OpMode {
    RobotHardware hardware;

    @Override
    public void init() {
        hardware = RobotHardware.getInstance(hardwareMap);
    }

    @Override
    public void loop() {
        hardware.reportUptime(telemetry);
    }
}
