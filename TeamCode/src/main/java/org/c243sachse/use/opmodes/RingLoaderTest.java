package org.c243sachse.use.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.c243sachse.use.robot.RingLoader;
import org.c243sachse.use.robot.RobotHardware;

@TeleOp(name = "RingLoaderTest", group = "Kirk")
public class RingLoaderTest extends OpMode {
    RobotHardware robotHardware;
    RingLoader loader;

    @Override
    public void init() {
        robotHardware = RobotHardware.getInstance(hardwareMap);
        loader = robotHardware.getLoader();

    }

    @Override
    public void loop() {
        telemetry.addData("Lift Position", loader.getLiftPosition());
        robotHardware.reportUptime(telemetry);
    }
}
