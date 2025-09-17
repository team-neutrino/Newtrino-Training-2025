// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.ArmConstants.*;

public class Arm extends SubsystemBase {
  private TalonFX m_motor;
  private final DutyCycleOut m_arm = new DutyCycleOut(0.0);

  public Arm() {
    m_motor = new TalonFX(3, "rio");
    m_motor.setPosition(0);

  }

  public Command armDefault() {
    return run(() -> {
      if (m_motor.getPosition().refresh().getValueAsDouble() > 0) {
        m_motor.setControl(m_arm.withOutput(-.1));
      } else {
        m_motor.setControl(m_arm.withOutput(0));
      }
    });
  }

  public Command armUp() {
    return run(() -> {
      if (m_motor.getPosition().refresh().getValueAsDouble() <= UPRIGHT) {
        m_motor.setControl(m_arm.withOutput(0.1));
      } else {
        m_motor.setControl(m_arm.withOutput(0));
      }
    });
  }

  public Command armScoring() {
    return run(() -> {
      if (m_motor.getPosition().refresh().getValueAsDouble() <= SCORING) {
        m_motor.setControl(m_arm.withOutput(0.1));
      } else {
        m_motor.setControl(m_arm.withOutput(0));
      }
    });
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
