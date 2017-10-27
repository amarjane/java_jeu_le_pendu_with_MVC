package com.java.pendu.vue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.java.pendu.model.Word;



public class NewPanel extends JPanel {

	private static final long serialVersionUID = -3320115402876163750L;

	private JLabel img;
	private int error = 0;

	private JTextField nbrWord;
	private JTextField scoreText = new JTextField("Score actuel : " + this.score);
	private JTextField word = new JTextField("");
	
	private KeyboardPanel KeyboardPanel = new KeyboardPanel();
	
	private JPanel containerLeft = new JPanel();
	private JPanel containerRight = new JPanel();
	private JPanel headRight = new JPanel();
	
	private int nbr = 0;
	private int score = 0;
	
	private String secretWord = "";
	private String choosenWord;
	
	public NewPanel() {
					
	}
	
	public NewPanel(int nbr, int score) {
		
		this.setScore(score);
		this.setNbr(nbr);
		this.init();
		
	}
	
	public NewPanel(String choosenWord, String secretWord) {
		
		this.choosenWord = choosenWord;
		this.secretWord = secretWord;
		this.init(choosenWord, secretWord);
			
	}
	
	public void init() {
		
		this.initWord();
		this.initScoreText();
		this.initNbrWord();	
		this.initNouveau();	
		
	}
	
	public void init(String choosenWord, String secretWord) {
		
		this.initWord(secretWord);
		this.initScoreText();
		this.initNbrWord();	
		this.initNouveau();	
		
	}
	
	public void initNouveau() {
		
		this.setBackground(Color.WHITE);
		
		this.containerLeft.setBackground(Color.WHITE);
		this.containerRight.setBackground(Color.WHITE);
		this.KeyboardPanel.setBackground(Color.WHITE);
		
		this.KeyboardPanel.setPreferredSize(new Dimension(400, 200));
		this.headRight.setPreferredSize(new Dimension(400, 200));
		
		this.headRight.setLayout(new BorderLayout());
		this.headRight.add(this.nbrWord, BorderLayout.NORTH);
		this.headRight.add(this.scoreText, BorderLayout.CENTER);
		this.headRight.add(this.word, BorderLayout.SOUTH);
		
		this.containerLeft.setLayout(new BorderLayout());
		this.containerLeft.add(this.headRight, BorderLayout.NORTH);
		this.containerLeft.add(this.KeyboardPanel, BorderLayout.CENTER);
		
		this.containerRight.setLayout(new BorderLayout());
		this.img = new JLabel(new ImageIcon("images/" + this.error + ".jpg"));
		this.containerRight.removeAll();
		this.containerRight.add(this.img, BorderLayout.CENTER);
		
		//this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		this.add(this.containerLeft);
		this.add(this.containerRight);
		
	}
	
	public void initWord() {
				
		this.word.setFont(new Font("Arial", Font.BOLD, 24));
		this.word.setForeground(Color.BLUE);
		this.word.setBorder(BorderFactory.createEmptyBorder());
		this.word.setHorizontalAlignment(JTextField.CENTER);
		
		this.choosenWord = (new Word()).getChoosenWord();
		
		for(int i = 0; i < this.choosenWord.length(); i++) {
			this.setSecretWord(this.getSecretWord() + "*");
		}
		
		this.word.setText(this.getSecretWord());
		
	}
	
	public void initWord(String secretWord) {
		
		this.word.setFont(new Font("Arial", Font.BOLD, 24));
		this.word.setForeground(Color.BLUE);
		this.word.setBorder(BorderFactory.createEmptyBorder());
		this.word.setHorizontalAlignment(JTextField.CENTER);				
		this.word.setText(secretWord);
				
	}
	
	
	public void initScoreText() {		
		
		this.scoreText = new JTextField("Votre score actuel est de : " + this.score);
		this.scoreText.setBorder(BorderFactory.createEmptyBorder());
		this.scoreText.setHorizontalAlignment(JTextField.CENTER);
		this.scoreText.setFont(new Font("Arial", Font.BOLD, 20));
		
	}
	
	public void initNbrWord() {	
		
		this.nbrWord = new JTextField("Nombre de mot trouvé : " + this.nbr);
		this.nbrWord.setBorder(BorderFactory.createEmptyBorder());
		this.nbrWord.setHorizontalAlignment(JTextField.CENTER);
		this.nbrWord.setFont(new Font("Arial", Font.BOLD, 20));	
		
	}
	

	public String getSecretWord() {
		return this.secretWord;
	}

	public void setSecretWord(String secretWord) {
		this.secretWord = secretWord;
	}
		
	public String getChoosenWord() {
		return this.choosenWord;
	}

	public void setChoosenWord(String choosenWord) {
		this.choosenWord = choosenWord;
	}
	
	public KeyboardPanel getKeyboardPanel() {
		return this.KeyboardPanel;
	}

	public void setKeyboardPanel(KeyboardPanel KeyboardPanel) {
		this.KeyboardPanel = KeyboardPanel;
	}
	
	public int getError() {		
		return this.error;
	}
	
	public void setError(int error) {		
		this.error = error;
	}
	
	public void setNbr(int nbr) {		
		this.nbr = nbr;
	}
	
	public int getNbr() {		
		return this.nbr;
	}
	
	public void setScore(int score) {		
		this.score = score;
	}
	
	public int getScore() {	
		return this.score;
	}
}

