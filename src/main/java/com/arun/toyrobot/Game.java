package com.arun.toyrobot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.arun.toyrobot.exception.InvalidCommandException;
import com.arun.toyrobot.exception.RobotException;
import com.arun.toyrobot.model.Board;
import com.arun.toyrobot.model.Command;
import com.arun.toyrobot.model.Direction;
import com.arun.toyrobot.model.Position;
import com.arun.toyrobot.model.ToyRobot;

/**
 * Class to assemble objects for Game and process input instructions from file
 * 
 * Valid Commands
 * PLACE X,Y,(DIRECTION)
 * MOVE
 * LEFT
 * RIGHT
 * REPORT
 * 
 * @author arunvivek
 *
 */
public class Game {

	private static final Logger log = LogManager.getLogger(Game.class);
	private ToyRobot toyRobot;
	private Board board;
	
	public Game(ToyRobot toyRobot, Board board) {
		super();
		this.toyRobot = toyRobot;
		this.board = board;
	}
	
	/**
	 * Validates new position for the robot and places it
	 * @param position
	 * @throws RobotException 
	 */
	public void placeToyRobot(Position position) throws RobotException {
		if (board == null || toyRobot == null) {
			throw new RobotException("Game not initialized properly");
		}
		
        if (board.isValidPosition(position)) {
        	log.info("Placed at " + position);
        	toyRobot.place(position);
        } else {
        	log.warn("Invalid Position, Ignoring..");
        }
	}
	
	/**
	 * Process input command from file or other source
	 * 
	 * @param inputString
	 * @throws InvalidCommandException
	 * @throws RobotException
	 */
    public void processInput(String inputString) throws InvalidCommandException, RobotException {
        String[] args = inputString.split(" ");

        //Read Command and validate
        Command command;
        try {
            command = Command.valueOf(args[0]);
        } catch (IllegalArgumentException e) {
            throw new InvalidCommandException("Invalid command");
        }
        if (command == Command.PLACE && args.length < 2) {
            throw new InvalidCommandException("Invalid PLACE command, Syntax : PLACE X,Y,(DIRECTION)");
        }

        //For PLACE command, split string and get x,y and direction
        String[] params;
        int x = 0;
        int y = 0;
        Direction commandDirection = null;
        if (command == Command.PLACE) {
            params = args[1].split(",");
            try {
                x = Integer.parseInt(params[0]);
                y = Integer.parseInt(params[1]);
                commandDirection = Direction.valueOf(params[2]);
            } catch (Exception e) {
                throw new InvalidCommandException("Invalid PLACE command, Syntax : PLACE X,Y,(DIRECTION)");
            }
        }

        switch (command) {
            case PLACE:
                placeToyRobot(new Position(x, y, commandDirection));
                break;
            case MOVE:
            	Position newPosition = toyRobot.getPosition().getNextPosition();
                if (!board.isValidPosition(newPosition))
                	log.info("Invalid Move, Ignoring..");
                else
                    toyRobot.move(newPosition);
                break;
            case LEFT:
                toyRobot.turnLeft();
                break;
            case RIGHT:
                toyRobot.turnRight();
                break;
            case REPORT:
            	String message = toyRobot.report();
            	log.info(message);
                break;
            default:
                throw new InvalidCommandException("Invalid command");
        }
    }
}
