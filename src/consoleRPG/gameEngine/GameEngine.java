package consoleRPG.gameEngine;
import consoleRPG.gameEngine.character.Character;
import consoleRPG.gameEngine.characterCreator.CharacterCreator;
import consoleRPG.gameEngine.combat.Combat;

import java.util.ArrayList;

public class GameEngine {
    public static void start(){
        System.out.println("Welcome to ConsoleRPG");

        ArrayList<Character> playerTeam = new ArrayList<>();
        ArrayList<Character> enemyTeam = new ArrayList<>();

        Character playerOne = CharacterCreator.createPlayerCharacter();
        playerTeam.add(playerOne);

        Character enemy = CharacterCreator.createEnemyCharacter();
        enemy.toString();
        enemyTeam.add(enemy);

        Combat.combat(playerTeam, enemyTeam);



    }
}
