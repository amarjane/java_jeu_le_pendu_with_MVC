package com.java.pendu.vue;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;


public class BarPanel extends JFrame {

	private static final long serialVersionUID = -7862749022393614070L;
	
	private JProgressBar bar = new JProgressBar();
	
	private JPanel container = new JPanel();
	
	private Thread t= new Thread();
	
	public BarPanel() {
		this.bar.setMaximum(500);
		this.bar.setMinimum(0);
		this.bar.setStringPainted(true);
		
		t = new Thread(new Traitement());
		t.start();
		
		
		this.container.setLayout(new BorderLayout());
		this.container.add(this.bar, BorderLayout.CENTER);

		this.setContentPane(this.container);
		
		this.setSize(900, 50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Le Pendu,   Licence : Freeware, Créateur : Abdelaziz Marjane, Copyright : marjane.abdelaziz@gmail.com");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

	class Traitement implements Runnable {
		public void run() {
			
			
			for(int val = 0; val <= 500; val++) {
				bar.setValue(val);
				
				try {
					Thread.sleep(10);		
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
			}
			
			
		}		
	}
		
	

}
