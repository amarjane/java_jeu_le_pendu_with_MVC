package com.java.pendu.vue;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import com.java.pendu.controler.Controler;
import com.java.pendu.model.SaveScore;


public class Fenetre extends JFrame {
	
	private static final long serialVersionUID = -3418924343273506578L;

	private JMenuItem nouveau = new JMenuItem("New");
	private JMenuItem scores = new JMenuItem("Scores");
	private JMenuItem regles = new JMenuItem("Règles");
	private JMenuItem quitter = new JMenuItem("Quitter");
	private JMenuItem credits = new JMenuItem("?");
	
	private JMenu fichier = new JMenu("Fichier");
	private JMenu aPropos = new JMenu("À propos");
		
	private JMenuBar menuBar = new JMenuBar();
	
	private JPanel container = new JPanel();
	
	private NewPanel newPanel;
	private ReglesPanel reglesPanel;
	private ScorePanel scorePanel;
	private WelcomePanel welcomePanel;
	
	/*private JOptionPane confirmation = new JOptionPane();
	private JOptionPane saisie = new JOptionPane();
	*/
	
	private Thread t;
	
	private ActionEvent event;
	
	private int answer;
	private String pseudo;
	
	private BarPanel barPanel;
	
	private Dimension dim;
		
	public Fenetre() {
		
		this.setBarPanel(new BarPanel());
		
		try {
			Thread.sleep(10*500);		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		this.getBarPanel().setVisible(false);
		
		this.setSize(900, 700);		
		this.setTitle("Pendu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.dim = new Dimension(this.getWidth(), this.getHeight());
		
		this.initMenu();
		
		this.welcomePanel = new WelcomePanel();
		this.initComponent(this.welcomePanel);
		
		this.initAction();
		
		this.container.setSize(this.dim);
		this.setContentPane(this.container);
		
	}
	
	private void initComponent(JPanel panel) {
				
		System.out.println("init");
		
		panel.setPreferredSize(this.dim);
		this.container.removeAll();
		this.container.setLayout(new BorderLayout());
		this.container.add(panel, BorderLayout.CENTER);
		this.container.revalidate();
		
	}
	
	private void initMenu() {
		
		this.nouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		this.scores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		this.regles.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
		this.quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
		
		this.fichier.setMnemonic('F');
		this.aPropos.setMnemonic('p');
		
		this.fichier.add(this.nouveau);
		this.fichier.add(this.scores);
		this.fichier.addSeparator();
		this.fichier.add(this.quitter);
		
		this.aPropos.add(this.regles);
		this.aPropos.add(this.credits);
		
		this.menuBar.add(this.fichier);
		this.menuBar.add(this.aPropos);
		
		this.setJMenuBar(this.menuBar);
				
	}
	
	public void initAction() {
		
		this.regles.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {				
				reglesPanel = new ReglesPanel();
				initComponent(reglesPanel);			
			}			
		});		
		
		this.quitter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {				
				System.exit(0);			
			}			
		});	
		
		this.nouveau.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				newPanel = new NewPanel();
				newPanel.init();
				initComponent(newPanel);
				initAction();
				
			}			
		});
		
		if(this.newPanel != null) {
			for(JButton button : this.newPanel.getKeyboardPanel().getButtons()) {
				
				button.addActionListener(new ActionListener(){
	
					@Override
					public void actionPerformed(ActionEvent f) {
						
						event = f;
						t = new Thread(new GoRunnable());
						
						t.start();
						
						
					}
					
					
				});
			}
		}
		
		this.scores.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				scorePanel = new ScorePanel();
				initComponent(scorePanel);
				
			}			
		});
		
		this.credits.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
					"Créateur : Abdelaziz Marjane\nLicence : Freeware\nCredits marjane.abdelaziz@gmail.com",
					"Informations",
					 JOptionPane.INFORMATION_MESSAGE);
			
				
			}
			
			
		});
			
		
	}
	
	public class GoRunnable implements Runnable {
		
		public void run() {
			
			go(event);
			
		}
		
	}
	
	public void go(ActionEvent f) {
		
		String letter = ((JButton) f.getSource()).getText();
		
		Controler controler = new Controler(this.newPanel.getChoosenWord(), 
				this.newPanel.getSecretWord(), letter);
		
		if(!controler.getLetterFinded()) {
			
			this.newPanel.setError(this.newPanel.getError() + 1);	
			
		} 
				
		if(this.newPanel.getError() < 7){
			
			this.newPanel.setSecretWord(controler.getSecretWord());
			this.newPanel.init(this.newPanel.getChoosenWord(), controler.getSecretWord());
			this.initComponent(this.newPanel);
			((JButton) f.getSource()).setEnabled(false);
			
		} else {
			
			this.setAnswer(JOptionPane.showConfirmDialog(null, 
					"Game Over !! You Lose ! Do you want to replay ?", 
					"Informations", 
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE));
			
			if(this.getAnswer() == JOptionPane.YES_OPTION) {
				
				int nbr = this.newPanel.getNbr();
				int score = this.newPanel.getScore();
				this.newPanel = new NewPanel(nbr, score);
				this.initComponent(this.newPanel);
				this.initAction();
				
			} else {
				
				this.save();
				this.initComponent(new WelcomePanel());
				this.initAction();
				
			}
			
		}							
		
		if (controler.getWordFinded()) {
			int nbr = newPanel.getNbr() + 1;
			int score = new ScorePanel().calcul(newPanel.getError());
						
			this.setAnswer(JOptionPane.showConfirmDialog(null, 
					"Congratulations !! You win !\n" +
					"You find the secret word with " + this.newPanel.getError() + " errors\n" +
					"You obtain the score of " + score + "\n" +
					"Do you want to replay ?", 
					"Informations", 
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE));
			
			score += this.newPanel.getScore();
			this.newPanel = new NewPanel(nbr, score);
			
			if(this.getAnswer() == JOptionPane.YES_OPTION) {				
				
				this.initComponent(newPanel);
				this.initAction();
				
			} else {
				
				this.save();
				this.initComponent(new WelcomePanel());
				this.initAction();
				
			}



		}
		
		
		
	}
	
	public void save() {
		
		String myPseudo = JOptionPane.showInputDialog(null, 
				"Enter your pseudo for saving scores : ",
				"Saving Scores",
				JOptionPane.WARNING_MESSAGE
		);
		
		
		this.setPseudo((myPseudo.isEmpty() ? "Anonyme" : myPseudo));
		
		SaveScore ss = new SaveScore();
		
		ss.read();
				
		/*ss.setLine(System.getProperty("line.separator") + this.getPseudo() + 
				"-> " +
				this.newPanel.getScore() + 
				" Pts (" +
				this.newPanel.getNbr() +
				" mots)");*/
		
		ss.setScore(new Score(
				this.getPseudo(), 
				this.newPanel.getScore(), 
				this.newPanel.getNbr()));
		
		ss.write();
		
	}

	public static void main(String[] args) {
		
		Fenetre fen = new Fenetre();
		fen.setVisible(true);
		
	}

	public NewPanel getNewPanel() {
		return newPanel;
	}

	public void setNewPanel(NewPanel newPanel) {
		this.newPanel = newPanel;
	}

	public ReglesPanel getReglesPanel() {
		return reglesPanel;
	}

	public void setReglesPanel(ReglesPanel reglesPanel) {
		this.reglesPanel = reglesPanel;
	}

	public ScorePanel getScorePanel() {
		return scorePanel;
	}

	public void setScorePanel(ScorePanel scorePanel) {
		this.scorePanel = scorePanel;
	}

	public WelcomePanel getWelcomePanel() {
		return welcomePanel;
	}

	public void setWelcomePanel(WelcomePanel welcomePanel) {
		this.welcomePanel = welcomePanel;
	}


	public ActionEvent getEvent() {
		return event;
	}

	public void setEvent(ActionEvent event) {
		this.event = event;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public BarPanel getBarPanel() {
		return barPanel;
	}

	public void setBarPanel(BarPanel barPanel) {
		this.barPanel = barPanel;
	}

}
