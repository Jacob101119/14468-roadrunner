package org.firstinspires.ftc.teamcode.tuning;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.TankDrive;

@Autonomous(name = "RRPathGen", group = "00-Autonomous")
public final class RRPathGen extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        if (TuningOpModes.DRIVE_CLASS.equals(MecanumDrive.class)) {
            MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(-36.0, -60.0, 0));

            waitForStart();
//new updates to run movements
            Actions.runBlocking(





                    drive.actionBuilder(new Pose2d(-36.0, -60.00, Math.toRadians(0.00)))
                            .strafeToLinearHeading(new Vector2d(60.00, -60.00), Math.toRadians(0.00))
                            .strafeToLinearHeading(new Vector2d(30.00, -60.00), Math.toRadians(180.88))
                            .strafeToLinearHeading(new Vector2d(30.00, -60.00), Math.toRadians(0.00))
                            .strafeToLinearHeading(new Vector2d(60.00, 60.00), Math.toRadians(0.00))
                            .strafeToLinearHeading(new Vector2d(54.44, 60.07), Math.toRadians(179.31))
                            .strafeToLinearHeading(new Vector2d(-60.00, 60.00), Math.toRadians(179.73))
                            .strafeToLinearHeading(new Vector2d(-52.16, 60.34), Math.toRadians(0.00))
                            .strafeToLinearHeading(new Vector2d(-49.47, 28.02), Math.toRadians(255.60))
                            .strafeToLinearHeading(new Vector2d(-56.31, -59.93), Math.toRadians(268.02))
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
