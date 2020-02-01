package consoleRPG.gameEngine.character.equipment;

public class Weapon {

    private String name;
    private Type type;

    private int attackMin, attackMax, criticChance;

    public enum Type{
        strength, dexterity, intelligence, useless
    }

    public Weapon(String name, Type type, int attackMin, int attackMax, int criticChance){
        this.name = name;
        this.type = type;
        this.attackMin = attackMin;
        this.attackMax = attackMax;
        this.criticChance = criticChance;
    }

    public Weapon getWeapon(){
        return this;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public int getAttackMin() {
        return attackMin;
    }

    public int getAttackMax() {
        return attackMax;
    }

    public int getCriticChance() {
        return criticChance;
    }
}
