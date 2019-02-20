// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4902.Wildebots2019NEW.commands;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4902.Wildebots2019NEW.Robot;

/**
 *
 */
public class BallCollect_DropOff extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public BallCollect_DropOff() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.ballMechanism);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Robot.ballMechanism.drive(0.0);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.ballMechanism.drive(Robot.oi.getmy_Xbox360Controller().getY(Hand.kRight));

        /* THIS NEEDS TO BE TESTED */
        // This is a redundant code in case if the Right Side Stick fails or the operator requires full control to have Motor ON or OFF
        if(Robot.oi.my_Xbox360Controller.getBButton())
        {
            Robot.ballMechanism.drive(1.0); // Full Speed PWM FWD, Ball Intake
        }
        if(Robot.oi.my_Xbox360Controller.getXButton())
        {
            Robot.ballMechanism.drive(-1.0); // Full Speed PWM BKWD, Ball Intake Reverse Motor
        }
    }
    
    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.ballMechanism.end(); // Call the End Method and Stop the Motors
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end(); // If interrupted set the speed to 0
    }
}
