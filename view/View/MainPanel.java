package view.View;

import view.Controller.EndGameController;
import view.Controller.PlateauController;
import view.Controller.RucheController;
import view.View.Utile.RoundBtn;
import view.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static view.View.View.cardLayout;
import static view.View.View.cards;

public class MainPanel extends JPanel {
    private Model model;
    static JButton retour = new JButton("Retour");
    public static Timer timer;

    public MainPanel(Model m) {
        this.model = m;
        this.setBackground(new Color(0, 128, 0));
        JPanel main = new JPanel(new BorderLayout());
        main.setBackground(new Color(0, 128, 0));
        JPanel ruche = new JPanel(new BorderLayout());
        ruche.setBackground(new Color(0, 128, 0));
        ruche.add(new Ruche(), BorderLayout.CENTER);
        new RucheController(model);
        Miel miel = new Miel(model);
        miel.setBackground(new Color(0, 128, 0));
        main.add(miel, BorderLayout.NORTH);

        Plateau plateau = new Plateau(model);
        EnsembleFilet ensembleFilet = new EnsembleFilet(Plateau.rows, m);
        ensembleFilet.setBackground(new Color(0, 128, 0));
        ruche.add(ensembleFilet, BorderLayout.EAST);
        main.add(plateau, BorderLayout.CENTER);
        timer = new Timer(2500, e -> {
            // Mettez à jour la vue ici
            SwingUtilities.updateComponentTreeUI(this);
            plateau.afficheG();
            ensembleFilet.update();
            System.out.println("Mise à jour de la vue et AVANCE MainPAnel ");
            model.getPartie().getTour().getMap().maj();
            if (model.getPartie().getTour().isGagne() || model.getPartie().getTour().isPerdu()) {
                timer.stop();
                cards.add(new EndGame(model), "EndGame");
                new EndGameController();
                cardLayout.show(cards, "EndGame");
            }
        });
        timer.start();
        main.setVisible(true);


        // EDIT RETOUR
        RoundBtn roundBtn = new RoundBtn(50);
        Dimension dim = new Dimension(200, 80);
        Insets insets = new Insets(10, 10, 10, 10);
        Font font = new Font("Arial", Font.PLAIN, 20);

        retour.setFont(font);
        retour.setPreferredSize(dim);
    
        retour.setBorder(roundBtn);
        retour.setHorizontalAlignment(JButton.CENTER);
        retour.setVerticalAlignment(JButton.CENTER);

        // On met le controller ici, psq sinon le controller ne sera pas crée
        new PlateauController(model);
        JPanel beeChoice = new JPanel(new FlowLayout());
        beeChoice.add(new BeeChoice(model));
        main.add(ruche, BorderLayout.WEST);
        beeChoice.add(retour);
        beeChoice.setBackground(new Color(0, 128, 0));
        main.add(beeChoice, BorderLayout.SOUTH);
        this.add(main, BorderLayout.CENTER);

    }

    public static void addRetourListener(ActionListener listener) {
        retour.addActionListener(listener);
        retour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                retour.setForeground(new Color(255, 242, 0));
                retour.setBackground(new Color(36, 36, 36));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                retour.setForeground(new Color(36, 36, 36));
                retour.setBackground(new Color(255, 242, 0));
            }
        });
    }

    public static JButton getRetour() {
        return retour;
    }
}
