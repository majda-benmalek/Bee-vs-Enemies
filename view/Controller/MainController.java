package view.Controller;

import view.View.MainPanel;
import view.View.Menu;
import static view.View.View.cards;
import view.Model;

import static view.View.View.cardLayout;

public class MainController {
    private Model model;
    public MainController(Model m) {
        this.model = m;
        MainPanel.addRetourListener(e -> retourClicked());
    }

    public void retourClicked(){
        MainPanel.timer.stop();
        MainPanel.getRetour().getParent().setVisible(false);
        cards.add(new Menu(), "menu");
        new MenuController(model);
        cardLayout.show(cards, "menu");
    }
}
