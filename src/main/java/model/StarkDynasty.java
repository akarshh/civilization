package model;

/**
 * Represents the Stark Dynasty Civiization.
 *
 * @version 1.0
 * @author Akarsh Hemrajani
 */
public class StarkDynasty extends Civilization {
    private Woods woods = new Woods();

    /**
     * Public constructor.
     */
    public StarkDynasty() {
        super("Stark Dynasty");
    }

    @Override
    public String explore() {
        int food = woods.hunt().getHealth();
        woods.replenishGame();
        makeFood(food);
        return "You go hunting and get " + food + " food!";
    }

    /**
     * @return the Woods for this Civilization.
     */
    public Woods getWoods() {
        return woods;
    }

    @Override
    public SiegeUnit getSiegeUnit() {
        return new DirewolfUnit(this);
    }

    @Override
    public Landmark getLandmark() {
        return new Winterfell(this);
    }
}
