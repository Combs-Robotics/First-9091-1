// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class drive extends SubsystemBase {
  /** Creates a new drive. */
  private CANSparkMax frontRight; 
  private CANSparkMax frontLeft; 
  private CANSparkMax backRight; 
  private CANSparkMax backLeft; 
  private DifferentialDrive diffDrive;


  public drive() {
    frontRight = new CANSparkMax(5, MotorType.kBrushed);
    frontLeft = new CANSparkMax(2, MotorType.kBrushed);
    backRight = new CANSparkMax(4, MotorType.kBrushed);
    backLeft = new CANSparkMax(3, MotorType.kBrushed);
    // leftEncoder = frontLeft.getEncoder();
    // rightEncoder = frontRight.getEncoder();
    backLeft.follow(frontLeft);
    backRight.follow(frontRight);
    frontRight.setInverted(true);
    diffDrive = new DifferentialDrive(frontLeft, frontRight);
  }
  public void setDriveSpeed(double speed, double angle) {
    // diffDrive.tankDrive(speed, angle);
    diffDrive.arcadeDrive(speed, angle);
  }

  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  // public double getPos(int returntype) {
  //   double lpos = leftEncoder.getPosition();
  //   double rpos = rightEncoder.getPosition();
  //   //index 0 returns left, 1 returns right, 2 returns the average between them
  //   double[] allPos = new double[] {lpos, rpos, (lpos + rpos) / 2};
  //   return allPos[returntype];
  // }

  // public void resetPos() {
  //   leftEncoder.setPosition(0);
  //   rightEncoder.setPosition(0);
  // }
}
