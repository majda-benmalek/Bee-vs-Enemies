package view.Controller;

import Model.HoneyException;
import Model.IllegalBeeException;
import Model.IllegalPosException;
import view.Model;
import view.View.Case;
import view.View.Miel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CaseController {
    private final Case c;
    private final Model model;
    private final JOptionPane optionPane = new JOptionPane();

    public CaseController(Case c, Model m) {
        this.c = c;
        this.model = m;
        c.addCaseClickListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == c) {
                    System.out.println("MouseClicked");
                    caseClicked();
                }
            }
        });
    }

    public void caseClicked() {


        ImageIcon img = new ImageIcon("Ressources/bee.png");
        img.setImage(img.getImage().getScaledInstance(50, 50, 50));

        String option = null;

        option = (String) JOptionPane.showInputDialog(c.getParent().getParent(),
                "Quel type d'abeille voulez vous poser ? (S, B,V)", "Poser une abeille",
                JOptionPane.QUESTION_MESSAGE,
                img, null, null);
        JOptionPane dialog = new JOptionPane();
        dialog.setOptionType(JOptionPane.DEFAULT_OPTION);
        dialog.setWantsInput(false);
        ImageIcon img1 = new ImageIcon("Ressources/error.png");
        img1.setImage(img1.getImage().getScaledInstance(50, 50, 50));
        dialog.setIcon(img1);

        if (option != null) {
            try {
                model.getPartie().getDifficulte().poser(option, c.i, c.j);
                model.getPartie().getMap().affiche();
                Miel.updateMiel();

                c.update(option);
            } catch (IllegalPosException e) {
                dialog.setMessage("Vous ne pouvez pas poser d'abeille ici.");
                dialog.setMessageType(JOptionPane.ERROR_MESSAGE);
                JDialog d = dialog.createDialog(null, "Erreur");
                d.setVisible(true);
            } catch (HoneyException e) {
                dialog.setMessage("Vous n'avez pas assez de miel pour poser cette abeille.");
                dialog.setMessageType(JOptionPane.ERROR_MESSAGE);
                JDialog d = dialog.createDialog(null, "Erreur");
                d.setVisible(true);
            } catch (IllegalBeeException e) {
                dialog.setMessage("Veuillez entrer un caractère valide.");
                dialog.setMessageType(JOptionPane.ERROR_MESSAGE);
                JDialog d = dialog.createDialog(null, "Erreur");
                d.setVisible(true);
            }

        }
    }
}
