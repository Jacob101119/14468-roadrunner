package org.firstinspires.ftc.teamcode.tuning;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.TankDrive;

@Autonomous(name = "AutoTest1", group = "00-Autonomous")
public final class AutoTest1 extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        if (TuningOpModes.DRIVE_CLASS.equals(MecanumDrive.class)) {
            MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));

            waitForStart();
//new updates to run movements
            Actions.runBlocking(
                drive.actionBuilder(drive.pose)

                        .splineTo(new Vector2d(28, 0), 0)
                        .strafeToLinearHeading(new Vector2d(12, 28), Math.toRadians(-180))// what russel told me to put to change the rotation
                        .splineTo(new Vector2d(18, 28), 0)


                        //alternate path to go touch all four corners (start in bottom right corner center of tile (blue wing))
                        /*
                        .splineTo(new Vector2d(120, 0), 0)
                        .splineTo(new Vector2d(96,0 ), 0 )
                        .splineTo(new Vector2d(96, 120), 0)
                        .splineTo(new Vector2d(120, 120), 0)
                        .splineTo(new Vector2d(0, 120), 0)
                        .splineTo(new Vector2d(0, 0), 0)
                        */

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
