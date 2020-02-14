package com.arun.toyrobot;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.arun.toyrobot.model.Position;
import com.arun.toyrobot.model.RectangleBoard;;

@RunWith(JUnit4.class)
public class RectangleBoardTest {

    @Test
    public void testIsValidPosition() throws Exception {
        Position mockPosition = mock(Position.class);
        when(mockPosition.getXAxis()).thenReturn(3);
        when(mockPosition.getYAxis()).thenReturn(4);

        RectangleBoard board = new RectangleBoard(5, 5);
        Assert.assertTrue(board.isValidPosition(mockPosition));

        when(mockPosition.getXAxis()).thenReturn(0);
        when(mockPosition.getYAxis()).thenReturn(-1);
        Assert.assertFalse(board.isValidPosition(mockPosition));
        
        when(mockPosition.getXAxis()).thenReturn(5);
        when(mockPosition.getYAxis()).thenReturn(6);
        Assert.assertFalse(board.isValidPosition(mockPosition));

    }

}
