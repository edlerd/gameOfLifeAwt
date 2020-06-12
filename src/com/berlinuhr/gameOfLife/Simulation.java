package com.berlinuhr.gameOfLife;

import java.util.concurrent.atomic.AtomicInteger;

public class Simulation extends Thread {
	private final Controller controller;
	private final AtomicInteger delay = new AtomicInteger(400);
	private volatile boolean isPaused = false;

	Simulation(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void run() {
		while (true) {
			if (!isPaused) {
				controller.step();
			}
			try {
				Thread.sleep(delay.intValue());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void play() {
		isPaused = false;
		if (!this.isAlive()) {
			this.start();
		}
	}

	public void pause() {
		isPaused = true;
	}

	public void reset() {
		pause();
		controller.reset();
	}

	public void faster() {
		if (delay.intValue() > 0) {
			delay.getAndAdd(-100);
		}
	}

	public void slower() {
		delay.getAndAdd(100);
	}
}
