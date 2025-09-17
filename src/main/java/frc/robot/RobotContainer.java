// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
  private Intake m_Intake = new Intake();
  private Arm m_Arm = new Arm();
  private CommandXboxController m_controller = new CommandXboxController(0);

  public RobotContainer() {
    configureBindings();
    m_Intake.setDefaultCommand(m_Intake.intakeDefault());
    m_Arm.setDefaultCommand(m_Arm.armDefault());
  }

  private void configureBindings() {
    m_controller.a().whileTrue(m_Intake.runIntake());
    m_controller.b().whileTrue(m_Intake.runOuttake());
    m_controller.y().whileTrue(m_Arm.armUp());
    m_controller.x().whileTrue(m_Arm.armScoring());
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
