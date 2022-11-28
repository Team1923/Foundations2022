// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;

public class AutoDrive extends SequentialCommandGroup {
  private Drivetrain DRIVE_SUBSYSTEM;
  private double leftPerc, rightPerc;

  public AutoDrive(Drivetrain drive, double lP, double rP){
    DRIVE_SUBSYSTEM = drive;
    addRequirements(drive);

    leftPerc=lP;
    rightPerc=rP;
  }

  public void execute(){
    DRIVE_SUBSYSTEM.set(leftPerc, rightPerc);
  }

  public void end(boolean interrupted){
    DRIVE_SUBSYSTEM.stop();
  }


}
