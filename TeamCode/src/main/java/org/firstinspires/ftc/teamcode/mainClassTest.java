package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class mainClassTest extends OpMode {

    DrivetrainTest drivetrainTest;

    @Override
    public void init() {
        drivetrainTest = new DrivetrainTest(hardwareMap);
    }

    @Override
    public void loop() {
        drivetrainTest.drive(gamepad1);
    }
}
