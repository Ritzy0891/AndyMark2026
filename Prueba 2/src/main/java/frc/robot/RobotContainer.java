// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandGenericHID;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.DriveSubsystem;

public class RobotContainer {
  private final DriveSubsystem m_drive = new DriveSubsystem();

  private final CommandGenericHID m_driver =
      new CommandGenericHID(OperatorConstants.kDriverControllerPort);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    m_drive.setDefaultCommand(
        Commands.run(
            () -> m_drive.arcadeDrive(
                -m_driver.getRawAxis(1),   // avanzar con stick izquierdo vertical
                -m_driver.getRawAxis(0)),  // girar con stick izquierdo horizontal
            m_drive));
  }
}