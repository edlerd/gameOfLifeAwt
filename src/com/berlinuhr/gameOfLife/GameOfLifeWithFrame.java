package com.berlinuhr.gameOfLife;

public class GameOfLifeWithFrame {
	private final static int frameSize = 100;
	private final GameOfLife game;

	GameOfLifeWithFrame(int size) {
		game = new GameOfLife(size + 2 * frameSize);
	}

	public int getSize() {
		return game.getSize() - 2 * frameSize;
	}

	public void toggleCell(int pi, int pj) {
		int i = normalize(pi);
		int j = normalize(pj);
		game.toggleCell(i, j);
	}

	public boolean isCellAlive(int pi, int pj) {
		int i = normalize(pi);
		int j = normalize(pj);
		return game.isCellAlive(i, j);
	}

	private int normalize(int i) {
		return i + frameSize;
	}

	public void step() {
		game.step();
	}
}
