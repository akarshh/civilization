package view;

import controller.GameController;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

public class ResourcesMenu {
    private HBox menu;

    /**
    * creates a resource bar and display the current state of
    * your civilization's resouces
    */
    public ResourcesMenu() {
        menu = new HBox();
        Label strategyLevelLabel = new Label("Strategy Level: " + GameController
            .getCivilization().getStrategy().getStrategyLevel());
        strategyLevelLabel.setFont(Font.font(16));
        strategyLevelLabel.setTextFill(Color.WHITE);
        Label resourcesLabel = new Label(" Resources: " + GameController
            .getCivilization().getResources());
        resourcesLabel.setFont(Font.font(16));
        resourcesLabel.setTextFill(Color.WHITE);
        Label settlementLabel = new Label(" Settlements: " + GameController
            .getCivilization().getNumSettlements());
        settlementLabel.setFont(Font.font(16));
        settlementLabel.setTextFill(Color.WHITE);
        Label moneyLabel = new Label(" Money: " + GameController
            .getCivilization().getTreasury().getCoins());
        moneyLabel.setFont(Font.font(16));
        moneyLabel.setTextFill(Color.WHITE);
        Label foodLabel = new Label(" Food: " + GameController
            .getCivilization().getFood());
        foodLabel.setFont(Font.font(16));
        foodLabel.setTextFill(Color.WHITE);
        Label happinessLabel = new Label(" Happiness: " + GameController
            .getCivilization().getHappiness());
        happinessLabel.setFont(Font.font(16));
        happinessLabel.setTextFill(Color.WHITE);
        menu.getChildren().addAll(strategyLevelLabel, resourcesLabel,
            settlementLabel, moneyLabel, foodLabel, happinessLabel);
    }
    /**
    * should update all the resouce values to the current
    * state of your resource values
    */
    public void update() {
        menu.getChildren().clear();
        Label strategyLevelLabel = new Label("Strategy Level: " + GameController
            .getCivilization().getStrategy().getStrategyLevel());
        strategyLevelLabel.setFont(Font.font(16));
        strategyLevelLabel.setTextFill(Color.WHITE);
        Label resourcesLabel = new Label(" Resources: " + GameController
            .getCivilization().getResources());
        resourcesLabel.setFont(Font.font(16));
        resourcesLabel.setTextFill(Color.WHITE);
        Label settlementLabel = new Label(" Settlements: " + GameController
            .getCivilization().getNumSettlements());
        settlementLabel.setFont(Font.font(16));
        settlementLabel.setTextFill(Color.WHITE);
        Label moneyLabel = new Label(" Money: " + GameController
            .getCivilization().getTreasury().getCoins());
        moneyLabel.setFont(Font.font(16));
        moneyLabel.setTextFill(Color.WHITE);
        Label foodLabel = new Label(" Food: " + GameController
            .getCivilization().getFood());
        foodLabel.setFont(Font.font(16));
        foodLabel.setTextFill(Color.WHITE);
        Label happinessLabel = new Label(" Happiness: " + GameController
            .getCivilization().getHappiness());
        happinessLabel.setFont(Font.font(16));
        happinessLabel.setTextFill(Color.WHITE);
        menu.getChildren().addAll(strategyLevelLabel, resourcesLabel,
            settlementLabel, moneyLabel, foodLabel, happinessLabel);
    }
    /**
    * updates the resource bar and returns the resource bar
    * @return a hbox representation of the resource bar
    */
    public HBox getRootNode() {
        update();
        return menu;
    }
}
