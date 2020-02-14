package com.arun.toyrobot.exception;

public class InvalidCommandException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6006722903679051313L;

	public InvalidCommandException(String error) {
        super(error);
    }
}
