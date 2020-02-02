package consoleRPG.gameEngine.combat;

import consoleRPG.gameEngine.character.Character;
import java.util.ArrayList;
import java.util.Collections;

public class Combat {
    static public void newCombat(ArrayList <Character> playerTeam, ArrayList <Character> enemyTeam){
        ArrayList <Character> charactersInCombat = groupFaces(playerTeam, enemyTeam);

        System.out.println("\n\nCharacters in combat\n\n");

        for(Character character: charactersInCombat){
            System.out.println(character);
        }

        //Combat Starts Bitches

        //General turn starts

        /*
        PA = 2
        Each one turn starts
            if(alive)
                if(playerControlled)
                    Attack / other things (switch) till PA runs out or take a turn
                    Finish turn: sum PA + 1
                else
                    enemyController(enemy);
            orderCombatTurn()
         */
    }

    static private ArrayList <Character> groupFaces(ArrayList <Character> playerTeam, ArrayList <Character> enemyTeam){
        ArrayList <Character> charactersInCombat = new ArrayList<>();
        charactersInCombat.addAll(playerTeam);
        charactersInCombat.addAll(enemyTeam);

        orderCombatTurn(charactersInCombat);

        return charactersInCombat;
    }

    static private void orderCombatTurn(ArrayList <Character> charactersInCombats){
        Collections.sort(charactersInCombats);
    }
}
