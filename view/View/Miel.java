package view.View;

import Model.PartieG;
import view.Model;

import javax.swing.*;
import java.awt.*;

public class Miel extends JPanel {
    private static JLabel honey;
    private static Model model;
    public static JLabel vague;
    public static JLabel tour;

    public Miel(Model m) {
        super();
        model = m;
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));

        // Creation de l'image
        ImageIcon img = new ImageIcon("Ressources/honey.png");
        Icon imgR = resize(img, 40, 40);

        // Creation du label image miel
        honey = new JLabel("Miel: " + model.getJoueur().getMiel());
        honey.setIcon(imgR);

        // Creation du label difficulte/mode de jeu
        JLabel difficulte = new JLabel();
        JLabel modeJeu=new JLabel();
        if (!PartieG.isMarathon()) {
            modeJeu.setText("Mode de jeu: Normal");
            difficulte.setText("Difficulté: " + model.getPartie().getDifficulte().getD());
        } else {
            modeJeu.setText("Mode de jeu: Marathon");
        }
        // Creation du label nom
        JLabel name = new JLabel("Nom: " + model.getJoueur().getName());

        //creation du label Vague
        vague=new JLabel("Vague: "+model.getPartie().getTour().nbVague);

        // Creation du panel miel
        JPanel miel = new JPanel();
        miel.setLayout(new FlowLayout());
        miel.add(name);
        miel.add(new JSeparator(SwingConstants.VERTICAL));
        miel.add(honey);
        miel.add(new JSeparator(SwingConstants.VERTICAL));
        if (!PartieG.isMarathon()) {
            miel.add(difficulte);
            miel.add(new JSeparator(SwingConstants.VERTICAL));
        }
        miel.add(modeJeu);
        if(!PartieG.isMarathon()){
            miel.add(new JSeparator(SwingConstants.VERTICAL));
            miel.add(vague);
        }else{
            miel.add(new JSeparator(SwingConstants.VERTICAL));
            tour=new JLabel("Tour: "+model.getPartie().getTour().nbTour);
            miel.add(tour);
        }
        miel.setFont(new Font("Arial", Font.PLAIN, 44));
        this.add(miel);
    }

    public static ImageIcon resize(ImageIcon icon, int w, int h) {
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }

    // Update la vue du miel
    public static void updateMiel() {
        honey.setText("Miel: " + model.getJoueur().getMiel());
    }
    public static void updateVague(){
        vague.setText("Vague: "+model.getPartie().getTour().nbVague);
    }
    public static void updateTour(){
        tour.setText("Tour: "+model.getPartie().getTour().nbTour);
    }
}
