package view;

import controller.GameController;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.media.AudioClip;

/**
 * Created by RuYiMarone on 11/12/2016.
 */
public class AbstractMenu {
    public static final int PREFWIDTH = 140;
    private Button exploreButton = new Button("Explore");
    private Button endTurnButton = new Button("End Turn");
    private Text terrain = new Text();
    private Text unitStatus = new Text();
    private VBox menu = new VBox(10, terrain, unitStatus,
            exploreButton, endTurnButton);

    public AbstractMenu() {
        menu.setPrefWidth(PREFWIDTH);
        unitStatus.setWrappingWidth(120);
        exploreButton.setMinWidth(100);
        exploreButton.setOnMousePressed(e -> {
                new AudioClip("File:./src/main/audio/move.wav").play();
                GameController.getCivilization().explore();
                // GameController.updateResourcesBar();
                // GridFX.update();
                if (endTurn()) {
                    Alert newAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    newAlert.setHeaderText("Congratulations");
                    newAlert.setTitle("You Won!");
                    newAlert.showAndWait();
                    System.exit(0);
                }
            });
        endTurnButton.setMinWidth(100);
        endTurnButton.setOnAction(event -> {
                if (endTurn()) {
                    new AudioClip("File:./src/main/audio/move.wav").play();
                    Alert newAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    newAlert.setHeaderText("Congratulations");
                    newAlert.setTitle("You Won!");
                    newAlert.showAndWait();
                    System.exit(0);
                }
            });
        menu.setPrefWidth(PREFWIDTH);
        terrain.setFont(Font.font(20));
        terrain.setFill(Color.BLACK);
        unitStatus.setFont(Font.font(16));
        unitStatus.setFill(Color.BLACK);
        updateItems();
    }
    /**
     * This method updates the items and return the vbox as
     * the menu
     */
    public VBox getRootNode() {
        updateItems();
        return menu;
    }
    /**
     * This method takes in a node and added the node as
     * a child of the vbox menu
     */
    public void addMenuItem(Node node) {
        menu.getChildren().add(node);
    }
    /**
     * ends the player's turn and check for winning condition
     */
    public boolean endTurn() {
        GameController.setLastClicked(null);
        GameController.tick();
        GameController.ai();
        GridFX.update();
        GameController.updateResourcesBar();
        if (GameController.getCivilization().getNumSettlements() <= 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Your last settlement has been destroyed!");
            alert.setTitle("Game Over");
            new AudioClip("File:./src/main/audio/joker.mp3").play();
            alert.showAndWait();
            System.exit(0);
        }
        return GameController.getCivilization()
                .getStrategy().conqueredTheWorld()
                || GameController.getCivilization()
                .getTechnology().hasTechnologyWin();
    }

    private void updateItems() {
        unitStatus.setText("");
        if (GameController.getLastClicked() != null) {
            terrain.setText(GameController.getLastClicked()
                    .getTile().getType().toString());
            if (!GameController.getLastClicked().getTile().isEmpty()) {
                unitStatus.setText(GameController.getLastClicked()
                        .getTile().getOccupant().getStatusString());
            }
        }
    }
}
