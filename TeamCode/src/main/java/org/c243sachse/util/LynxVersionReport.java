package org.c243sachse.util;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.List;

public class LynxVersionReport {
    private List<LynxModule> modules;

    public LynxVersionReport(HardwareMap hardwareMap){
        modules = hardwareMap.getAll(LynxModule.class);
    }

    public void report(Telemetry telemetry) {
        telemetry.addLine("Lynx Modules");
        for (LynxModule module: modules){
            telemetry.addData(module.getDeviceName(), module.getNullableFirmwareVersionString());
        }
    }
}
