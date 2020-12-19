package org.c243sachse.use.robot;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

public class RingLoader {
    private DcMotorEx ringLift;
    private Servo ringClamp;

    public RingLoader(DcMotorEx ringLift, Servo ringClamp) {
        this.ringLift = ringLift;
        this.ringClamp = ringClamp;
    }

    public int getLiftPosition() {
        return ringLift.getCurrentPosition();
    }
}
