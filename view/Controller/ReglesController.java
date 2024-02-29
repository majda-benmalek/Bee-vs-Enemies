package view.Controller;


import view.View.*;

import static view.View.View.cardLayout;
import static view.View.View.cards;

import view.Model;

public class ReglesController {
    private Model model;
    public ReglesController(Model m) {
        this.model = m;
        Regles.addRetourListener(e -> retourClicked());
        Regles.addSuivantListener(e -> suivantClicked());
    }

    private void suivantClicked() {
        Regles.getSuivant().getParent().setVisible(false);
        cards.add(new DiffChoice(model), "diffChoice");
        new DiffController(model);
        cardLayout.show(cards, "diffChoice");
    }

    private void retourClicked() {
        Regles.getRetour().getParent().setVisible(false);
        cards.add(new Menu(), "menu");
        new MenuController(model);
        cardLayout.show(cards, "menu");
    }
}
