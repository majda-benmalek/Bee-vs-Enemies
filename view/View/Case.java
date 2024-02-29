package view.View;

import Perso.Bee.Abeille;
import Perso.Bee.Butineuse;
import Perso.Bee.Sniper;
import Perso.Bee.Venimeuse;
import Perso.Ennemi.Araignee;
import Perso.Ennemi.Chenille;
import Perso.Ennemi.Ennemis;
import Perso.Ennemi.Frelon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class Case extends JPanel {
    public int i;
    public int j;
    public String entite = "";
    private JLabel item;
    private ImageIcon img;

    public Case(int i, int j) {
        this.i = i;
        this.j = j;
        this.setPreferredSize(new Dimension(80, 80)); 
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.item = new JLabel();
        if ((i + j) % 2 == 0) {
            this.setBackground(new Color(50, 205, 50, 255));
        } else {
            this.setBackground(new Color(144, 238, 144, 255));
        }
        javax.swing.Timer timer = new Timer(100, e -> {
            this.updateUI();
        });
    }

    public Case(int i) {
        this.i = i;
        ImageIcon img = new ImageIcon("Ressources/net.png");
        img.setImage(img.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
        this.item = new JLabel(img);
        this.setPreferredSize(new Dimension(80, 80));
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(item);
        this.setBackground(new Color(0, 128, 0));
        javax.swing.Timer timer = new Timer(1000, e -> {
            this.updateUI();
        });
    }

    public void update(String l) {
        this.remove(item);
        item.setIcon(null);
        switch (l) {
            case "S" -> {
                img = new ImageIcon("Ressources/sniper.png");

                img.setImage(img.getImage().getScaledInstance(50, 50, 50));
                item.setIcon(img);
            }
            case "B" -> {
                img = new ImageIcon("Ressources/butineuse.png");
                img.setImage(img.getImage().getScaledInstance(50, 50, 50));
                item.setIcon(img);

            }
            case "V" -> {
                img = new ImageIcon("Ressources/venimeuse.png");
                img.setImage(img.getImage().getScaledInstance(55, 55, 50));
                item.setIcon(img);
            }
        }
        this.add(item);
        this.revalidate();
        this.repaint();

    }

    public void update(ImageIcon image) {
        if (this.item != null) {
            Image img = image.getImage();
            Image newImg = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            ImageIcon scaledImage = new ImageIcon(newImg);
            this.remove(item);
            this.item.setIcon(scaledImage);
            this.add(item);
            this.revalidate();
            this.repaint();
        }
    }

    public void updateEtatEnnemi(Ennemis e) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                if (e instanceof Araignee) {
                    item.setIcon(null);
                    ImageIcon img = new ImageIcon("Ressources/sickSpider.png");
                    img.setImage(img.getImage().getScaledInstance(55, 55, 50));
                    remove(item);
                    item.setIcon(img);
                }
                if (e instanceof Chenille) {
                    item.setIcon(null);
                    ImageIcon img = new ImageIcon("Ressources/sickChenille.png");
                    img.setImage(img.getImage().getScaledInstance(55, 55, 50));
                    remove(item);
                    item.setIcon(img);
                }
                if (e instanceof Frelon) {
                    item.setIcon(null);
                    ImageIcon img = new ImageIcon("Ressources/sickWasp.png");
                    img.setImage(img.getImage().getScaledInstance(55, 55, 50));
                    remove(item);
                    item.setIcon(img);
                }

                add(item);
                repaint();
                revalidate();

            }
        });
        if (e.getPv() < 35) {
            this.setBackground(null);
            this.setBackground(new Color(194, 76, 76, 187));
        }
    }

    public void updateEtatAbeille(Abeille a) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                if (a instanceof Butineuse) {
                    item.setIcon(null);
                    ImageIcon img = new ImageIcon("Ressources/notButine.png");
                    img.setImage(img.getImage().getScaledInstance(55, 55, 50));
                    remove(item);
                    item.setIcon(img);
                }
                if (a instanceof Sniper) {
                    item.setIcon(null);
                    ImageIcon img = new ImageIcon("Ressources/sadSniper.png");
                    img.setImage(img.getImage().getScaledInstance(55, 55, 50));
                    remove(item);
                    item.setIcon(img);
                }
                if (a instanceof Venimeuse) {
                    item.setIcon(null);
                    ImageIcon img = new ImageIcon("Ressources/sadVenimeuse.png");
                    img.setImage(img.getImage().getScaledInstance(55, 55, 50));
                    remove(item);
                    item.setIcon(img);
                }
                add(item);
                repaint();
                revalidate();

            }
        });
    }

    public void update() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                remove(item);
                repaint();
                revalidate();
            }
        });
    }

    public void addCaseClickListener(MouseAdapter listener) {
        this.addMouseListener(listener);
    }
}
