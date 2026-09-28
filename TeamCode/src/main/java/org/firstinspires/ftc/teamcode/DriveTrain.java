package org.firstinspires.ftc.teamcode;

import static java.lang.Thread.sleep;


import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveTrain {

    // Declare the 4 drive motors
    private DcMotorEx frontRightMotor = null;
    private DcMotorEx frontLeftMotor = null;
    private DcMotorEx backRightMotor = null;
    private DcMotorEx backLeftMotor = null;
    private HardwareMap config = null;


    public DriveTrain (HardwareMap inputConfig)
    {
        config = inputConfig;

        //TODO: rename config elements
        frontRightMotor = config.get (DcMotorEx.class, "frontRightMotor");
        frontLeftMotor = config.get (DcMotorEx.class, "frontLeftMotor");
        backRightMotor = config.get (DcMotorEx.class, "backRightMotor");
        backLeftMotor = config.get (DcMotorEx.class, "backLeftMotor");

        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        backRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        frontLeftMotor.setPower(0);
        backLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backRightMotor.setPower(0);

    }

    //Drive function using joystick commands
    public void Drive (double leftStick_y, double leftStick_x, double rightStick_x)
    {
        double jy = leftStick_y * leftStick_y * leftStick_y; // Remember, Y stick value is reversed
        double jx = -leftStick_x * -leftStick_x * -leftStick_x * 1.1; // Counteract imperfect strafing
        double rx = rightStick_x * rightStick_x * rightStick_x * 0.75; // Decrease rotation sensitivity

        double denominator = Math.max(Math.abs(jy) + Math.abs(jx) + Math.abs(rx), 1);
        double frontLeftPower  = (jy + jx + rx) / denominator;
        double backLeftPower   = (jy - jx + rx) / denominator;
        double frontRightPower = (jy - jx - rx) / denominator;
        double backRightPower  = (jy + jx - rx) / denominator;

        frontLeftMotor.setPower(frontLeftPower);
        backLeftMotor.setPower(backLeftPower);
        frontRightMotor.setPower(frontRightPower);
        backRightMotor.setPower(backRightPower);
    }

    // Example of function override using autocode from last year
    public void Drive (double rightFrontMotorPower, double backRightMotorPower, double frontLeftMotorPower, double backLeftMotorPower, long time_ms) throws InterruptedException {

        frontLeftMotor.setPower(frontLeftMotorPower);
        backLeftMotor.setPower(backLeftMotorPower);
        frontRightMotor.setPower(rightFrontMotorPower);
        backRightMotor.setPower(backRightMotorPower);
        sleep(time_ms);
        frontLeftMotor.setPower(0);
        backLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backRightMotor.setPower(0);
    }
}
