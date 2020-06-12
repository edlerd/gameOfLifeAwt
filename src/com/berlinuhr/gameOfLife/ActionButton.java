package com.berlinuhr.gameOfLife;

import java.awt.Button;
import java.awt.event.ActionListener;

public class ActionButton extends Button {
	private static final long serialVersionUID = 1L;

	public ActionButton(String label, ActionListener listener) {
		super(label);
		addActionListener(listener);
	}
}
