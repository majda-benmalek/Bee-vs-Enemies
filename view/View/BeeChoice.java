package view.View;

import Perso.Bee.Abeille;
import view.Model;

import javax.swing.*;
import java.awt.*;

public class BeeChoice extends JPanel {
    private JLabel sniper;
    private JLabel butineuse;
    private JLabel venimeuse;
    private ImageIcon sniperIcon;
    private ImageIcon butineuseIcon;
    private ImageIcon venimeuseIcon;
    ImageIcon prix = new ImageIcon("Ressources/honey.png");
    private Model model;

    private JTable table;

    public BeeChoice(Model m) {
        super();
        this.setBackground(new Color(0, 128, 0));
        this.model = m;
        this.setLayout(new FlowLayout());
        prix.setImage(prix.getImage().getScaledInstance(20, 20, 50));
        Abeille[] abeilles = model.getJoueur().getAbeilles();
        if (abeilles[0] != null) {
            //SNIPER
            //Creation de l'image
            sniperIcon = new ImageIcon("Ressources/sniper.png");
            sniperIcon.setImage(sniperIcon.getImage().getScaledInstance(100, 100, 50));
            //Creation du label image
            sniper = new JLabel();
            sniper.setIcon(sniperIcon);
            //Creation Label prix
            JLabel prixSniper = new JLabel("25", prix, SwingConstants.CENTER);
            //Creation Label nom
            JLabel nomSniper = new JLabel("Sniper", SwingConstants.CENTER);
            //Creation du panel
            JPanel sniperPanel = new JPanel();
            sniperPanel.setLayout(new BorderLayout());
            sniperPanel.setSize(new Dimension(100, 100));
            sniperPanel.add(sniper, BorderLayout.CENTER);
            sniperPanel.add(nomSniper, BorderLayout.NORTH);
            sniperPanel.add(prixSniper, BorderLayout.SOUTH);
            sniperPanel.setBorder(BorderFactory.createLineBorder(Color.black, 5));

            this.add(sniperPanel);
        }
        if (abeilles[1] != null) {
            //BUTINEUSE
            //Creation de l'image
            butineuseIcon = new ImageIcon("Ressources/butineuse.png");
            butineuseIcon.setImage(butineuseIcon.getImage().getScaledInstance(100, 100, 50));
            //Creation du label image
            butineuse = new JLabel();
            butineuse.setIcon(butineuseIcon);
            //Creation Label prix
            JLabel prixButineuse = new JLabel("30", prix, SwingConstants.CENTER);
            //Creation Label nom
            JLabel nomButineuse = new JLabel("Butineuse", SwingConstants.CENTER);
            //Creation du panel
            JPanel butineusePanel = new JPanel();
            butineusePanel.setLayout(new BorderLayout());
            butineusePanel.setSize(new Dimension(100, 100));
            butineusePanel.add(butineuse, BorderLayout.CENTER);
            butineusePanel.add(nomButineuse, BorderLayout.NORTH);
            butineusePanel.add(prixButineuse, BorderLayout.SOUTH);
            butineusePanel.setBorder(BorderFactory.createLineBorder(Color.black, 5));

            this.add(butineusePanel);
        }

        if (abeilles[2] != null) {
            //VENIMEUSE
            //Creation de l'image
            venimeuseIcon = new ImageIcon("Ressources/venimeuse.png");
            venimeuseIcon.setImage(venimeuseIcon.getImage().getScaledInstance(100, 100, 50));
            //Creation du label image
            venimeuse = new JLabel();
            venimeuse.setIcon(venimeuseIcon);
            //Creation Label prix
            JLabel prixVenimeuse = new JLabel("50", prix, SwingConstants.CENTER);
            //Creation Label nom
            JLabel nomVenimeuse = new JLabel("Venimeuse", SwingConstants.CENTER);
            //Creation du panel
            JPanel venimeusePanel = new JPanel();
            venimeusePanel.setLayout(new BorderLayout());
            venimeusePanel.setSize(new Dimension(100, 100));
            venimeusePanel.add(venimeuse, BorderLayout.CENTER);
            venimeusePanel.add(nomVenimeuse, BorderLayout.NORTH);
            venimeusePanel.add(prixVenimeuse, BorderLayout.SOUTH);
            venimeusePanel.setBorder(BorderFactory.createLineBorder(Color.black, 5));

            this.add(venimeusePanel);
        }
    }

}
