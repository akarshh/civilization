package view;

import controller.GameController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import model.Unit;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;
import model.TerrainTile;
import model.Civilization;
/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class RecruitMenu extends AbstractMenu {
    /**
    * recuit menu should have a list of worker/units
    * to choose from. There should also be a select button
    * and the function of the button should be implemented
    *here
    */
    public RecruitMenu() {
        super();
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Insufficient Resources");
        alert.setHeaderText("Can't recruit this unit");
        alert.setContentText("Please select another action");
        ListView<String> unitListView = new ListView<>();
        ObservableList<String> unitList =
                FXCollections.observableArrayList("Melee Unit", "Ranged Unit",
                        "Hybrid Unit", "Siege Unit", "Settlers", "Farmers",
                        "Coal Miners", "Anglers", "Master Builders");
        unitListView.setItems(unitList);
        addMenuItem(unitListView);
        Button selectButton = new Button("Seelct");
        selectButton.setMinWidth(100);
        Civilization c = GameController.getCivilization();
        TerrainTile t = GameController.getLastClicked().getTile();
        selectButton.setOnMousePressed(e -> {
                new AudioClip("File:./src/main/audio/recruit.wav").play();
                switch (unitListView.getSelectionModel().getSelectedItem()) {
                case "Melee Unit":
                    if (((Unit) c.getMeleeUnit()).isAffordable()) {
                        t.setOccupant(GameController.getCivilization()
                            .getMeleeUnit());
                        ((Unit) t.getOccupant().getOwner().getMeleeUnit())
                            .applyInitialCosts();
                    } else {
                        new AudioClip("File:./src/main/audio/alert.wav").play();
                        alert.showAndWait();
                    }
                    break;
                case "Ranged Unit":
                    if (((Unit) c.getRangedUnit()).isAffordable()) {
                        t.setOccupant(GameController.getCivilization()
                            .getRangedUnit());
                        ((Unit) t.getOccupant().getOwner().getRangedUnit())
                            .applyInitialCosts();
                    } else {
                        new AudioClip("File:./src/main/audio/alert.wav").play();
                        alert.showAndWait();
                    }
                    break;
                case "Hybrid Unit":
                    if (((Unit) c.getHybridUnit()).isAffordable()) {
                        t.setOccupant(GameController.getCivilization()
                            .getHybridUnit());
                        ((Unit) t.getOccupant().getOwner().getHybridUnit())
                            .applyInitialCosts();
                    } else {
                        new AudioClip("File:./src/main/audio/alert.wav").play();
                        alert.showAndWait();
                    }
                    break;
                case "Siege Unit":
                    if (((Unit) c.getSiegeUnit()).isAffordable()) {
                        t.setOccupant(GameController.getCivilization()
                            .getSiegeUnit());
                        ((Unit) t.getOccupant().getOwner().getSiegeUnit())
                            .applyInitialCosts();
                    } else {
                        new AudioClip("File:./src/main/audio/alert.wav").play();
                        alert.showAndWait();
                    }
                    break;
                case "Settlers":
                    TextInputDialog newSettlement = new TextInputDialog();
                    newSettlement.setTitle("A New Settlement");
                    newSettlement.setHeaderText(
                        "You have built a Settlement");
                    newSettlement.setContentText(
                        "Enter the name of your first town");
                    Optional<String> result = newSettlement.showAndWait();
                    if (((Unit) c.getSettlerUnit(result.get()))
                        .isAffordable()) {
                        if (result.isPresent() && !result.get().isEmpty()) {
                            t.setOccupant(GameController.getCivilization()
                                .getSettlerUnit(result.get()));
                            ((Unit) t.getOccupant().getOwner().getSettlerUnit(
                                result.get())).applyInitialCosts();
                            new AudioClip("File:./src/main/audio/success.wav")
                                .play();
                            GameController.updateResourcesBar();
                        } else {
                            new AudioClip("File:./src/main/audio/alert.wav")
                                .play();
                        }
                    } else {
                        new AudioClip("File:./src/main/audio/alert.wav").play();
                        alert.showAndWait();
                    }
                    break;
                case "Farmers":
                    if (((Unit) c.getFarmerUnit()).isAffordable()) {
                        t.setOccupant(GameController.getCivilization()
                            .getFarmerUnit());
                        ((Unit) t.getOccupant().getOwner().getFarmerUnit())
                            .applyInitialCosts();
                    } else {
                        new AudioClip("File:./src/main/audio/alert.wav").play();
                        alert.showAndWait();
                    }
                    break;
                case "Coal Miners":
                    if (((Unit) c.getCoalMinerUnit()).isAffordable()) {
                        t.setOccupant(GameController.getCivilization()
                            .getCoalMinerUnit());
                        ((Unit) t.getOccupant().getOwner().getCoalMinerUnit())
                            .applyInitialCosts();
                    } else {
                        new AudioClip("File:./src/main/audio/alert.wav").play();
                        alert.showAndWait();
                    }
                    break;
                case "Anglers":
                    if (((Unit) c.getAnglerUnit()).isAffordable()) {
                        t.setOccupant(GameController.getCivilization()
                            .getAnglerUnit());
                        t.getOccupant().getOwner().getAnglerUnit()
                            .applyInitialCosts();
                    } else {
                        new AudioClip("File:./src/main/audio/alert.wav").play();
                        alert.showAndWait();
                    }
                    break;
                case "Master Builders":
                    if (((Unit) c.getMasterBuilderUnit()).isAffordable()) {
                        t.setOccupant(GameController.getCivilization()
                            .getMasterBuilderUnit());
                        ((Unit) t.getOccupant().getOwner()
                        .getMasterBuilderUnit()).applyInitialCosts();
                    } else {
                        new AudioClip("File:./src/main/audio/alert.wav").play();
                        alert.showAndWait();
                    }
                    break;
                default:
                    break;
                }
                GameController.updateResourcesBar();
                GridFX.update();
            });
        addMenuItem(selectButton);
    }
}
