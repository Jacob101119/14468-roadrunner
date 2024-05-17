package org.firstinspires.ftc.teamcode.tuning;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.TankDrive;

@Autonomous(name = "AutoTest4Corners", group = "00-Autonomous")
public final class AutoTest4Corners extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        if (TuningOpModes.DRIVE_CLASS.equals(MecanumDrive.class)) {
            MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));

            waitForStart();
//new updates to run movements
            Actions.runBlocking(



                            // path to go touch all four corners (start in bottom right corner center of tile (blue wing))

                            drive.actionBuilder(new Pose2d(-60.00, -60.00, Math.toRadians(0.00)))
                            .strafeToLinearHeading(new Vector2d(60.00, -60.00), Math.toRadians(-0.26))
                            .strafeToLinearHeading(new Vector2d(45.00, -60.00), Math.toRadians(180.00))
                            .strafeToLinearHeading(new Vector2d(21.18, 0.54), Math.toRadians(58.55))
                            .strafeToLinearHeading(new Vector2d(32.85, 35.40), Math.toRadians(30.00))
                            .strafeToLinearHeading(new Vector2d(43.17, 60.00), Math.toRadians(0.00))
                            .strafeToLinearHeading(new Vector2d(60.00, 60.00), Math.toRadians(0.00))
                            .strafeToLinearHeading(new Vector2d(-60.00, 60.00), Math.toRadians(0.00))
                            .strafeToLinearHeading(new Vector2d(-58.32, -71.87), Math.toRadians(-81.96))
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
