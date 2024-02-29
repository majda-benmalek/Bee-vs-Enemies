package view.Controller;

import Model.Diff.Difficile;
import Model.Map;
import Model.PartieG;
import view.Model;
import view.View.ChoixModeJeu;
import view.View.DiffChoice;
import view.View.MainPanel;

import static view.View.View.cardLayout;
import static view.View.View.cards;

public class ChoixModeJeuController {
    private Model model;
    public ChoixModeJeuController(Model m) {
        this.model = m;
        ChoixModeJeu.addValiderListener(e -> validerClicked());
    }

    public void validerClicked(){
        if(!ChoixModeJeu.getNormal().isSelected() && !ChoixModeJeu.getMarathon().isSelected()) {
            System.out.println("pas de mode de jeu choisi");
            ChoixModeJeu.getNormal().getParent().getParent().add(ChoixModeJeu.erreurLabel);
        }else{
            if(ChoixModeJeu.getNormal().isSelected()) {
                cards.add(new DiffChoice(model), "diffChoice");
                new DiffController(model);
                cardLayout.show(cards, "diffChoice");
            } else {
                PartieG.setMarathon(true);
                model.getPartie().setDifficulte(new Difficile(model.getJoueur(), model.getPartie()));
                model.getPartie().setMap(new Map(model.getPartie()));
                cards.add(new MainPanel(model), "plateau");
                new MainController(model);
                cardLayout.show(cards, "plateau");
            }
        }
    }
}
