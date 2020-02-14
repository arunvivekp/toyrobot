package com.arun.toyrobot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.arun.toyrobot.exception.RobotException;
import com.arun.toyrobot.model.Direction;
import com.arun.toyrobot.model.Position; 

@RunWith(JUnit4.class)
public class PositionTest {

	@Test(expected = RobotException.class )
	public void testNullDirection() throws RobotException {
		Position position = new Position(0, 0, null);
		position.getNextPosition();
	}
	
	@Test
	public void testGetNextPosition() throws RobotException {
		Position position = new Position(0, 0, Direction.NORTH);
		Position newPosition = position.getNextPosition();
		
		Assert.assertEquals(newPosition.getXAxis(), 0);
        Assert.assertEquals(newPosition.getYAxis(), 1);
        Assert.assertEquals(newPosition.getDirection(), Direction.NORTH);
        
        newPosition.setDirection(Direction.EAST);
        newPosition = newPosition.getNextPosition();
        Assert.assertEquals(newPosition.getXAxis(), 1);
        Assert.assertEquals(newPosition.getYAxis(), 1);
        Assert.assertEquals(newPosition.getDirection(), Direction.EAST);
		
	}
}
