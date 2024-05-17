package org.firstinspires.ftc.teamcode.tuning;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.TankDrive;

@Autonomous(name = "AutoTest2", group = "00-Autonomous")
public final class AutoTest2 extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        if (TuningOpModes.DRIVE_CLASS.equals(MecanumDrive.class)) {
            MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));

            waitForStart();
//new updates to run movements
            Actions.runBlocking(


                            drive.actionBuilder(new Pose2d(-36.00, -62.70, Math.toRadians(90.00)))
                                    /*
                            .strafeToConstantHeading(new Vector2d(-36.00, -34.50), Math.toRadians(90.00))
                            .lineToConstantHeading(new Vector2d(-60.00, -36.00))
                            .lineToConstantHeading(new Vector2d(-28.00, -9.26))
                            .lineToConstantHeading(new Vector2d(32.45, -12.34))
                            .strafeTo(new Vector2d(34.59, -39.28), Math.toRadians(-85.45))
                            .strafeTo(new Vector2d(48.00, -36.00), Math.toRadians(0.00))
                            .lineToStrafeHeading(new Pose2d(16.36, -60.20, Math.toRadians(-180.00)))
                            .strafeTo(new Vector2d(-38.88, -60.00), Math.toRadians(178.33))
                            .strafeTo(new Vector2d(-58.59, -23.46), Math.toRadians(-180.00))
                            .lineToStrafeHeading(new Pose2d(-19.17, -11.00, Math.toRadians(0.00)))
                            .strafeTo(new Vector2d(26.41, -15.55), Math.toRadians(-5.70))
                            .strafeTo(new Vector2d(50.41, -37.68), Math.toRadians(0.00))
                            .build());
*/


                            //alternate path to go through truss


                             .strafeToLinearHeading(new Vector2d(80, 40), Math.toRadians(-180))// what russel told me to put to change the rotation
                            .strafeToLinearHeading(new Vector2d(80, -40), Math.toRadians(180))
                            .splineTo(new Vector2d(96, 0), 0)
                            .strafeToLinearHeading(new Vector2d(96, -58), Math.toRadians(0))
                            .strafeToLinearHeading(new Vector2d(-58, 0), Math.toRadians(0))
                            .strafeToLinearHeading(new Vector2d(0, 0), Math.toRadians(0))



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
