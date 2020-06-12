package gameOfLifeAwk;

public class Simulation extends Thread {
	private Controller controller;
	private volatile int speed = 400;
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
				Thread.sleep(speed);
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
		if (speed > 100) {
			speed -= 100;
		}
	}

	public void slower() {
		speed += 100;
	}
}
