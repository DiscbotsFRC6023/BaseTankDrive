// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  /**
   * Most declarations would be here:
   */

  private final CANSparkMax LEFT_MOTOR_ONE = new CANSparkMax(Constants.LEFT_MOTOR_ONE_ID, MotorType.kBrushed);
  private final CANSparkMax LEFT_MOTOR_TWO = new CANSparkMax(Constants.LEFT_MOTOR_TWO_ID, MotorType.kBrushed);
  private final CANSparkMax RIGHT_MOTOR_ONE = new CANSparkMax(Constants.RIGHT_MOTOR_ONE_ID, MotorType.kBrushed);
  private final CANSparkMax RIGHT_MOTOR_TWO = new CANSparkMax(Constants.RIGHT_MOTOR_TWO_ID, MotorType.kBrushed);

  private final DifferentialDrive drive = new DifferentialDrive(LEFT_MOTOR_ONE, RIGHT_MOTOR_ONE);

  public Drivetrain() {
    // Invert the motors of one side so the robot goes in one direction
    LEFT_MOTOR_ONE.setInverted(true);
    LEFT_MOTOR_TWO.setInverted(true);

    // Telling secondary motors to follow the primary one
    LEFT_MOTOR_TWO.follow(LEFT_MOTOR_ONE);
    RIGHT_MOTOR_TWO.follow(RIGHT_MOTOR_ONE);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  // Create methods that will drive the robot's left and right motors
  public void tankDrive(double LEFT_POWER, double RIGHT_POWER){
    drive.tankDrive(LEFT_POWER, RIGHT_POWER);
  }

  public void arcadeDrive(double SPEED, double ROTATION){
    drive.arcadeDrive(SPEED, ROTATION);
  }

  //STOP:
  public void stop(){
    LEFT_MOTOR_ONE.set(0.0);
    LEFT_MOTOR_TWO.set(0.0);
    RIGHT_MOTOR_ONE.set(0.0);
    RIGHT_MOTOR_TWO.set(0.0);
  }
}