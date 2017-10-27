package com.java.pendu.vue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


public class WelcomePanel extends JPanel{

	private static final long serialVersionUID = -5448665234702694106L;

	public WelcomePanel() {
		
		JLabel title = new JLabel("Bienvenue dans le jeu du PENDU");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("Arial", Font.BOLD, 26));
	
		
		JLabel image =  new JLabel(new ImageIcon("images/7.jpg"));
		image.setPreferredSize(new Dimension(200, 200));
		
		
		JTextPane textPane = new JTextPane();
		textPane.setText("Vous avez 7 coups pour trouver le mot caché ! Et si vous réussissez... et bien on recommence !\n" +
			"Plus vous avez trouvé de mots, plus votre score grandira !! Alors à vous de jouer !\n" +
			"PROVERBE : \t\"Pas vu pas pris!\n" +
			"\tPris ! PENDU !!!!!\"");
		
		textPane.setFont(new Font("Arial", Font.BOLD, 16));
		textPane.setEditable(false);
		
		StyledDocument doc = textPane.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
	
		//this.setPreferredSize(new Dimension(700, 700));
		this.setBackground(Color.WHITE);
		
		this.setLayout(new BorderLayout());
		this.add(title, BorderLayout.NORTH);
		this.add(image, BorderLayout.CENTER);
		this.add(textPane, BorderLayout.SOUTH);
		
	}
	
}
