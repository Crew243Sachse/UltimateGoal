package org.c243sachse.use.robot;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.VoltageSensor;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;

import org.c243sachse.use.utils.RunClock;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.LynxModuleUtil;

import java.util.Arrays;
import java.util.List;

public class RobotHardware {
    private static RobotHardware instance;

    private DcMotorEx leftFront, leftRear, rightRear, rightFront, flywheel, wobbleLift, ringLift;
    private Servo ringShooter, ringClamp, wobbleClamp;
    private BNO055IMU imu;
    private VoltageSensor batteryVoltageSensor;
    private RunClock clock = new RunClock();
    private HeadingTracker headingTracker;

    private RobotHardware(HardwareMap hardwareMap) {
        LynxModuleUtil.ensureMinimumFirmwareVersion(hardwareMap);

        for (LynxModule module : hardwareMap.getAll(LynxModule.class)) {
            module.setBulkCachingMode(LynxModule.BulkCachingMode.AUTO);
        }
        batteryVoltageSensor = hardwareMap.voltageSensor.iterator().next();

        // imu
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        imu.initialize(parameters);

        // motors
        setupMotors(hardwareMap);

        // servos
        ringShooter = hardwareMap.get(Servo.class, "ringShooter");
        ringClamp = hardwareMap.get(Servo.class, "ringClamp");
        wobbleClamp = hardwareMap.get(Servo.class, "wobbleClamp");

        headingTracker = new HeadingTracker(imu);
    }

    public static RobotHardware getInstance(HardwareMap map) {
        if (instance == null) {
            instance = new RobotHardware(map);
        }
        return instance;
    }

    public void reportUptime(Telemetry telemetry) {
        telemetry.addData("Uptime", clock.seconds());
    }

    public RingShooter getShooter() {
        return new RingShooter(flywheel, ringShooter);
    }

    public AutoMechanumDrive getAutoMechanumDrive() {
        return new AutoMechanumDrive(batteryVoltageSensor, imu, leftFront, leftRear, rightRear, rightFront);
    }

    public TeleopHolonomic getTeleDrive(){
        return new TeleopHolonomic(leftFront, leftRear, rightRear, rightFront, headingTracker);
    }

    public RingLoader getLoader() {
        return new RingLoader(ringLift, ringClamp);
    }

    public void resetHeading(){
        headingTracker.reset();
    }

    private void setupMotors(HardwareMap hardwareMap){
        leftFront = hardwareMap.get(DcMotorEx.class, "leftFront");
        leftRear = hardwareMap.get(DcMotorEx.class, "leftRear");
        rightRear = hardwareMap.get(DcMotorEx.class, "rightRear");
        rightFront = hardwareMap.get(DcMotorEx.class, "rightFront");

        flywheel = hardwareMap.get(DcMotorEx.class, "flywheel");
        ringLift = hardwareMap.get(DcMotorEx.class, "ringLift");
        wobbleLift = hardwareMap.get(DcMotorEx.class, "wobbleLift");

        List<DcMotorEx> motors = Arrays.asList(leftFront, leftRear, rightRear, rightFront, flywheel, ringLift, wobbleLift);

        for (DcMotorEx motor : motors) {
            MotorConfigurationType motorConfigurationType = motor.getMotorType().clone();
            motorConfigurationType.setAchieveableMaxRPMFraction(1.0);
            motor.setMotorType(motorConfigurationType);
            motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }

        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftRear.setDirection(DcMotor.Direction.REVERSE);
        rightFront.setDirection(DcMotor.Direction.FORWARD);
        rightRear.setDirection(DcMotor.Direction.FORWARD);
    }
}
