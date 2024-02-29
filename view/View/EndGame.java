package view.View;

import javax.swing.*;

import view.Model;
import view.View.Utile.RoundBtn;

import java.awt.*;
import java.awt.event.ActionListener;

public class EndGame extends JPanel{
    private Model model;
    private JPanel win;
    private JPanel loose;
    private static JButton rejouer;
    private static JButton quitter;
    public EndGame(Model m){
        super();
        this.model=m;
        if(model.getPartie().getTour().isGagne()){
            win();
        }else{
            loose();
        }
    }

    private void win(){
        win=new JPanel();
        JLabel text=new JLabel();
        text.setText("Vous avez gagné !");
        text.setFont(new Font("Arial", Font.PLAIN, 40));
        win.add(text);
        
        RoundBtn roundBtn = new RoundBtn(50);
        Dimension dim = new Dimension(200, 80);
        Insets insets = new Insets(10, 10, 10, 10);
        Font font = new Font("Arial", Font.PLAIN, 20);
        //Edit rejouer
        rejouer=new JButton("Rejouer");
        rejouer.setFont(font);
        rejouer.setPreferredSize(dim);
        rejouer.setMargin(insets);
        rejouer.setBorder(roundBtn);
        rejouer.setHorizontalAlignment(JButton.CENTER);
        rejouer.setVerticalAlignment(JButton.CENTER);
        //edit quitter
        quitter=new JButton("Quitter");
        quitter.setFont(font);
        quitter.setPreferredSize(dim);
        quitter.setMargin(insets);
        quitter.setBorder(roundBtn);
        quitter.setHorizontalAlignment(JButton.CENTER);
        quitter.setVerticalAlignment(JButton.CENTER);

        win.add(rejouer);
        win.add(quitter);
        this.add(win);
    }

    private void loose(){
        loose=new JPanel();
        JLabel text=new JLabel();
        text.setText("Vous avez perdu !");
        text.setFont(new Font("Arial", Font.PLAIN, 40));
        loose.add(text);
        rejouer=new JButton("Rejouer");
        quitter=new JButton("Quitter");
        loose.add(rejouer);
        this.add(loose);
    }


    public static void addRejouerListener(ActionListener listener) {
        rejouer.addActionListener(listener);
        rejouer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rejouer.setForeground(new Color(255, 242, 0));
                rejouer.setBackground(new Color(36, 36, 36));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                rejouer.setForeground(new Color(36, 36, 36));
                rejouer.setBackground(new Color(255, 242, 0));
            }
        });
    }

    public static void addQuitterListener(ActionListener listener) {
        quitter.addActionListener(listener);
        quitter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                quitter.setForeground(new Color(255, 242, 0));
                quitter.setBackground(new Color(36, 36, 36));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                quitter.setForeground(new Color(36, 36, 36));
                quitter.setBackground(new Color(255, 242, 0));
            }
        });
    }
}
