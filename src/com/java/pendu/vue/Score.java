package com.java.pendu.vue;

import java.io.Serializable;

public class Score implements Serializable {

	private static final long serialVersionUID = 8758738412956208344L;
	
	private String pseudo = "Empty";
	private int score = 0;
	private int nbr = 0;
	
	public Score() {
		pseudo = "Empty";
		score = 0;
		nbr = 0;
	}
	
	public Score(String pseudo, int score, int nbr) {
		
		this.setPseudo(pseudo);
		this.setScore(score);
		this.setNbr(nbr);
				
	}
	
	public String toString() {
		return pseudo + " -> " + this.score + " Pts (" + this.nbr + " mots)";
	}

	public String getPseudo() {
		return this.pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getNbr() {
		return this.nbr;
	}

	public void setNbr(int nbr) {
		this.nbr = nbr;
	}	
}