package com.arun.toyrobot.model;

import java.util.HashMap;
import java.util.Map;

/**
 * ENUM holding different directions with index for easy manipulation
 * 
 * NORTH - 0
 * EAST - 1
 * SOUTH - 2
 * WEST - 3
 * 
 * @author arunvivek
 *
 */
public enum Direction {

	NORTH(0), EAST(1), SOUTH(2), WEST(3);
	private int dirIndex;
	private static Map<Integer, Direction> mapOfDirections = new HashMap<Integer, Direction>();

	static {
		for (Direction direction : Direction.values()) {
			mapOfDirections.put(direction.dirIndex, direction);
		}
	}

	/**
	 * Constructor taking index as parameter
	 * @param direction
	 */
	private Direction(int direction) {
		this.dirIndex = direction;
	}

	/**
	 * Turns the robot to the left using index
	 * For LEFT, move to the previous index
	 */
	public Direction turnLeft() {
		return turn(-1);
	}
	
	/**
	 * Turns the robot to the right using index
	 * For RIGHT, move to the forward index
	 */
	public Direction turnRight() {
		return turn(1);
	}

	/**
	 * Turns the robot based on input step
	 * @param step
	 */
	private Direction turn(int step) {
		int newIndex = ((this.dirIndex + step) < 0) ? mapOfDirections.size() - 1
				: ((this.dirIndex + step) % mapOfDirections.size());
		return mapOfDirections.get(newIndex);
	}
	
	public Direction getCurrentDirection() {
		return mapOfDirections.get(this.dirIndex);
	}
}
