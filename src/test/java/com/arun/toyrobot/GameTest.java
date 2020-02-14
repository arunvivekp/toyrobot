package com.arun.toyrobot;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.arun.toyrobot.exception.InvalidCommandException;
import com.arun.toyrobot.exception.RobotException;
import com.arun.toyrobot.model.Board;
import com.arun.toyrobot.model.Direction;
import com.arun.toyrobot.model.Position;
import com.arun.toyrobot.model.RectangleBoard;
import com.arun.toyrobot.model.ToyRobot;

@RunWith(JUnit4.class)
public class GameTest {

	Board board;
	ToyRobot toyRobot;
	Game game;
	
	@Before
	public void setUp() {
		board = new RectangleBoard(5, 5);
		toyRobot = new ToyRobot();
		game = new Game(toyRobot, board);
	}
	
	@Test
	public void testPlaceToyRobot() throws RobotException {
		game.placeToyRobot(new Position(0, 1, Direction.NORTH));
		Assert.assertEquals(0, toyRobot.getPosition().getXAxis());
		Assert.assertEquals(1, toyRobot.getPosition().getYAxis());
		Assert.assertEquals(Direction.NORTH, toyRobot.getPosition().getDirection());
	}

	@Test(expected = InvalidCommandException.class)
	public void testInvalidCommand() throws InvalidCommandException, RobotException {

		game.processInput("PLAICE 0,0,NORTH");
	}
	
	@Test
	public void testProcessInput() throws InvalidCommandException, RobotException {

		game.processInput("PLACE 0,0,NORTH");
		Assert.assertEquals(0, toyRobot.getPosition().getXAxis());
		Assert.assertEquals(0, toyRobot.getPosition().getYAxis());
		Assert.assertEquals(Direction.NORTH, toyRobot.getPosition().getDirection());
	}
	
	@Test
	public void testInvalidMove() throws InvalidCommandException, RobotException {
		game.processInput("PLACE 5,5,NORTH");
		game.processInput("MOVE");
		Assert.assertEquals(5, toyRobot.getPosition().getXAxis());
		Assert.assertEquals(5, toyRobot.getPosition().getYAxis());
		Assert.assertEquals(Direction.NORTH, toyRobot.getPosition().getDirection());
	}
	
	@After
	public void tearDown() {
		
	}
}