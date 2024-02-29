package view.Controller;

import view.View.ChoixModeJeu;
import view.View.Menu;
import view.View.Regles;

import static view.View.View.cardLayout;
import static view.View.View.cards;

import view.Model;

public class MenuController {
    private Model model;
    public MenuController(Model m) {
        this.model = m;
        Menu.addJouerListener(e -> jouerClicked());
        Menu.addQuitterListener(e -> quitterClicked());
        Menu.addReglesListener(e -> reglesClicked());

    }

    private void quitterClicked() {
        System.exit(0);
    }


    public void jouerClicked() {
        Menu.getJouer().getParent().setVisible(false);
        cards.add(new ChoixModeJeu(model),"choixModeJeu");
        new ChoixModeJeuController(model);
        cardLayout.show(cards,"choixModeJeu");
    }

    public void reglesClicked() {
        Menu.getJouer().getParent().setVisible(false);
        cards.add(new Regles(), "regles");
        new ReglesController(model);
        cardLayout.show(cards, "regles");
    }

}
