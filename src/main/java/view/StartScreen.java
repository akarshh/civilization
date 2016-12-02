package view;

import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
/**
 * Created by Tian-Yo Yang on 11/11/2016.
 * This class represents the Start Screen for the Civ applicatios. This is the
 * layout that should be displayed upon running the Civ application.
 *
 * This class should have and display
 * 1. a background
 * 2. a list of Civilizations
 * 3. a Start button
 */
public class StartScreen extends StackPane {

    private Button startButton;
    private ListView<CivEnum> civilizationsListView;
    /**
    * constuctor of the start screen. Should set the background
    * image and display a list of civilizations and a start button
    */
    public StartScreen() {

        super();
        ImageView image = new ImageView(
            "File:./src/main/java/view/civ_background.png");
        Label instructionLabel = new Label("Select a civilization to begin");
        instructionLabel.setTextFill(Color.RED);
        instructionLabel.setFont(Font.font(26));
        civilizationsListView = new ListView<>();
        ObservableList<CivEnum> civilizationsList =
            FXCollections.observableArrayList(CivEnum.values());
        civilizationsListView.setItems(civilizationsList);
        startButton = new Button("START");
        getChildren().addAll(image, civilizationsListView, instructionLabel,
            startButton);
        setMargin(civilizationsListView, new Insets(440, 300, 130, 300));
        setMargin(instructionLabel, new Insets(100, 0, 0, 0));
        setMargin(startButton, new Insets(550, 0, 0, 0));

    }
    /**
    * gets the start button
    * @return the start button
    */
    public Button getStartButton() {
        return startButton;
    }
    /**
    * return a ListView of CivEnums representing the list of
    * available civilizations to choose from
    * @return listview of CivEnum
    */
    public ListView<CivEnum> getCivList() {
        return civilizationsListView;
    }
}
