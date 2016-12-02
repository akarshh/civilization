package runner;

import controller.GameController;
import model.Map;
import view.CivEnum;
import view.GridFX;
import model.QinDynasty;
import model.RomanEmpire;
import model.Egypt;
import model.Bandit;
import model.Skaikru;
import model.Mordor;
import model.StarkDynasty;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.StartScreen;
import view.GameScreen;
import java.util.Optional;
import javafx.scene.control.TextInputDialog;
import model.Civilization;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.control.Alert;
/**
 * Created by Tian-Yo Yang on 11/11/2016.
 */
public class CivilizationGame extends Application {

    private Stage primaryStage;
    private CivEnum selectedCivilization;
    private Civilization thisCivilization;
    private static int mapSize;
    /**
     * this method is called upon running/launching the application
     * this method should display a scene on the stage
     */
    public void start(Stage aPrimaryStage) throws Exception {
        this.primaryStage = aPrimaryStage;
        primaryStage.setTitle("CS1331's Civilization");
        StartScreen startScreen = new StartScreen();
        startScreen.getStartButton().addEventHandler(MouseEvent.MOUSE_CLICKED,
            (MouseEvent event) -> {
                if (startScreen.getCivList()
                        .getSelectionModel().getSelectedItem() != null) {
                    selectedCivilization =
                            startScreen.getCivList().getSelectionModel()
                                    .getSelectedItem();
                    new AudioClip("File:./src/main/audio/success.wav").play();
                    startGame();
                } else {
                    new AudioClip("File:./src/main/audio/alert.wav").play();
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Invalid Selection");
                    alert.setHeaderText("No Civilization selected");
                    alert.setContentText("Please select a civilization");
                    alert.showAndWait();
                }
            });
        primaryStage.setScene(new Scene(startScreen, 850, 725));
        primaryStage.show();
    }
    /**
     * This is the main method that launches the javafx application
     */
    public static void main(String[] args) {
        launch(args);
    }
    /**
    * This method is responsible for setting the scene to the corresponding
    * layout.
    * and returning the scene.
    * @return Scene
    */

    public Scene startGame() {
        TextInputDialog newSettlement = new TextInputDialog();
        newSettlement.setTitle("A New Settlement");
        newSettlement.setHeaderText("You have built a Settlement");
        newSettlement.setContentText("Enter the name of your first town");
        Optional<String> result = newSettlement.showAndWait();
        switch (selectedCivilization) {
        case ANCIENT_EGYPT:
            thisCivilization = new Egypt();
            break;
        case QIN_DYNASTY:
            thisCivilization = new QinDynasty();
            break;
        case ROMAN_EMPIRE:
            thisCivilization = new RomanEmpire();
            break;
        case SKAIKRU:
            thisCivilization = new Skaikru();
            break;
        case STARK_DYNASTY:
            thisCivilization = new StarkDynasty();
            break;
        case MORDOR:
            thisCivilization = new Mordor();
            break;
        default:
            break;
        }
        new AudioClip("File:./src/main/audio/success.wav").play();
        GameController.setCivilization(thisCivilization);
        if (result.isPresent() && !result.get().isEmpty()) {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Dynamic Map");
            dialog.setHeaderText("Enter size");
            dialog.setContentText("Enter nXn grid size");
            Optional<String> newResult = dialog.showAndWait();
            if (newResult.isPresent()) {
                try {
                    int i = Integer.parseInt(newResult.get());
                    if (i > 0) {
                        mapSize = i;
                    } else {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Invalid size");
                        alert.setHeaderText("Using default size");
                        alert.setContentText("Creating 10X10 grid");
                        alert.showAndWait();
                        mapSize = 10;
                    }
                } catch (NumberFormatException e) {
                    mapSize = 10;
                }
            } else {
                mapSize = 10;
            }
            GridFX.setInstance(mapSize);
            Map.putSettlement(result.get(), thisCivilization, 0, mapSize - 1);
            final Bandit bandit = new Bandit();
            GameController.setBandits(bandit);
            Map.addEnemies(bandit, 1, mapSize);
        } else {
            new AudioClip("File:./src/main/audio/alert.wav").play();
        }
        final Scene scene = new Scene(new GameScreen());
        primaryStage.sizeToScene();
        primaryStage.setScene(scene);
        GridFX.update();
        return scene;
    }
    public static int getMapSize() {
        return mapSize;
    }
}
