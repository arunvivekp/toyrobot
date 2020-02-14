package com.arun.toyrobot.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.arun.toyrobot.exception.RobotException;

public class ToyRobot implements Movable {
	
	private static final Logger log = LogManager.getLogger(ToyRobot.class);

	private Position position;

	public Position getPosition() {
		return position;
	}

	public void place(Position newPosition) {
		this.position = newPosition;
	}

	public void move() throws RobotException {
	    move(position.getNextPosition());
	}

	public void move(Position newPosition) throws RobotException {
        if (newPosition == null)
            throw new RobotException("Invalid Position");

        log.info("Moving..");
        //replace position with new Position
        this.position = newPosition;
    }
	
	public void turnLeft() {
		log.info("turning Left..");
		position.setDirection(position.direction.turnLeft());
	}

	public void turnRight() {
		log.info("turning Right..");
		position.setDirection(position.direction.turnRight());
	}

	public String report() {
		return String.valueOf("OUTPUT : " + this.position.getXAxis() + "," + this.position.getYAxis()
				+ "," + this.position.getDirection().toString());
	}
}
