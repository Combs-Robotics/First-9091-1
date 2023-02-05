// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drive;

public class move extends CommandBase {
  /** Creates a new move. */
  private drive m_drive;
  private double m_dist;
  public move(drive thisdrive, double setdist) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drive = thisdrive;
    m_dist = setdist;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drive.resetPos();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_dist < 0) {
      //backward
      m_drive.setDriveSpeed(-0.5, 0);
    } else if (m_dist > 0) {
      //forward
      m_drive.setDriveSpeed(0.5, 0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.setDriveSpeed(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (m_dist >= 0) {
      return m_drive.getPos(2) >= m_dist ? true : false;
    } else {
      return m_drive.getPos(2) <= m_dist ? true : false;
    }
  }
}
