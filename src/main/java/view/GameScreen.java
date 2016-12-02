package view;

import controller.GameController;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.image.Image;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.layout.CornerRadii;
import javafx.scene.media.AudioClip;


/**
 * This class represents the GameScreen class
 */
public class GameScreen extends BorderPane {

    private static ResourcesMenu resourcesMenu;
    private static GameScreen instance;
    private static Background menuBG;
    /**
     * Creates a new view into the game. this layout should include
     * the rescource bar, grid map, and action menus
     *
     */
    public GameScreen() {
        super();
        new AudioClip("File:./src/main/audio/theme.mp3").play();
        instance = this;
        Background bg = new Background(new BackgroundImage(
            new Image("File:./src/main/java/view/back.jpg"),
            BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
            BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));
        setBackground(bg);
        menuBG = new Background(new BackgroundImage(
        new Image("File:./src/main/java/view/bg.jpg"),
        BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
        BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));
        resourcesMenu = new ResourcesMenu();
        GridFX gridFX = GridFX.getInstance();
        StatusMenu statusMenu = new StatusMenu();
        statusMenu.getRootNode().setBackground(menuBG);
        statusMenu.getRootNode().setAlignment(Pos.CENTER);
        resourcesMenu.getRootNode().setBackground(new Background(
            new BackgroundFill(Color.web(
                "003366"), CornerRadii.EMPTY, Insets.EMPTY)));
        resourcesMenu.getRootNode().setAlignment(Pos.CENTER);
        setTop(resourcesMenu.getRootNode());
        setLeft(statusMenu.getRootNode());
        setCenter(gridFX);
        gridFX.setAlignment(Pos.CENTER);
    }

    /**
     * This method should update the gridfx and the resource bar
     */
    public void update() {
        GridFX.update();
        resourcesMenu.update();
    }
    /**
    * this method should return the resource menu
    * @return reosuce menu
    */
    public static ResourcesMenu getResources() {
        return resourcesMenu;
    }


    /**
     * This method switches menus based on passed in game state.
     * Game.java calls this to selectively control which menus are displayed
     * @param state
     */
    public static void switchMenu(GameController.GameState state) {
        switch (state) {
        case NEUTRAL:
            StatusMenu statusMenu = new StatusMenu();
            instance.setLeft(statusMenu.getRootNode());
            statusMenu.getRootNode().setBackground(menuBG);
            statusMenu.getRootNode().setAlignment(Pos.CENTER);
            break;
        case MILITARY:
            MilitaryMenu militaryMenu = new MilitaryMenu();
            instance.setLeft(militaryMenu.getRootNode());
            militaryMenu.getRootNode().setBackground(menuBG);
            militaryMenu.getRootNode().setAlignment(Pos.CENTER);
            break;
        case BUILDING:
            BuildingMenu buildingMenu = new BuildingMenu();
            instance.setLeft(buildingMenu.getRootNode());
            buildingMenu.getRootNode().setBackground(menuBG);
            buildingMenu.getRootNode().setAlignment(Pos.CENTER);
            break;
        case RECRUITING:
            RecruitMenu recruitMenu = new RecruitMenu();
            instance.setLeft(recruitMenu.getRootNode());
            recruitMenu.getRootNode().setBackground(menuBG);
            recruitMenu.getRootNode().setAlignment(Pos.CENTER);
            break;
        case WORKER:
            WorkerMenu workerMenu = new WorkerMenu();
            instance.setLeft(workerMenu.getRootNode());
            workerMenu.getRootNode().setBackground(menuBG);
            workerMenu.getRootNode().setAlignment(Pos.CENTER);
            break;
        default:
            break;
        }
    }
}
