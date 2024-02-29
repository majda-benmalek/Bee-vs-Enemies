package view.Controller;

import Model.Diff.Difficile;
import Model.Diff.Facile;
import Model.Diff.Moyen;
import Model.Map;
import view.Model;
import view.View.ChoixModeJeu;
import view.View.DiffChoice;
import view.View.MainPanel;

import static view.View.DiffChoice.erreurLabel;
import static view.View.View.cardLayout;
import static view.View.View.cards;

public class DiffController {
    private Model model;

    public DiffController(Model m) {
        this.model = m;
        DiffChoice.addFacileListener(e -> facileClicked());
        DiffChoice.addMoyenListener(e -> moyenClicked());
        DiffChoice.addDifficileListener(e -> difficileClicked());
        DiffChoice.addValiderListener(e -> validerClicked());
    }

    public void facileClicked() {
        model.getPartie().setDifficulte(new Facile(model.getJoueur(), model.getPartie()));
        model.getPartie().setMap(new Map(model.getPartie()));
    }

    public void moyenClicked() {
        model.getPartie().setDifficulte(new Moyen(model.getJoueur(), model.getPartie()));
        model.getPartie().setMap(new Map(model.getPartie()));
    }

    public void difficileClicked() {
        model.getPartie().setDifficulte(new Difficile(model.getJoueur(), model.getPartie()));
        model.getPartie().setMap(new Map(model.getPartie()));

    }

    public void validerClicked() {
        if (!DiffChoice.getFacile().isSelected() && !DiffChoice.getMoyen().isSelected()
                && !DiffChoice.getDifficile().isSelected()) {
            DiffChoice.getFacile().getParent().getParent().add(erreurLabel);
        } else {
            DiffChoice.getValider().getParent().setVisible(false);
            model.getJoueur().setName(ChoixModeJeu.getNomJoueur().getText());
            //CREATION DU PLATEAU
            cards.add(new MainPanel(model), "plateau");
            new MainController(model);
            cardLayout.show(cards, "plateau");
        }
    }
}
