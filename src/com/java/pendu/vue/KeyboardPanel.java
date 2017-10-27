package com.java.pendu.vue;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


public class KeyboardPanel extends JPanel {

	private static final long serialVersionUID = 5098877700704914724L;

	private String[] letters = {"A", "B", "C", "D", "E", "F", "G",
			"H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
			"S", "T", "U", "V", "W", "X", "Y", "Z", "-"
	};
	
	private JButton[] buttons = new JButton[27];
	
	public KeyboardPanel() {
		
		this.setLayout(new GridLayout(4, 7));
		int i = 0;
		
		for(String letter : this.letters) {
			
			this.buttons[i] = new JButton(letter);
			this.buttons[i].setFont(new Font("Arial", Font.BOLD, 20));
			this.buttons[i].setPreferredSize(new Dimension(26,26));
			this.add(this.buttons[i]);
			i++;
			
		}
				
	}

	public JButton[] getButtons() {
		return this.buttons;
	}
	
}
