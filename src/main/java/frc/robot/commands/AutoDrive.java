// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class AutoDrive extends CommandBase {
  /** Creates a new AutoDrive. */
  private Drivetrain DRIVE_SUBSYSTEM;
  private double leftPercent;
  private double rightPercent;

  public AutoDrive(Drivetrain drive, double left, double right) {
    // Use addRequirements() here to declare subsystem dependencies.
    DRIVE_SUBSYSTEM = drive;
    leftPercent = left;
    rightPercent = right;
    addRequirements(DRIVE_SUBSYSTEM);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    DRIVE_SUBSYSTEM.set(leftPercent, rightPercent);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DRIVE_SUBSYSTEM.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
