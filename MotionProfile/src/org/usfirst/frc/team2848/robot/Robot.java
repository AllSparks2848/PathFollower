
package org.usfirst.frc.team2848.robot;

import java.util.ArrayList;

import org.usfirst.frc.team2848.robot.motion.MotionPather;
import org.usfirst.frc.team2848.robot.motion.PathFollower;
import org.usfirst.frc.team2848.robot.motion.Waypoint;
import org.usfirst.frc.team2848.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    PathFollower autoPath;
    DriveTrain drive;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
	drive = DriveTrain.getInstance();
	ArrayList<Waypoint> sWaypoints = new ArrayList<Waypoint>();
	sWaypoints.add(new Waypoint(20, 20, 0, 60));
	sWaypoints.add(new Waypoint(25, 90, 20, 60));
	sWaypoints.add(new Waypoint(20, 100, 5, 60));
	sWaypoints.add(new Waypoint(55, 650, 2, 60));
	sWaypoints.add(new Waypoint(75, 120, 0, 0));
	MotionPather mp = new MotionPather();
	autoPath = new PathFollower(mp.generatePath(sWaypoints));
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {
	Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString code to get the auto name from the text box below the Gyro
     *
     * You can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons
     * to the switch structure below with additional strings & commands.
     */
    @Override
    public void autonomousInit() {
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
	autoPath.followPath();	 
    }

    @Override
    public void teleopInit() {
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
	Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    @Override
    public void testPeriodic() {
	LiveWindow.run();
    }
}