// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  private TalonFX m_motor;

  public Arm() {
    m_motor = new TalonFX(0, "rio");
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
