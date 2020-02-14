package com.arun.toyrobot;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.arun.toyrobot.exception.RobotException;
import com.arun.toyrobot.model.Direction;
import com.arun.toyrobot.model.Position;
import com.arun.toyrobot.model.ToyRobot;

@RunWith(JUnit4.class)
public class ToyRobotTest {

	ToyRobot toyRobot;
	@Before
	public void setUp() {
		toyRobot = new ToyRobot();
	}
	
	@Test
	public void testPlace() {
		Position position = new Position(0,0,Direction.NORTH);
		
		toyRobot.place(position);
		Assert.assertEquals(toyRobot.getPosition().getXAxis(), 0);
        Assert.assertEquals(toyRobot.getPosition().getYAxis(), 0);
        Assert.assertEquals(toyRobot.getPosition().getDirection(), Direction.NORTH);
	}
	
	@Test
	public void testTurnLeft() {
		Position position = new Position(0,0,Direction.SOUTH);
		
		toyRobot.place(position);
		toyRobot.turnLeft();
		Assert.assertEquals(toyRobot.getPosition().getDirection(), Direction.EAST);
	}
	
	@Test
	public void testTurnRight() {
		Position position = new Position(0,0,Direction.NORTH);
		
		toyRobot.place(position);
		toyRobot.turnRight();
		Assert.assertEquals(toyRobot.getPosition().getDirection(), Direction.EAST);
	}
	
	@Test
	public void testMove() throws RobotException {
		Position position = new Position(0,0,Direction.NORTH);
		
		toyRobot.place(position);
		toyRobot.move();
		toyRobot.move();
		Assert.assertEquals(toyRobot.getPosition().getXAxis(), 0);
        Assert.assertEquals(toyRobot.getPosition().getYAxis(), 2);
        Assert.assertEquals(toyRobot.getPosition().getDirection(), Direction.NORTH);
        
        toyRobot.getPosition().setDirection(Direction.EAST);
        toyRobot.move();
		toyRobot.move();
		Assert.assertEquals(toyRobot.getPosition().getXAxis(), 2);
        Assert.assertEquals(toyRobot.getPosition().getYAxis(), 2);
        Assert.assertEquals(toyRobot.getPosition().getDirection(), Direction.EAST);

	}
	
	@After
	public void tearDown() {
		
	}
}