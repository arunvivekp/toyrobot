package com.arun.toyrobot.model;

/**
 * Represents a rectangle board
 * Can be a square board if x and y are same
 * 
 * @author arunvivek
 *
 */
public class RectangleBoard implements Board {

	private int rows;
	private int columns;
	
	public RectangleBoard(int rows, int columns) {
		super();
		this.rows = rows;
		this.columns = columns;
	}
	
	public boolean isValidPosition(Position position) {
		return !(
                position.getXAxis() > this.columns || position.getXAxis() < 0 ||
                        position.getYAxis() > this.rows || position.getYAxis() < 0
        );
	}
}