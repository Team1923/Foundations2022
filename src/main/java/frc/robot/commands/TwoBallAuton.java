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
public class TwoBallAuton extends SequentialCommandGroup {
  /** Creates a new TwoBallAuton. */
  public TwoBallAuton(Drivetrain DRIVETRAIN_SUBSYSTEM, Intake INTAKE_SUBSYSTEM, Shooter SHOOTER_SUBSYSTEM, Conveyor CONVEYOR_SUBSYSTEM) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new ParallelCommandGroup(
        new AutoDrive(DRIVETRAIN_SUBSYSTEM, 0.5, -0.5),
        new RunIntakeCommand(INTAKE_SUBSYSTEM),
        new RunShooterCommand(SHOOTER_SUBSYSTEM)
      ).withTimeout(2),

      new ParallelCommandGroup(
        new RunShooterCommand(SHOOTER_SUBSYSTEM),
        new RunConveyorCommand(CONVEYOR_SUBSYSTEM)
      ).withTimeout(2)

    );
  }
}