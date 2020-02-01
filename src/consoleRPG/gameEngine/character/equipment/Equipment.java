package consoleRPG.gameEngine.character.equipment;

import consoleRPG.gameEngine.character.Character;

public class Equipment {

    private Weapon weapon;

    public Equipment() {

    }

    public void setWeapon(Weapon weapon, Character character) {
        if (this.weapon != null) {
            character.getStats().removeWeaponStats(this.weapon);
        }
        this.weapon = weapon;
        character.getStats().addWeaponStats(weapon);
    }

    public Weapon getWeapon() {
        return this.weapon;
    }
}
