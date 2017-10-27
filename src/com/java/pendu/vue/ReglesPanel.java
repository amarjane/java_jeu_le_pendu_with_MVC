package com.java.pendu.vue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


public class ReglesPanel extends JPanel{

	private static final long serialVersionUID = 5336912488108493756L;

	public ReglesPanel() {

		this.setBackground(Color.WHITE);
		
		JLabel title = new JLabel("le jeu du PENDU :");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("Arial", Font.BOLD, 26));
		title.setBackground(Color.WHITE);
		
		JTextArea area = new JTextArea("\n\n\n\nVous avez 7 coups pour trouver le mot caché ! Et si vous réussissez : on recommence !" +
						"\n\n" +
						"Plus vous avez trouvé de mots, plus votre score grandira !! Alors à vous de jouer !\n" +
						"COMPTE DES POINTS :\n\n" +
						"\tMot trouvé sans erreur : ..........100Pts" +
						"\n" +
						"\tMot trouvé avec 1 erreur :..........50Pts" +
						"\n" +
						"\tMot trouvé avec 2 erreurs :.........35Pts" +
						"\n" +
						"\tMot trouvé avec 3 erreurs :.........25Pts" +
						"\n" +
						"\tMot trouvé avec 4 erreurs :.........15Pts" +
						"\n" +
						"\tMot trouvé avec 5 erreurs :.........10Pts" +
						"\n" +
						"\tMot trouvé avec 6 erreurs :...........5Pts" +
						"\n\n" +
						"Je vous souhaite bien du plaisir..." +
						"\n\n" +
						"Et, si vous pensez pouvoir trouver un mot en un coup, c'est que vous pensez que le dictionnaire est petit !" +
						"\n\n" +
						"Hors, pour votre information, il comprend plus de 336 000 mots... Donc bonne chance !! :)");
		
		area.setFont(new Font("Arial", Font.BOLD, 14));
		area.setEditable(false);
		area.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		this.setLayout(new BorderLayout())	;
		this.add(title, BorderLayout.NORTH);
		this.add(area, BorderLayout.CENTER);
		
	}
}
