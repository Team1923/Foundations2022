// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  private WPI_TalonFX intakeMotor = new WPI_TalonFX(11);
  public Intake() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void set(double intakePercent){
    intakeMotor.set(ControlMode.PercentOutput, intakePercent);
  }

  public void stop(){
    intakeMotor.set(ControlMode.PercentOutput, 0);
  }
}
