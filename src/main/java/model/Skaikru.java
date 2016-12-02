package model;

/**
 * Represents the Skaikru Civilization.
 *
 * @version 1.0
 * @author Akarsh Hemrajani
 */
public class Skaikru extends Civilization {
    private Desert desert = new Desert();

    /**
     * Public constructor.
     */
    public Skaikru() {
        super("Skaikru");
    }

    @Override
    public String explore() {
        int gold = desert.findTreasure();
        getTreasury().earn(gold);
        return "You explore the desert and find " + gold + " gold!";
    }

    /**
     * @return this civilization's Desert.
     */
    public Desert getDesert() {
        return desert;
    }

    @Override
    public RangedUnit getRangedUnit() {
        return new GrounderUnit(this);
    }

    @Override
    public Landmark getLandmark() {
        return new BlackGate(this);
    }

    //The 100 reference
}
