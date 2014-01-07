package com.robin.mazesolver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Maze {
	private static int LENGTH;
	private static int WIDTH;
	protected static int startX, startY, endX, endY;
	protected static int[][] maze;
	
	public Maze() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("maze.txt"));
			StringBuilder sb = new StringBuilder();
			//set Size
			String[] mazeSize = br.readLine().split(" ");
			LENGTH = Integer.parseInt(mazeSize[0]);
			WIDTH = Integer.parseInt(mazeSize[1]);
			
			
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				sb.append('\n');
				line = br.readLine();
			}
			String mazeLayout = sb.toString();
			br.close();
			
			constructMaze(mazeLayout);
		} catch(IOException e) {
			System.out.println(e);
		}	
	}
	
	/**
	 * Take string read from text and construct into a 2D array using binary representation
	 * 
	 * 0=open space
	 * 1=closed wall
	 * @param mazeLayout
	 */
	public void constructMaze(String mazeLayout) {
		String rows[] = mazeLayout.split("\n");
		char cell;
		maze = new int[LENGTH][WIDTH];
		for (int i=0; i<rows.length; i++) {
			for (int j=0; j<rows[i].length(); j++){
				cell = rows[i].charAt(j);	
				maze[i][j] = '*'==cell ? 1 : 0;
				
				if (cell=='S') { startX = j; startY = i; }
				if (cell=='E') { endX = j; endY = i; }
			}
		}
		System.out.println();
	}
}
