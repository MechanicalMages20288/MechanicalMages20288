package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "TestingEncoder", group = "TeleOp")

public class TestingEncoder extends OpMode{

    static final int MOTOR_TICK_COUNTS = 751;

    Servo bucket;
    DcMotor right_drive;
    DcMotor left_drive;
    DcMotor back_right_drive;
    DcMotor back_left_drive;
    DcMotor Intake;
    DcMotor Slide;
    DcMotor Caro;


    double left_drivePower;
    double right_drivePower;
    double back_right_drivePower;
    double back_left_drivePower;


    @Override
    public void init() {
        left_drive = hardwareMap.dcMotor.get("left_drive");
        right_drive = hardwareMap.dcMotor.get("right_drive");
        back_right_drive = hardwareMap.dcMotor.get("back_right_drive");
        back_left_drive = hardwareMap.dcMotor.get("back_left_drive");
        right_drive.setDirection(DcMotor.Direction.REVERSE);
        back_right_drive.setDirection(DcMotor.Direction.REVERSE);
        Intake = hardwareMap.dcMotor.get("Intake");

        bucket = hardwareMap.servo.get("bucket");
        Slide = hardwareMap.dcMotor.get("Slide");
        Caro = hardwareMap.dcMotor.get("Caro");
    }

    @Override
    public void loop() {


        //Movement Controller
        right_drivePower = gamepad1.right_stick_y;
        back_left_drivePower = gamepad1.right_stick_y;
        left_drivePower = gamepad1.left_stick_y;
        back_right_drivePower = gamepad1.left_stick_y;

        left_drive.setPower(left_drivePower);
        right_drive.setPower(right_drivePower);
        back_left_drive.setPower(left_drivePower);
        back_right_drive.setPower(right_drivePower);

        //core drive
        boolean rightbumper = gamepad1.right_bumper;
        boolean leftbumper = gamepad1.left_bumper;
        //attachments
        boolean leftbumper1 = gamepad2.left_bumper;
        boolean rightbumper1 = gamepad2.right_bumper;

        //boolean rightBumper = gamepad2.right_bumper;
        if (leftbumper) {
            left_drive.setPower(1); // left drive is 0
            right_drive.setPower(-1); // right drive is 2
            back_left_drive.setPower(-1); // back left drive is 1
            back_right_drive.setPower(1); // back right drive is 3
        } else if (rightbumper) {
            left_drive.setPower(-1);
            right_drive.setPower(1);
            back_left_drive.setPower(1);
            back_right_drive.setPower(-1);
        }



        /*
        if (rightbumper) {
            Slide.setPower(0.5);
            Slide.getCurrentPosition();



        } if (rightbumper) {
            Intake.setPower(-1);
        } else if (rightbumper) {
            Intake.setPower(0);
        }   */



















        telemetry.addData("Encoder value", Slide.getCurrentPosition());
        telemetry.update();

     while (leftbumper1)   {
        if (Slide.getCurrentPosition() > 1630) {
            Slide.setPower(0.01);
        }

        else;
            continue;

        }

        if (rightbumper1) {
            Slide.setPower(0.5);
            Slide.getCurrentPosition();
            telemetry.update();


        } else if (leftbumper1) {
            Slide.setPower(-0.5);
            Slide.getCurrentPosition();
        } else {
            Slide.setPower(0);
        }

/*
        if(leftbumper == ON_RELEASE{
            relicExtMotors[0].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            relicExtMotors[0].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            MAX_EXTENSION_LIMIT = (int) (MAX_EXTENSION_REVS * TICKS_PER_REV);
            MIN_EXTENSION_LIMIT = (int) (MIN_EXTENSION_REVS * TICKS_PER_REV);


*/










            if (gamepad2.x) {
            bucket.setPosition(0.05);
        } else if (rightbumper1) {
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bucket.setPosition(.5);
        }else if (leftbumper1){
            bucket.setPosition(.80);










        }
    }




























}
