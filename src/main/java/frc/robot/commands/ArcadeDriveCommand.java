// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class ArcadeDriveCommand extends CommandBase {

  private Drivetrain DRIVE_SUBSYSTEM;
  private Joystick CONTROLLER;
  /** Creates a new ArcadeDriveCommand. */
  public ArcadeDriveCommand(Drivetrain drive, Joystick controller) {
    // Use addRequirements() here to declare subsystem dependencies.
    DRIVE_SUBSYSTEM =drive;
    CONTROLLER = controller;

    addRequirements(DRIVE_SUBSYSTEM);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //this.DRIVE_SUBSYSTEM.kdrive.curvatureDrive(CONTROLLER.getRawAxis(1), CONTROLLER.getRawAxis(4), false);
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
