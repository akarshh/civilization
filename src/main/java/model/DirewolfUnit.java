package model;

import javafx.scene.image.Image;

/**
 * Represents a Black Powder unit.
 *
 * @author Akarsh Hemrajani
 * @version 1.0
 */
class DirewolfUnit extends SiegeUnit {

    /**
     * Public constructor
     *
     * @param owner The owner of this unit.
     */
    DirewolfUnit(Civilization owner) {
        super(owner);
    }

    @Override
    public void battle(MapObject o) {
        o.damage(this.getDamage());
    }

    @Override
    public char symbol() {
        return 'D';
    }


    @Override
    public String toString() {
        return "Direwolf Unit. " + super.toString();
    }
    @Override
    public Image getImage() {
        return new Image("File:./src/main/java/view/Civ_Icon/"
                + "direwolf_unit.PNG");
    }
}
