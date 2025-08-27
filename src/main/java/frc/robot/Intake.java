// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.derive;

import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  private TalonFX m_motor;
  private final DutyCycleOut m_intake = new DutyCycleOut(0.0);

  public Intake() {
    m_motor = new TalonFX(2, "rio");
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    // default mode, the motor should not be spinning while we do not want
    // it to (that would be bad I think,)
  }

  public Command runIntake() {
    return run(() -> {
      m_motor.setControl(m_intake.withOutput(.5));
    });
  }

  public Command intakeDefault() {
    return run(() -> {
      m_motor.setControl(m_intake.withOutput(0));
    });
  }

  public Command runOuttake() {
    return run(() -> {
      m_motor.setControl(m_intake.withOutput(-.5));
    });
  }
}
