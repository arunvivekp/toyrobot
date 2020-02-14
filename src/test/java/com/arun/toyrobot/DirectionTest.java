package com.arun.toyrobot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.arun.toyrobot.model.Direction;

@RunWith(JUnit4.class)
public class DirectionTest {
	
	private Direction direction;
	@Test
	public void testLeftTurn() {
		direction = Direction.EAST;
		
		direction = direction.turnLeft();
		Assert.assertEquals(Direction.NORTH, direction.getCurrentDirection());
		
		direction = direction.turnLeft();
		Assert.assertEquals(Direction.WEST, direction.getCurrentDirection());
		
		direction = direction.turnLeft();
		Assert.assertEquals(Direction.SOUTH, direction.getCurrentDirection());
		
		direction = direction.turnLeft();
		Assert.assertEquals(Direction.EAST, direction.getCurrentDirection());
		
	}
	
	@Test
	public void testRightTurn() {
		direction = Direction.EAST;
		
		direction = direction.turnRight();
		Assert.assertEquals(Direction.SOUTH, direction.getCurrentDirection());
		
		direction = direction.turnRight();
		Assert.assertEquals(Direction.WEST, direction.getCurrentDirection());
		
		direction = direction.turnRight();
		Assert.assertEquals(Direction.NORTH, direction.getCurrentDirection());
		
		direction = direction.turnRight();
		Assert.assertEquals(Direction.EAST, direction.getCurrentDirection());
	}
}
