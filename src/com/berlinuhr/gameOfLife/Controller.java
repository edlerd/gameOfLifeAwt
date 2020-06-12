package com.berlinuhr.gameOfLife;

import java.awt.Button;
import java.awt.Color;

public class Controller {
	GameOfLifeWithFrame game;
	Button[][] buttons;

	public Controller(int size) {
		this.game = new GameOfLifeWithFrame(size);
		this.buttons = new Button[size][size];
	}

	public Button createCell(int i, int j) {
		buttons[i][j] = new Button();
		buttons[i][j].setBackground(Color.BLACK);
		buttons[i][j].addActionListener(e -> handleButtonClick(i, j));
		return buttons[i][j];
	}

	public void handleButtonClick(int i, int j) {
		game.toggleCell(i, j);
		repaint();
	}

	public void step() {
		game.step();
		repaint();
	}

	public void repaint() {
		for (int i = 0; i < game.getSize(); i++) {
			for (int j = 0; j < game.getSize(); j++) {
				Color c = game.isCellAlive(i, j) ? Color.WHITE : Color.BLACK;
				buttons[i][j].setBackground(c);
			}
		}
	}

	public void reset() {
		game = new GameOfLifeWithFrame(game.getSize());
		this.repaint();
	}
}
