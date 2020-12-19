package org.c243sachse.use.robot;

import com.qualcomm.robotcore.hardware.DcMotorEx;

public class TeleopHolonomic {

    private DcMotorEx leftFront;
    private DcMotorEx leftRear;
    private DcMotorEx rightRear;
    private DcMotorEx rightFront;
    private HeadingTracker heading;

    public TeleopHolonomic(DcMotorEx leftFront,
                           DcMotorEx leftRear,
                           DcMotorEx rightRear,
                           DcMotorEx rightFront,
                           HeadingTracker heading){
        this.leftFront = leftFront;
        this.leftRear = leftRear;
        this.rightRear = rightRear;
        this.rightFront = rightFront;
        this.heading = heading;
    }

    public void drive(double x, double y, double rotate) {
        double powerRotate = rotate / 4;
        double scale = Math.sqrt(Math.pow(1-Math.abs(powerRotate), 2)/2);
        x = x * scale;
        y = y * scale;

        double gyroAngle = getScaledHeading();
        double theta = Math.atan2(y, x) - gyroAngle - (Math.PI / 2);
        scale = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        double powerX = scale * (Math.sin(theta + Math.PI / 4));
        double powerY = scale * (Math.sin(theta - Math.PI / 4));

        leftFront.setPower(powerY - powerRotate);
        leftRear.setPower(powerX - powerRotate);
        rightRear.setPower(powerY + powerRotate);
        rightFront.setPower(powerX + powerRotate);
    }

    public double getScaledHeading(){
        double gyroAngle = heading.getHeadingRadians();
        if (gyroAngle <= 0) {
            gyroAngle = gyroAngle + (Math.PI / 2);
        } else if (0 < gyroAngle && gyroAngle < Math.PI / 2) {
            gyroAngle = gyroAngle + (Math.PI / 2);
        } else if (Math.PI / 2 <= gyroAngle) {
            gyroAngle = gyroAngle - (3 * Math.PI / 2);
        }
        return  -1 * gyroAngle;
    }
}
