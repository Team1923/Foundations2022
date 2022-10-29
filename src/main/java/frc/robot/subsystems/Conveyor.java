// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Conveyor extends SubsystemBase {
  
  private WPI_TalonFX conveyorBelts = new WPI_TalonFX(13);
  private WPI_TalonFX feederWheels = new WPI_TalonFX(9);

  public Conveyor() {
    conveyorBelts.configFactoryDefault();
    feederWheels.configFactoryDefault();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void set(double conveyorPercent, double feederPercent){
    conveyorBelts.set(ControlMode.PercentOutput, conveyorPercent);
    feederWheels.set(ControlMode.PercentOutput, feederPercent);
  }

  public void stop(){
    conveyorBelts.set(ControlMode.PercentOutput, 0);
    feederWheels.set(ControlMode.PercentOutput, 0);
  }
}
