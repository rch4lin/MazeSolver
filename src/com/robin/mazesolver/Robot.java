package com.robin.mazesolver;

import java.util.ArrayList;

public class Robot {
	private static int currentOrientation; //0=n, 1=e, 2=s, 3=w
	private static int x; //x coordinate relative to 2D maze
	private static int y;
	public static ArrayList<Integer> path = new ArrayList<Integer>();
	
	public Robot() {
		currentOrientation = Orientation.NORTH;
		x = Maze.startX;
		y = Maze.startY;
	}
	
	protected void turnLeft() {
		currentOrientation = 
				currentOrientation==Orientation.NORTH ? Orientation.WEST : (currentOrientation-=1);
//		move(currentOrientation);
	}
	
	protected void turnRight() {
		currentOrientation = 
				currentOrientation==Orientation.WEST ? Orientation.NORTH : (currentOrientation+=1);
//		move(currentOrientation);
	}
	
	protected void turnAround() {
		currentOrientation = 
				currentOrientation==Orientation.EAST ? Orientation.WEST : (currentOrientation-=2);
//		move(currentOrientation);
	}
	
	protected void moveForward() {
		move(currentOrientation);
		path.add(currentOrientation);
	}
	
	protected int getX() {
		return x;
	}
	
	protected int getY() {
		return y;
	}
	
	protected boolean hasWall() {
		switch (currentOrientation) {
			case Orientation.NORTH:
//				y -= 1;
				return Maze.maze[y-1][x]==1;
			case Orientation.EAST:
//				x += 1;
				return Maze.maze[y][x+1]==1;
			case Orientation.SOUTH:
//				y += 1;
				return Maze.maze[y+1][x]==1;
			case Orientation.WEST:
//				x -= 1;
				return Maze.maze[y][x-1]==1;
			default:
				return false;
			}
	}
	
	private void move(int direction) {
//		currentOrientation = direction;
		switch (direction){
			case Orientation.NORTH:
				y-=1;
				break;
			case Orientation.EAST:
				x+=1;
				break;
			case Orientation.SOUTH:
				y+=1;
				break;
			case Orientation.WEST:
				x-=1;
				break;
		}
	}
	
	protected int getOrientation() {
		return currentOrientation;
	}
	
	protected void setDirection(int direction) {
		currentOrientation = direction;
	}

}
