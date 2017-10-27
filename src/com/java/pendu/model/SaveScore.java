package com.java.pendu.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
//import java.io.FileWriter;
import java.io.IOException;
/*import java.io.InputStreamReader;
import java.io.LineNumberReader;*/
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.java.pendu.vue.Score;

public class SaveScore {

	private FileInputStream fis = null;
	/*private InputStreamReader isr = null;
	private LineNumberReader lnr = null;*/	
	private FileInputStream fis2 = null;
	private BufferedInputStream bif = null;
	private ObjectInputStream ois = null;
	private FileOutputStream fos = null;
	private BufferedOutputStream bof = null;
	private ObjectOutputStream oos = null;
	
	//private FileWriter fw = null;
	
	/*private String line = "";
	private String text = "";*/
	private Score[] listScores = null;
	private Score score = null;
	
	public SaveScore() {
				
	}
	
	public void read() {
		
		/*try {
			
			File f = new File("file/score.txt");
			f.createNewFile();
			this.fis = new FileInputStream(f);
			this.isr = new InputStreamReader(this.fis, "ISO-8859-1");
			this.lnr = new LineNumberReader(this.isr);
			
			while(this.lnr.getLineNumber() < 10 && (this.line = this.lnr.readLine()) != null) {
				
				this.setText(this.getText() + System.getProperty( "line.separator" ) + this.line);
				
			}	
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException f) {
			
			f.printStackTrace();
			
		} finally {
			
			try {
				
				if(lnr != null)
					lnr.close();
				if(isr != null) 			
					isr.close();									
				if(fis != null) 			
					fis.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
				
		}*/
		
		try {
			
			File f = new File("file/score.src");
			f.createNewFile();
			
			if(f.length() > 0){
				
				this.fis2 = new FileInputStream(f);
				this.bif = new BufferedInputStream(this.fis2);
				this.ois = new ObjectInputStream(this.bif);
				this.setListScores((Score[]) ois.readObject());
			
			} else {
				
				this.setListScores(new Score[10]);
				for(int i = 0; i < 10; i++) {
					
					this.getListScores()[i] = new Score();
				}
				
			}
									
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException f) {
			
			f.printStackTrace();
			
		}  catch (ClassNotFoundException g) {
				
				g.printStackTrace();
				
		} finally {
			
			try {
				
				if(fis != null) 			
					fis.close();
				if(bif != null) 			
					bif.close();					
				if(ois != null)
					ois.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			} 
				
		}
		
	}

	public void write() {
		
		/*System.out.println("write savescore");
		try {
			
			this.fw = new FileWriter("file/score.txt", true);					
			this.fw.write(this.line);
			this.fw.flush();
			
		} catch (IOException f) {
			
			f.printStackTrace();
			
		} finally {
			
			try {
				
				if(this.fw != null) 			
					this.fw.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
				
		}*/
		
		try {
			
			File f = new File("file/score.src");
			f.createNewFile();
			this.fos = new FileOutputStream(f);
			this.bof = new BufferedOutputStream(this.fos);
			this.oos = new ObjectOutputStream(this.bof);
						
			for(Score score : this.listScores)
				System.out.println(score.toString());
			
			this.acceptScore();
			
			for(Score score : this.listScores)
				System.out.println(score.toString());
			
			oos.writeObject((Object[]) this.listScores);

			oos.flush();
			bof.flush();
			fos.flush();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException f) {
			
			f.printStackTrace();
			
		} finally {
			
			try {
				if(ois != null)
					ois.close();			
				if(bif != null) 			
					bif.close();					
				if(fis != null) 			
					fis.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			} 
				
		}
	}
	
	public void acceptScore() {
		
		Score current = this.score;
		Score memory = new Score();
		
		int i = 0;
		
		for(Score score : this.listScores) {
			if(current.getScore() > score.getScore()) {
				
				System.out.println(i + " " + listScores[i].toString());
				
				System.out.println("memory : " + memory.toString());
				memory = this.listScores[i];
				System.out.println("memory : " + memory.toString());
				System.out.println("current :" + current.toString());
				this.listScores[i] = current;
				current = memory;
				
			}
			i++;			
		}
		
	}
		
	/*public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String getLine() {
		return this.line;
	}

	public void setLine(String line) {
		this.line = line;
	}*/

	public Score[] getListScores() {
		return this.listScores;
	}

	public void setListScores(Score[] listScores) {
		this.listScores = listScores;
	}

	public void setScore(Score score) {
		this.score = score;		
	}
	
	public Score getScore() {
		return this.score;
	}
	
	
}
