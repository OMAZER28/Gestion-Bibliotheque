package gestionBibliotheque.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import gestionBibliotheque.model.utilisateurs.Adherant;
import gestionBibliotheque.model.utilisateurs.Bibliothecaire;
import gestionBibliotheque.model.utilisateurs.Utilisateur;

public class App extends JFrame {
	private static final long serialVersionUID = 1L;
	private CardLayout cl;
	private JPanel cards;
	private SignIn signInPage;
	private SignUpEtudiant signUpEtudiantPage;
	private SignUpEnseignant signUpEnseignantPage;
	private SignUpBibliothecaire signUpBibliothecairePage;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App app = new App();
					app.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
					app.setBounds(105,125,1050,595);
					app.setBackground(Color.WHITE);
	                app.setVisible(true);
	                
                    Dimension d=app.getSize();
                    d.width=700;
                    d.height=580;
                    app.setMinimumSize(d);
	                
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public App() {
		
		cl = new CardLayout();
		cards = new JPanel(cl);
		cards.setBackground(Color.WHITE);
		
		signInPage = new SignIn(cl, cards);
		signInPage.setBackground(new Color(238,238,238));
		
        cards.add(signInPage, "sign in page");
        
        signUpEtudiantPage = new SignUpEtudiant(cl, cards, false, true, true);
        signUpEtudiantPage.setBackground(new Color(238,238,238));
        cards.add(signUpEtudiantPage, "sign up etudiant page");
        
        signUpEnseignantPage = new SignUpEnseignant(cl, cards, true, false, true);
        signUpEnseignantPage.setBackground(new Color(238,238,238));
        cards.add(signUpEnseignantPage, "sign up enseignant page");
        
        signUpBibliothecairePage = new SignUpBibliothecaire(cl, cards, true, true, false);
        signUpBibliothecairePage.setBackground(new Color(238,238,238));
        cards.add(signUpBibliothecairePage, "sign up bibliothecaire page");
        
        setContentPane(cards);

        cl.show(cards, "sign in page");
        
	}
}


