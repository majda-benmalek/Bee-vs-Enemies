package view.Controller;

import view.Model;
import view.View.EndGame;
import view.View.View;

public class EndGameController {

    public EndGameController() {
        EndGame.addRejouerListener(e -> rejouerClicked());
        EndGame.addQuitterListener(e -> quitterClicked());
    }

    public void rejouerClicked() {
        Model model = new Model();
        new Controller(model, new View(model));
    }
    public void quitterClicked() {
        System.exit(0);
    }
}
