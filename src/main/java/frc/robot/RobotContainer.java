// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*
 * THis is a basic tank drive template that uses two motors on both sides
 */

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.Subsystems.*;

public class RobotContainer {
  //TODO: Make sure this matches the type of controller you are using:
  public final Joystick controller = new Joystick(0);
  //public final Joystick cotnroller2 = new Joystick(1);    // Only use this is if you want tank drive with two separate joysticks
  public final Drivetrain s_drive = new Drivetrain();

  public RobotContainer() {
    configureBindings();

    // Arcade drive with one joystick
    s_drive.setDefaultCommand(new RunCommand(() -> s_drive.arcadeDrive(controller.getY(), -controller.getX()) ,s_drive));

    // Tank drive with two joysticks
    //s_drive.setDefaultCommand(new RunCommand(() -> s_drive.tankDrive(controller.getY(), controller2.getY()) ,s_drive));

  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}