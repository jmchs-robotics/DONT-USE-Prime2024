package frc.robot.commands;

import frc.robot.subsystems.SwerveDriveSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * An example command that uses an example subsystem.
 */
public class DefaultSwerveDriveCommand extends Command {
  
  private final SwerveDriveSubsystem m_subsystem;
  private final XboxController m_stick;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   * @param stick The XBoxController used by this command.
   */
  public DefaultSwerveDriveCommand(SwerveDriveSubsystem subsystem, XboxController stick) {
    m_subsystem = subsystem;
    m_stick = stick;
    
    addRequirements(m_subsystem);
  }

  private double deadband(double input){
    if(Math.abs(input) < 0.05) return 0;
    return input;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double forward = m_stick.getLeftY() * 0.75;
    double strafe = m_stick.getLeftX() * 0.75;
    double rotation = m_stick.getRightX() * 0.60;

    forward *= Math.abs(forward);
		strafe *= Math.abs(strafe);
		rotation *= Math.abs(rotation);

		forward = deadband(forward);
		strafe = deadband(strafe);
    rotation = deadband(rotation);
    
    m_subsystem.holonomicDrive(forward, strafe, rotation, m_subsystem.isFieldOriented());

    SmartDashboard.putNumber("Front Left Angle Encoder Value", m_subsystem.getSwerveModule(0).getRawSensorPosition());
    SmartDashboard.putNumber("Front Right Angle Encoder Value", m_subsystem.getSwerveModule(1).getRawSensorPosition());
    SmartDashboard.putNumber("Back Right Angle Encoder Value", m_subsystem.getSwerveModule(2).getRawSensorPosition());
    SmartDashboard.putNumber("Back Left Angle Encoder Value", m_subsystem.getSwerveModule(3).getRawSensorPosition());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Try to bring the robot to a dead stop before starting the next command
    m_subsystem.stopDriveMotors(); 
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}