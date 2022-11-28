// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ThreeBallAuton extends SequentialCommandGroup {
  /** Creates a new ThreeBallAuton. */
  public ThreeBallAuton(Drivetrain DRIVE_SUBSYSTEM, Intake INTAKE_SUBSYSTEM, Conveyor CONVEYOR_SUBSYSTEM, Shooter SHOOTER_SUBSYSTEM) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new ParallelCommandGroup(
       new AutoDrive(DRIVE_SUBSYSTEM, -0.5, -0.5),
        new RunIntakeCommand(INTAKE_SUBSYSTEM),
        new RunShooterCommand(SHOOTER_SUBSYSTEM)
      ).withTimeout(1),
      new ParallelCommandGroup(
        new RunShooterCommand(SHOOTER_SUBSYSTEM),
        new RunConveyorCommand(CONVEYOR_SUBSYSTEM)
      ).withTimeout(1),
      new ParallelCommandGroup(
       new AutoDrive(DRIVE_SUBSYSTEM, -0.5, -0.5),
        new RunIntakeCommand(INTAKE_SUBSYSTEM),
        new RunShooterCommand(SHOOTER_SUBSYSTEM)
      ).withTimeout(1),
      new ParallelCommandGroup(
        new RunShooterCommand(SHOOTER_SUBSYSTEM),
        new RunConveyorCommand(CONVEYOR_SUBSYSTEM)
      ).withTimeout(1)


    );

    
  }
}
