// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
//Declaramos los ID de los sparkmax 
private final SparkMax m_leftLead = new SparkMax(DriveConstants.kLeftMotor1Port, MotorType.kBrushed);
  private final SparkMax m_leftFollow = new SparkMax(DriveConstants.kLeftMotor2Port, MotorType.kBrushed);
  private final SparkMax m_rightLead = new SparkMax(DriveConstants.kRightMotor3Port, MotorType.kBrushed);
  private final SparkMax m_rightFollow = new SparkMax(DriveConstants.kRightMotor4Port, MotorType.kBrushed);
  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftLead, m_rightLead);

  public DriveSubsystem() {
    SparkMaxConfig leftLeadCfg = new SparkMaxConfig();
    leftLeadCfg.idleMode(IdleMode.kBrake).smartCurrentLimit(DriveConstants.kCurrentLimit);

    SparkMaxConfig rightLeadCfg = new SparkMaxConfig();
    rightLeadCfg.idleMode(IdleMode.kBrake).smartCurrentLimit(DriveConstants.kCurrentLimit).inverted(true);

    SparkMaxConfig leftFollowCfg = new SparkMaxConfig();
    leftFollowCfg.idleMode(IdleMode.kBrake).smartCurrentLimit(DriveConstants.kCurrentLimit).follow(m_leftLead);

    SparkMaxConfig rightFollowCfg = new SparkMaxConfig();
    rightFollowCfg.idleMode(IdleMode.kBrake).smartCurrentLimit(DriveConstants.kCurrentLimit).follow(m_rightLead);

    m_leftLead.configure(leftLeadCfg, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    m_rightLead.configure(rightLeadCfg, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    m_leftFollow.configure(leftFollowCfg, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    m_rightFollow.configure(rightFollowCfg, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  public void arcadeDrive(double forward, double rotation) {
    m_drive.arcadeDrive(forward, rotation);  
  }
}


