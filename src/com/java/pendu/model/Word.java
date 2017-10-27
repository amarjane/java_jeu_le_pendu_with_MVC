package com.java.pendu.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class Word {

	private FileInputStream fis = null;
	private InputStreamReader isr = null;
	private LineNumberReader lnr = null;
	private String choosenWord;
	int nbr;
	
	public Word() {
		
		this.nbr = (int)(Math.random()*336529);
		this.chooseWord(this.nbr);
		
	}
	
	public void chooseWord(int nbr) {
		
		try {
			
			this.fis = new FileInputStream("file/word.txt");
			this.isr = new InputStreamReader(this.fis, "ISO-8859-1");
			this.lnr = new LineNumberReader(this.isr);
			
			while(lnr.getLineNumber() != nbr) {
				
				lnr.readLine();
			}
			
			this.setChoosenWord(lnr.readLine());
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException f) {
			
			f.printStackTrace();
			
		} finally {
			
			try {
				if(fis != null) 			
					fis.close();
				if(isr != null) 			
						isr.close();					
				if(lnr != null)
					lnr.close();
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
				
		}
		
		System.out.println(this.getChoosenWord());
				
	}
	
	public String getChoosenWord() {
		return this.choosenWord;
	}

	public void setChoosenWord(String choosenWord) {
		this.choosenWord = choosenWord;
	}
	

}
