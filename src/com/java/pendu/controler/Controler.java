package com.java.pendu.controler;

import java.util.Arrays;

public class Controler {

	private String choosenWord;
	private String secretWord;
	private String clavierLetter;
 
	private boolean wordFinded = false;
	private boolean letterFinded;
	
	public Controler() {
						
	}
	
	public Controler(String choosenWord, String secretWord, String letter) {
		
		this.choosenWord = choosenWord;
		this.secretWord = secretWord;
		this.clavierLetter = letter;
		this.verify(this.clavierLetter, this.choosenWord);
		
	}
	
	public void verify(String letter, String word) {
		
		String newSecretWord = "";
		
		for(int i = 0; i < word.length(); i++) {
			
			if(this.accent(word.toUpperCase().charAt(i)) == letter.charAt(0)) {
				
				newSecretWord += word.toUpperCase().charAt(i);
				this.setLetterFinded(true);
				
			}
				
			else {
				
				newSecretWord += this.secretWord.toUpperCase().charAt(i);
				
			}
				

			
		}
		
		this.setSecretWord(newSecretWord);	
		
		if(this.secretWord.indexOf('*') == -1)
			this.setWordFinded(true);
		
	}
	
	public char accent(char c) {
		
		
		if(Arrays.asList(new char[]{'É', 'È', 'Ê', 'Ë'}).contains(c))
			return 'E';
		else if("ÉÈÊË".indexOf(c) != -1)
			return 'E';
		else if("ÀÂÄ".indexOf(c) != -1)
			return 'A';
		else if("ÎÏ".indexOf(c) != -1)
			return 'I';				
		else if("ÔÖ".indexOf(c) != -1)
			return 'O';		
		else if("ÛÜ".indexOf(c) != -1)
			return 'U';
		else if('Ç' == c)
			return 'C';
		else
			return c;
		
	}

	public String getSecretWord() {
		return secretWord;
	}

	public void setSecretWord(String secretWord) {
		this.secretWord = secretWord;
	}

	public String getClavierLetter() {
		return clavierLetter;
	}

	public void setClavierLetter(String clavierLetter) {
		this.clavierLetter = clavierLetter;
	}

	public void setLetterFinded(boolean find) {
		this.letterFinded = find;
	}

	public boolean getLetterFinded() {
		return this.letterFinded;
	}
	
	public void setWordFinded(boolean find) {
		this.wordFinded = find;
	}

	public boolean getWordFinded() {
		return this.wordFinded;
	}
	

}
