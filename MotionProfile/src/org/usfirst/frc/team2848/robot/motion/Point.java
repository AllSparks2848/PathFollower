package org.usfirst.frc.team2848.robot.motion;

public class Point {

    double x;
    double y;

    public Point(double x, double y) {
	this.x = x;
	this.y = y;
    }

    public double distance(Point a) {
	return Math.hypot(a.x - this.x, a.y - this.y);
    }

    /**
     * 
     * @return x coordinate
     */
    public double getX() {
	return x;
    }

    /**
     * 
     * @return y coordinate
     */
    public double getY() {
	return y;
    }

    public String toString() {
	return "(" + this.x + ", " + this.y + ")";
    }

}