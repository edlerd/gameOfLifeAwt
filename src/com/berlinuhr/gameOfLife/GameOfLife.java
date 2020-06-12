package com.berlinuhr.gameOfLife;

public class GameOfLife {
	private final int size;
	private volatile boolean[][] world;

	GameOfLife(int size) {
		this.size = size;
		world = new boolean[size][size];
	}

	public void step() {
		boolean[][] nextWorld = new boolean[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				int neighbors = countAliveNeighbors(i, j);
				nextWorld[i][j] = (neighbors == 3) || (world[i][j] && neighbors == 2);
			}
		}
		world = nextWorld;
	}

	private int countAliveNeighbors(int i, int j) {
		return countCell(i-1, j-1) + countCell(i-1, j) + countCell(i-1, j+1)
		     + countCell(i,   j-1)                     + countCell(i,   j+1)
		     + countCell(i+1, j-1) + countCell(i+1, j) + countCell(i+1, j+1);
	}

	private int countCell(int i, int j) {
		if (i < 0 || j < 0 || i >= size || j >= size) {
			return 0;
		}
		return isCellAlive(i, j) ? 1 : 0;
	}

	public int getSize() {
		return size;
	}

	public void toggleCell(int i, int j) {
		world[i][j] = !isCellAlive(i, j);
	}

	public boolean isCellAlive(int i, int j) {
		return world[i][j];
	}
}
