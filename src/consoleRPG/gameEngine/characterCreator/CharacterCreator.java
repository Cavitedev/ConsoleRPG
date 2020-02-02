package consoleRPG.gameEngine.characterCreator;

import consoleRPG.gameEngine.character.Character;
import consoleRPG.gameEngine.character.equipment.Weapon;
import consoleRPG.gameEngine.character.stats.Stats;
import consoleRPG.ExtraUtil.Scanner.ParsableScanner;

import java.util.Scanner;


public class CharacterCreator {
    public static Character createEnemyCharacter() {
        return new Character(false, "Enemy", new Stats(10, 20, 4, 4, 4, 4, 4));
    }

    public static Character createPlayerCharacter() {
        Character characterCreated = new Character();
        Scanner in = new Scanner(System.in);
        String name;
        System.out.println("How would you like to name your new character?");
        name = in.nextLine();
        characterCreated.setName(name);

        characterCreated.getEquipment().setWeapon(selectWeapon(), characterCreated);

        characterCreated.statsUpdate();
        return characterCreated;
    }


    private static Weapon selectWeapon() {
        Scanner in = new Scanner(System.in);
        Weapon weaponCreated;
        int option;
        String name;
        System.out.println("Select your initial weapon: ");
        System.out.println("Sword (1) | Bow (2) | Staff (3): ");
        option = ParsableScanner.nextParsedInt(in, 1, 2, 3);
        in.nextLine();
        System.out.print("Now input the name of your weapon: ");
        name = in.nextLine();
        switch (option) {
            case 1:
                weaponCreated = new Weapon(name, Weapon.Type.strength, 15, 30, 0);
                break;
            case 2:
                weaponCreated = new Weapon(name, Weapon.Type.dexterity, 10, 20, 5);
                break;
            case 3:
                weaponCreated = new Weapon(name, Weapon.Type.intelligence, 20, 35, 0);
                break;
            default:
                weaponCreated = new Weapon("Wooden stick", Weapon.Type.useless, 0, 3, 0);
        }
        return weaponCreated;
    }
}
