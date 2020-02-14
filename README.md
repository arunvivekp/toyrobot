# toyrobot
Toy Robot Simulator

A toy robot simulator that simulates actions of a robot based on the commands given
The board is a square board (5 x 5) with 0,0 being the origin in the SOUTH EAST

Assumptions :
- There are no other obstructions on the table surface
- The robot is free to roam around the surface of the table, but must be prevented from falling to destruction. 
- Any movement that would result in the robot falling from the table must be prevented, however further valid movement commands must still be allowed

The robot takes the following commands
PLACE X,Y,{DIRECTION} - DIRECTION can be NORTH, EAST, SOUTH and WEST
MOVE - moves the robot 1 step in the direction facing
LEFT - turns left staying in the current place changing only the direction (Ex : NORTH - left turn - WEST)
RIGHT - turns right staying in the current place changing only the direction (Ex : NORTH - right turn - EAST)
REPORT - Reports the current position including direction

Robot commands can be put in a file in the following format
PLACE 0,0,NORTH
MOVE
LEFT
REPORT
PLACE 0,0,NORTH
LEFT
REPORT

File can be placed in any location, the path needs to be specified in application.properties file in src/resources folder
A sample file (robot_instructions.txt) has been uploaded to the repository

Maven Commands to run the program
mvn clean install - (build the program)
mvn test          - (run the test cases)
mvn exec:java     - (run the program to simulate toy robot)


