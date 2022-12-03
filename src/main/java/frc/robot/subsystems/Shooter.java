// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utilities.UnitConversion;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  private WPI_TalonFX shooterMotor1 = new WPI_TalonFX(10);
  private WPI_TalonFX shooterMotor2 = new WPI_TalonFX(7);
  public Shooter() {
    shooterMotor1.configFactoryDefault();
    shooterMotor2.configFactoryDefault();

    shooterMotor1.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 30);
    shooterMotor2.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 30);

    shooterMotor1.config_kP(0, 0.275, 30);
    shooterMotor1.config_kD(0, 0.00012, 30);
    shooterMotor1.config_kF(0, 0.012, 30);

    shooterMotor2.config_kP(0, 0.275, 30);
    shooterMotor2.config_kD(0, 0.00012, 30);
    shooterMotor1.config_kF(0, 0.012, 30);

    shooterMotor1.setInverted(InvertType.InvertMotorOutput);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Current Shoote RPM", getRPM());
  }

  public void set(double leftPercent, double rightPercent){
    shooterMotor1.set(ControlMode.PercentOutput, -leftPercent);
    shooterMotor2.set(ControlMode.PercentOutput, -rightPercent);
  }
  
  public void setRPM(double rpm) {
    shooterMotor1.set(ControlMode.Velocity, UnitConversion.RPMtoNativeUnits(rpm));
    shooterMotor2.set(ControlMode.Velocity, UnitConversion.RPMtoNativeUnits(rpm));

  }

  public double getRPM() {
    return UnitConversion.nativeUnitstoRPM(shooterMotor1.getSelectedSensorPosition());
  }

  public void stop(){
    shooterMotor1.set(ControlMode.PercentOutput, 0);
    shooterMotor2.set(ControlMode.PercentOutput, 0);
  }
}
