package consoleRPG.gameEngine.character;

import consoleRPG.gameEngine.character.stats.Stats;
import consoleRPG.gameEngine.character.equipment.*;
import consoleRPG.scanner.ParsableScanner;

import java.util.Scanner;

public class Character implements Comparable<Character> {

    private boolean pLayerControlled;

    private String name;

    private Stats stats;

    private Equipment equipment;

    public Character() {
        stats = new Stats();

        equipment = new Equipment();
    }

    public Character(boolean pLayerControlled, String name, Stats stats) {
        this.pLayerControlled = pLayerControlled;
        this.name = name;
        this.stats = stats;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String toString() {
        return "/////////////////////////////////////////////////////////////////////////////////////////" + "\n" +

                "Player \"" + name + "\" stats with current equipment:" + "\n" +

                stats.toString();
    }

    public void statsUpdate() {
        if (this.stats.getStatsPointsRemaining() == 0) {
            System.out.println("No stats points remaining");
        } else {
            Scanner in = new Scanner(System.in);
            String keepChanges;
            int option, quantity;
            System.out.println(this);
            do {
                System.out.println("Points remaining: " + this.stats.getStatsPointsRemaining());
                System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
                System.out.println("Input the number of the stat (n) you want to enhance or input any other number to cancel");
                System.out.print("Strength (1) | Dexterity (2) | Intelligence (3) | Constitution (4) | Speed (5): ");
                option = ParsableScanner.nextParsedInt(in, 1, 2, 3, 4, 5);
                System.out.print("Now select how many points you want to add: ");
                quantity = ParsableScanner.nextParsedIntMinMax(in, 1, this.stats.getStatsPointsRemaining());
                in.nextLine();

                statModify(quantity, option);
                this.stats.modifyStatsPointsRemaining(-quantity);
                System.out.println(this);
                System.out.print("Do you want to keep stats changes? (yes | no) ");
                keepChanges = in.nextLine();
                if (!keepChanges.equals("yes")) {
                    statModify(-quantity, option);
                    this.stats.modifyStatsPointsRemaining(quantity);
                    System.out.println(this);
                }


            } while (this.stats.getStatsPointsRemaining() > 0);
        }
    }

    private void statModify(int quantity, int option) {
        switch (option) {
            case 1:
                this.stats.modifyStrength(quantity);
                break;
            case 2:
                this.stats.modifyDexterity(quantity);
                break;
            case 3:
                this.stats.modifyIntelligence(quantity);
                break;
            case 4:
                this.stats.modifyConstitution(quantity);
                break;
            case 5:
                this.stats.modifySpeed(quantity);
        }
    }

    public Equipment getEquipment() {
        return equipment;
    }

    private void attackReceive(int attack) {
        stats.modifyLifeCurrent(-attack);
    }

    public void attackSend(Character attackObjective) {
        Weapon weapon = this.equipment.getWeapon();
        int damageSent;


        damageSent = (int) (Math.random() * ((this.stats.getAttackMax() - this.stats.getAttackMin()) + 1) + this.stats.getAttackMin());

        if ((Math.random() * (100) + 1) <= (this.stats.getCriticChance())) {
            damageSent *= 2;
            System.out.println("Critic Damage");
        }
        attackObjective.attackReceive(damageSent);
    }

    public Stats getStats() {
        return stats;
    }


    @Override
    public int compareTo(Character o) {
        if (o.getStats().getSpeed() < stats.getSpeed()) {
            return -1;
        } else if (o.stats.getSpeed() > stats.getSpeed()) {
            return 1;
        } else {
            return 0;
        }
    }
}

