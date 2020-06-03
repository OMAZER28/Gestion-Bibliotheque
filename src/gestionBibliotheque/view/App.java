package gestionBibliotheque.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class App extends JFrame {
	private static final long serialVersionUID = 1L;
	private CardLayout cl;
	private JPanel contentPane;
	private JPanel cards;
	private JScrollPane scrollPane;
	private SignIn signInPage;
	private SignUpEtudiant signUpEtudiantPage;
	private SignUpEnseignant signUpEnseignantPage;
	private SignUpBibliothecaire signUpBibliothecairePage;
	private Home homePage;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App app = new App();
					app.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
					app.setSize(800,600);
					app.setLocationRelativeTo(null);
					app.setBackground(Color.WHITE);
	                app.setVisible(true); 
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
        cards.add(signInPage, "sign in page");
        
        signUpEtudiantPage = new SignUpEtudiant(cl, cards, false, true, true);
        cards.add(signUpEtudiantPage, "sign up etudiant page");
        
        signUpEnseignantPage = new SignUpEnseignant(cl, cards, true, false, true);
        cards.add(signUpEnseignantPage, "sign up enseignant page");
        
        signUpBibliothecairePage = new SignUpBibliothecaire(cl, cards, true, true, false);
        cards.add(signUpBibliothecairePage, "sign up bibliothecaire page");
        
        
        
        homePage = new Home(cl, cards);
        cards.add(homePage, "home page");
        
		contentPane = new JPanel(cl);
        contentPane.setBackground(Color.WHITE);
        contentPane.add(cards);
        
        scrollPane = new JScrollPane(contentPane);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        setContentPane(scrollPane);

        cl.show(cards, "First Panel");
        
	}
}


