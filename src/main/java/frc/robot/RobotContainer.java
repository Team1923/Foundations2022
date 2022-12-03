// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ArcadeDriveCommand;
import frc.robot.commands.FirstAuton;
import frc.robot.commands.RunConveyorCommand;
import frc.robot.commands.RunIntakeCommand;
import frc.robot.commands.RunShooterCommand;
import frc.robot.commands.RunShooterPIDCommand;
import frc.robot.commands.ThreeBallAuton;
import frc.robot.commands.TwoBallAuton;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private Joystick CONTROLLER = new Joystick(0);

  private Drivetrain DRIVE_SUBSYSTEM = new Drivetrain();

  private Shooter SHOOTER_SUBSYSTEM = new Shooter();

  private Intake INTAKE_SUBSYSTEM = new Intake();

  private Conveyor CONVEYOR_SUBSYSTEM = new Conveyor();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    setDefaultCommands();
 
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // new JoystickButton(CONTROLLER, 6).whileHeld(new RunShooterCommand(SHOOTER_SUBSYSTEM)) ;
    new JoystickButton(CONTROLLER, 6).whileHeld(new RunShooterPIDCommand(SHOOTER_SUBSYSTEM, 2750)) ;
    new JoystickButton(CONTROLLER, 2).whileHeld(new RunIntakeCommand(INTAKE_SUBSYSTEM));
    //new JoystickButton(CONTROLLER, CONTROLLER.getRawButton(button)).whileHeld(new RunIntakeCommand(INTAKE_SUBSYSTEM));
    new JoystickButton(CONTROLLER, 5).whileHeld(new RunConveyorCommand(CONVEYOR_SUBSYSTEM));

    
  }

  private void setDefaultCommands(){
    DRIVE_SUBSYSTEM.setDefaultCommand(new ArcadeDriveCommand(DRIVE_SUBSYSTEM, CONTROLLER));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new TwoBallAuton(DRIVE_SUBSYSTEM, INTAKE_SUBSYSTEM, SHOOTER_SUBSYSTEM, CONVEYOR_SUBSYSTEM);
   }
}
 
