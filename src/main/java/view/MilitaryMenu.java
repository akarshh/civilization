package view;

import controller.GameController;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;

/**
 * Created by William on 11/11/2016.
 */

public class MilitaryMenu extends AbstractMenu {
    /**
    * Implement the buttons and actions associated with
    * the buttons for the military menu
    */
    public MilitaryMenu() {
        super();
        Button attackButton = new Button("Attack");
        attackButton.setMinWidth(100);
        attackButton.setOnMousePressed(e -> {
                new AudioClip("File:./src/main/audio/attack.wav").play();
                GameController.attacking();
                GameController.updateResourcesBar();
            });
        addMenuItem(attackButton);

        Button moveButton = new Button("Move");
        moveButton.setMinWidth(100);
        moveButton.setOnMousePressed(e -> {
                new AudioClip("File:./src/main/audio/move.wav").play();
                GameController.moving();
            });
        addMenuItem(moveButton);

    }
}
