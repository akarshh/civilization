package view;

import controller.GameController;
import javafx.scene.control.Alert;
import model.Convertable;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class WorkerMenu extends AbstractMenu {
    /**
    * There should be a convert and move button
    * as well as the functions associated with those
    * buttons
    */
    public WorkerMenu() {
        super();
        Button moveButton = new Button("Move");
        moveButton.setMinWidth(100);
        moveButton.setOnMousePressed(e -> {
                new AudioClip("File:./src/main/audio/move.wav").play();
                GameController.moving();
            });
        addMenuItem(moveButton);

        Button convertButton = new Button("Convert");
        convertButton.setMinWidth(100);
        convertButton.setOnMousePressed(e -> {
                if (GameController.getLastClicked().getTile().getOccupant()
                        .isWorker() && ((Convertable) GameController
                        .getLastClicked().getTile().getOccupant()).canConvert(
                        GameController.getLastClicked().getTile().getType())) {
                    GameController.getLastClicked().getTile().setOccupant(
                        ((Convertable) GameController.getLastClicked()
                        .getTile().getOccupant()).convert());
                    GameController.getLastClicked().updateTileView();
                    new AudioClip("File:./src/main/audio/success.wav")
                        .play();
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Can't convert selected unit");
                    alert.setHeaderText("Selected unit can't be converted");
                    alert.setContentText("Try another action");
                    alert.showAndWait();
                    new AudioClip("File:./src/main/audio/alert.wav").play();
                }
                GameController.updateResourcesBar();
            });
        addMenuItem(convertButton);
    }
}
