# toyrobot
Toy Robot Simulator

A toy robot simulator that simulates actions of a robot based on the commands given <br>
The board is a square board (5 x 5) with 0,0 being the origin in the SOUTH EAST <br>

Assumptions :
- There are no other obstructions on the table surface <br>
- The robot is free to roam around the surface of the table, but must be prevented from falling to destruction.  <br>
- Any movement that would result in the robot falling from the table must be prevented, however further valid movement commands must still be allowed <br>

The robot takes the following commands <br>
# PLACE X,Y,{DIRECTION} 
	- DIRECTION can be NORTH, EAST, SOUTH and WEST
# MOVE
	- moves the robot 1 step in the direction facing
# LEFT
	- turns left staying in the current place changing only the direction (Ex : NORTH - left turn - WEST)
# RIGHT
	- turns right staying in the current place changing only the direction (Ex : NORTH - right turn - EAST)
# REPORT 
	- Reports the current position including direction

Robot commands can be put in a file in the following format <br>
PLACE 0,0,NORTH <br>
MOVE <br>
LEFT <br>
REPORT <br>
PLACE 0,0,NORTH <br>
LEFT <br>
REPORT <br>

File can be placed in any location, the path needs to be specified in application.properties file in src/resources folder <br>
A sample file (robot_instructions.txt) has been uploaded to the repository <br>

Maven Commands to run the program <br>
mvn clean install - (build the program) <br>
mvn test          - (run the test cases) <br>
mvn exec:java     - (run the program to simulate toy robot) <br>
