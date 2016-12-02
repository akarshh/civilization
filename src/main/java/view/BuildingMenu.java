package view;

import controller.GameController;
import javafx.scene.control.Button;
import model.Building;
import javafx.scene.media.AudioClip;

/**
 * This class should represents the bulding menu
 */
public class BuildingMenu extends AbstractMenu {
    /**
    * there should be an invest and demolish button for this menu
    * as well as functions associated with the buttons
    */
    public BuildingMenu() {
        super();
        Button investButton = new Button("Invest");
        investButton.setMinWidth(100);
        investButton.setOnMousePressed(e -> {
                new AudioClip("File:./src/main/audio/recruit.wav").play();
                if (GameController.getLastClicked().getTile().getOccupant()
                        .isBuilding() && GameController.getCivilization()
                        .getTreasury().getCoins() >= 25) {
                    ((Building) GameController.getLastClicked().getTile()
                            .getOccupant()).invest();
                    GameController.getCivilization().getTreasury().spend(25);
                    GameController.getLastClicked().updateTileView();
                    GameController.updateResourcesBar();
                }
            });
        addMenuItem(investButton);
        Button demolishButton = new Button("Demolish");
        demolishButton.setMinWidth(100);
        demolishButton.setOnMousePressed(e -> {
                new AudioClip("File:./src/main/audio/alert.wav").play();
                if (GameController.getLastClicked().getTile().getOccupant()
                        .isBuilding()
                        && GameController.getCivilization()
                        .getNumSettlements() > 1) {
                    ((Building) GameController.getLastClicked().getTile()
                    .getOccupant()).demolish();
                    GameController.getLastClicked().updateTileView();
                    GameController.updateResourcesBar();
                    GridFX.update();
                }
            });
        addMenuItem(demolishButton);
    }
}
