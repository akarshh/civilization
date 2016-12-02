package model;

import javafx.scene.image.Image;

/**
 * Represents a Grounder unit.
 *
 * @version 1.0
 * @author Akarsh Hemrajani
 */
class GrounderUnit extends RangedUnit {

    /**
     * Public constructor.
     *
     * @param owner the owner of this unit.
     */
    public GrounderUnit(Civilization owner) {
        super(owner);
        this.setBaseEndurance(this.getBaseEndurance() * 2);
        this.regenerateEndurance();
    }

    @Override
    public char symbol() {
        return 'G';
    }


    @Override
    public String toString() {
        return "Grounder Unit. " + super.toString();
    }

    @Override
    public Image getImage() {
        return new Image(
                "File:./src/main/java/view/Civ_Icon/grounder_icon.PNG");
    }
}
