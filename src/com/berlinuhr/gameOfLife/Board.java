package com.berlinuhr.gameOfLife;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Board extends Frame {
	private static final long serialVersionUID = 1L;

	Board() {
		final int size = 40;
		Controller controller = new Controller(size);
		Simulation simulation = new Simulation(controller);

		setSize(900, 900);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);

		Panel world = new Panel(new GridLayout(size, size));
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				world.add(controller.createCell(i, j));
			}
		}
		add(world, BorderLayout.CENTER);

		Panel actions = new Panel(new FlowLayout());
		actions.add(new ActionButton("step", e -> controller.step()));
		actions.add(new ActionButton("simulate", e -> simulation.play()));
		actions.add(new ActionButton("pause", e -> simulation.pause()));
		actions.add(new ActionButton("faster", e -> simulation.faster()));
		actions.add(new ActionButton("slower", e -> simulation.slower()));
		actions.add(new ActionButton("reset", e -> simulation.reset()));
		actions.add(new ActionButton("randomize", e -> controller.randomize()));
		add(actions, BorderLayout.SOUTH);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);
	}

	public static void main(String[] args) {
		new Board();
	}
}
