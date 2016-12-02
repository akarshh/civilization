package model;

import javafx.scene.image.Image;
/**
 * Represents the Black Gate that can increase happiness.
 *
 * @version 1.0
 * @author Akarsh Hemrajani
 */
class BlackGate extends Landmark {

    /**
     * Public constructor.
     *
     * @param owner the Civilization that owns this Building.
     */
    public BlackGate(Civilization owner) {
        super(owner);
    }

    @Override
    public void invest() {
        super.invest();
        getOwner().increaseHappiness(50);
    }


    @Override
    public String toString() {
        return "BlackGate " + super.toString();
    }

    @Override
    public Image getImage() {
        return new Image(
                "File:./src/main/java/view/Civ_Icon/black_gate.PNG");
    }
}
