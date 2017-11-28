package org.usfirst.frc.team2848.robot.motion;

public class Waypoint {

    Point position;
    double radius;
    double speed;
    String marker;

    public Waypoint(double x, double y, double r, double s) {
	position = new Point(x, y);
	radius = r;
	speed = s;
    }

    public Waypoint(double x, double y, double r, double s, String m) {
	this(x, y, r, s);
	marker = m;
    }

}
