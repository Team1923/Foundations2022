// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  private WPI_TalonFX leftPrimary = new WPI_TalonFX(1);
  private WPI_TalonFX leftMotor1 = new WPI_TalonFX(2);
  private WPI_TalonFX leftMotor2 = new WPI_TalonFX(3);

  private WPI_TalonFX rightPrimary = new WPI_TalonFX(4);
  private WPI_TalonFX rightMotor1 = new WPI_TalonFX(5);
  private WPI_TalonFX rightMotor2 = new WPI_TalonFX(6);

  //public DifferentialDrive kdrive;

  public Drivetrain() {
      leftPrimary.configFactoryDefault();
      leftMotor1.configFactoryDefault();
      leftMotor2.configFactoryDefault();

      rightPrimary.configFactoryDefault();
      rightMotor1.configFactoryDefault();
      rightMotor2.configFactoryDefault();

      leftMotor1.follow(leftPrimary);
      leftMotor2.follow(leftPrimary);

      rightMotor1.follow(rightPrimary);
      rightMotor2.follow(rightPrimary);

      rightPrimary.setInverted(InvertType.InvertMotorOutput);

      //kdrive = new DifferentialDrive(leftPrimary, rightPrimary);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void set(double leftPercent, double rightPercent){
    leftPrimary.set(ControlMode.PercentOutput, leftPercent);
    rightPrimary.set(ControlMode.PercentOutput, rightPercent);
  }

  public void stop(){
    leftPrimary.set(ControlMode.PercentOutput, 0);
    rightPrimary.set(ControlMode.PercentOutput, 0);
  }


}
