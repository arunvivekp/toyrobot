package com.arun.toyrobot.model;

import com.arun.toyrobot.exception.RobotException;

/**
 * Represents a Movable object
 * Provides method to place, move and turn
 * 
 * @author arunvivek
 *
 */
public interface Movable {

	public void place(Position position);
	public void move() throws RobotException;
	public void turnLeft();
	public void turnRight();
	public String report();
}
