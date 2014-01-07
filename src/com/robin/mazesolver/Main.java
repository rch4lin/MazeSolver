package com.robin.mazesolver;

public class Main {
	public static void crawlMaze(){
		Robot robot = new Robot();
		
		//first step
		if (robot.hasWall()){
			robot.turnRight();
		}
		while(robot.hasWall()){
			robot.turnLeft();
		}
		robot.moveForward();
		
		while (robot.getX()!= Maze.endX |
				robot.getY()!= Maze.endY) {
			robot.turnLeft();
			if (!robot.hasWall()){
				robot.moveForward();
				continue;
			}
			robot.turnRight();
			if (!robot.hasWall()){
				robot.moveForward();
				continue;
			}
			robot.turnRight();
			if (!robot.hasWall()){
				robot.moveForward();
				continue;
			}
			robot.turnRight();
			if (!robot.hasWall()){
				robot.moveForward();
			}
		}
//		System.out.println(robot.getX());
//		System.out.println(robot.getY());
		
		for (int i=0;i<robot.path.size();i++){
			System.out.println(robot.path.get(i));
		}
	}
	public static void main(String[] args){
		Maze maze = new Maze();
		crawlMaze();
		
	}
}
