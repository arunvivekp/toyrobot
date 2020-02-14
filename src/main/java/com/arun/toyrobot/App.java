package com.arun.toyrobot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.arun.toyrobot.exception.InvalidCommandException;
import com.arun.toyrobot.exception.RobotException;
import com.arun.toyrobot.model.Board;
import com.arun.toyrobot.model.RectangleBoard;
import com.arun.toyrobot.model.ToyRobot;

/**
 * 
 * @author arunvivek
 *
 */
public class App 
{
	public static String SOURCE_FILE = "SOURCE_FILE";
	private static final Logger log = LogManager.getLogger(App.class);
	
    public static void main(String[] args) {
    	
    	String fileName = null;
    	Properties props = new Properties();
    	
    	Board board = new RectangleBoard(5, 5);
        ToyRobot robot = new ToyRobot();
        
        Game game = new Game(robot, board);
        
    	try {
			props.load(new FileInputStream("src/main/resources/application.properties"));
			fileName = props.getProperty(SOURCE_FILE);
			
		} catch (FileNotFoundException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		}
    	
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			stream.forEach(input -> {
				try {
					game.processInput(input);
				} catch (InvalidCommandException e) {
					log.error(e.getMessage());
				} catch (RobotException e) {
					log.error(e.getMessage());
				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
