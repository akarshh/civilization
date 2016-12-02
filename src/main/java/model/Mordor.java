package model;

/**
 * Represents the Roman Empire civilization.
 *
 * @version 2.0
 * @author Angie Palm, Jim Harris
 */
public class Mordor extends Civilization {
    private Hills hills = new Hills();;

    /**
     * Public constructor.
     */
    public Mordor() {
        super("Mordor");
    }

    @Override
    public String explore() {
        int resources = hills.mineCoal();
        produceResources(resources);
        return "You go mining and get " + resources + " resources!";
    }

    /**
     * @return the Hills for this Civilization.
     */
    public Hills getHills() {
        return hills;
    }

    @Override
    public MeleeUnit getMeleeUnit() {
        return new OrcUnit(this);
    }

    @Override
    public Landmark getLandmark() {
        return new BlackGate(this);
    }

}
