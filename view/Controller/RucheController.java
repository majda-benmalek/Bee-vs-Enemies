package view.Controller;

import view.Model;
import view.View.Miel;
import view.View.Ruche;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RucheController {
    private Model model;
    public RucheController(Model m) {
        this.model = m;
        Ruche.addLabelClickListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Code à exécuter lors du clic sur le label
                rucheClicked();
            }
        });
    }

    private void rucheClicked() {
        model.getPartie().getTour().ruche();
        // Update la vue de miel

        Timer timer = new Timer(1000, e -> {
            Miel.updateMiel();
        });
        timer.start();
    }
}
