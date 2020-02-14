package com.arun.toyrobot.model;

import com.arun.toyrobot.exception.RobotException;

/**
 * Represents position of the robot on the board
 * X, Y, F (direction)
 * @author arunvivek
 *
 */
public class Position {

	private int xAxis;
	private int yAxis;
	Direction direction;

	public Position(int xAxis, int yAxis, Direction direction) {
		super();
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.direction = direction;
	}

	public Position(Position position) {
		this.xAxis = position.getXAxis();
        this.yAxis = position.getYAxis();
        this.direction = position.getDirection();
	}

	public int getXAxis() {
		return xAxis;
	}

	public void setXAxis(int xAxis) {
		this.xAxis = xAxis;
	}
	
	public int getYAxis() {
		return yAxis;
	}
	
	public void setYAxis(int yAxis) {
		this.yAxis = yAxis;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
    public void change(int x, int y) {
        this.xAxis = this.xAxis + x;
        this.yAxis = this.yAxis + y;
    }

    public Position getNextPosition() throws RobotException {
        if (this.direction == null)
            throw new RobotException("Invalid robot direction, cannot be null");

        // find next position 
        Position newPosition = new Position(this);
        switch (this.direction) {
            case NORTH:
                newPosition.change(0, 1);
                break;
            case EAST:
                newPosition.change(1, 0);
                break;
            case SOUTH:
                newPosition.change(0, -1);
                break;
            case WEST:
                newPosition.change(-1, 0);
                break;
        }
        return newPosition;
    }
    
	@Override
	public String toString() {
		return String.valueOf(xAxis + "," + yAxis + "," + direction);
	}
	
}
