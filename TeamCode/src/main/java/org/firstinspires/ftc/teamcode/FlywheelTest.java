package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class FlywheelTest {

    DcMotor motor;

    boolean aPressed = false;
    boolean flywheelOn = false;
    public FlywheelTest (HardwareMap hardwareMap) {

    }

    public void flywheelManualControl (Gamepad gamepad1) {

        // Set variables
        if (gamepad1.a) {
            if (!aPressed) {
                flywheelOn = !flywheelOn;
            }
            aPressed = true;
        }
        else {
            aPressed = false;
        }

        // Set motor
        if (flywheelOn){
            motor.setPower(1);
        }
        else {
            motor.setPower(0);
        }
    }
}
