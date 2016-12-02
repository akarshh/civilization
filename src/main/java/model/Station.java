package model;

import javafx.scene.image.Image;

/**
 * Represents a Station that can increase philosophy.
 *
 * @version 1.0
 * @author Akarsh Hemrajani
 */
class Station extends Landmark {

    /**
     * Public constructor.
     *
     * @param owner the Civilization that owns this Building.
     */
    public Station(Civilization owner) {
        super(owner);
    }

    @Override
    public void invest() {
        super.invest();
        getOwner().getTechnology().philosophize();
    }

    @Override
    public String toString() {
        return "Station " + super.toString();
    }

    @Override
    public Image getImage() {
        return new Image("File:./src/main/java/view/Civ_Icon/station_icon.PNG");
    }
}
