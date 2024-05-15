package org.firstinspires.ftc.teamcode.tuning;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.TankDrive;

@Autonomous(name = "AutoTest6", group = "00-Autonomous")
public final class AutoTest6 extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        if (TuningOpModes.DRIVE_CLASS.equals(MecanumDrive.class)) {
            MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));

            waitForStart();
//new updates to run movements
            Actions.runBlocking(
                    drive.actionBuilder(drive.pose)


                            .strafeTo(new Vector2d(20, 0))
                            .strafeTo(new Vector2d(20, 20))
                            .strafeTo(new Vector2d(0, 20))
                            .strafeTo(new Vector2d(0, 0))
                            .strafeToLinearHeading(new Vector2d(10, -10), Math.toRadians(-180))
                            .strafeTo(new Vector2d(10, 15))
                            .strafeToLinearHeading(new Vector2d(0, 0), Math.toRadians(180))

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
