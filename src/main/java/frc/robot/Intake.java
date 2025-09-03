// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.derive;

import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.reduxrobotics.sensors.canandcolor.Canandcolor;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.IntakeConstants.*;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  private Canandcolor m_canandcolor;
  private TalonFX m_motor;
  private final DutyCycleOut m_intake = new DutyCycleOut(0.0);

  public Intake() {
    m_canandcolor = new Canandcolor(4);
    m_motor = new TalonFX(2, "rio");
  }

  @Override
  public void periodic() {
    if (getCanandcolor() < PROXIMITY) {
      runIntake();
    }
  }

  public double getCanandcolor() {
    return m_canandcolor.getProximity();
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
