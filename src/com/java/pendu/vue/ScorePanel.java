package com.java.pendu.vue;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.java.pendu.model.SaveScore;

public class ScorePanel extends JPanel {

	private static final long serialVersionUID = -513725074141909506L;
	
	private JPanel containerLeft = new JPanel();
	private JPanel containerRight = new JPanel();
	
	private JLabel img = new JLabel(new ImageIcon("images/7.jpg"));
	//private JTextArea text = new JTextArea();
	private JTextArea objects = new JTextArea();
	

	
	public ScorePanel() {
		
		this.initText();
		
		this.setBackground(Color.WHITE);
		
		this.containerRight.setBackground(Color.WHITE);
		this.containerLeft.setBackground(Color.WHITE);
				
		this.containerRight.add(this.img, BorderLayout.CENTER);
		this.containerLeft.setLayout(new BoxLayout(this.containerLeft, BoxLayout.PAGE_AXIS));
		//this.containerLeft.add(this.text);
		this.containerLeft.add(this.objects);
		this.containerLeft.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		this.add(this.containerLeft);
		this.add(this.containerRight);

	}
	
	public void initText() {
		
		SaveScore ss = new SaveScore();
		ss.read();
				
		//this.text = new JTextArea(ss.getText());
		if(ss.getListScores() != null) {
			for(Score score : ss.getListScores()) {
				if(score.getNbr() != 0) {
					System.out.println(score.getPseudo());
					this.objects.setText(this.objects.getText() + "\n" + score.toString());
					System.out.println("=======");
				}
			}
		}
	}
	
	
	
	public int calcul(int error) {
				
		switch(error) {
		
			case(0) :
				return 100;
	
			case(1) :
				return 50;
			
			case(2) :
				return 35;
			
			case(3) :
				return 25;
			
			case(4) :
				return 15;
			
			case(5) :
				return 10;
			
			default :
				return 5;			
		}
	}

}
