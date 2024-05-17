package org.firstinspires.ftc.teamcode.tuning;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.TankDrive;

@Autonomous(name = "twoplusfifty", group = "00-Autonomous")
public final class twoplusfifty extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        if (TuningOpModes.DRIVE_CLASS.equals(MecanumDrive.class)) {
            MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));

            waitForStart();
//new updates to run movements
            Actions.runBlocking(

                    drive.actionBuilder(new Pose2d(-36.07, -59.13, Math.toRadians(0.00)))
                            .splineTo(new Vector2d(-36.07, -32.98), Math.toRadians(90.00))
                            .splineTo(new Vector2d(29.23, -10.86), Math.toRadians(0.00))
                            .splineTo(new Vector2d(46.79, -36.74), Math.toRadians(0.00))
                            .splineTo(new Vector2d(37.94, -37.81), Math.toRadians(200.69))
                            .splineTo(new Vector2d(13.27, -59.80), Math.toRadians(183.37))
                            .splineTo(new Vector2d(-36.34, -56.98), Math.toRadians(176.75))
                            .splineTo(new Vector2d(-61.14, -35.66), Math.toRadians(180.00))
                            .splineTo(new Vector2d(-28.96, -11.66), Math.toRadians(8.38))
                            .splineTo(new Vector2d(36.87, -8.85), Math.toRadians(3.37))
                            .splineTo(new Vector2d(46.53, -34.86), Math.toRadians(-65.27))
                            .splineTo(new Vector2d(47.60, -27.89), Math.toRadians(-80.31))
                            .build());




        } else if (TuningOpModes.DRIVE_CLASS.equals(TankDrive.class)) {
            TankDrive drive = new TankDrive(hardwareMap, new Pose2d(0, 0, 0));

            waitForStart();

            Actions.runBlocking(
                    drive.actionBuilder(drive.pose)
                            .splineTo(new Vector2d(30, 30), Math.PI / 2)
                            .splineTo(new Vector2d(60, 0), Math.PI)
                            .build());
        } else {
            throw new RuntimeException();
        }
    }
}
