package consoleRPG.ExtraUtil.Scanner;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

public class ParsableScanner {

    /**
     * Asks the user until getting an integer number
     * @param scanner Scanner For Reading data
     * @return valid number that is not a String
     */
    public static int nextParsedInt(@NotNull Scanner scanner){
        while (!scanner.hasNextInt()) {
            String input = scanner.next();
            System.out.printf("\"%s\" is not a valid number.\n", input);
        }
        return scanner.nextInt();
    }

    /**
     * Asks the user until getting an input inside valid options
     * @param scanner Scanner For Reading data
     * @param validOptions Array or set of numbers of valid inputs from the user
     * @return valid number from the user
     */
    public static int nextParsedInt(@NotNull Scanner scanner, int... validOptions) {
        while (true) {
            final int option = nextParsedInt(scanner);
            if (Arrays.stream(validOptions).anyMatch(n -> n == option)) {
                return option;
            } else {
                System.out.println("\""+option +"\" is not contained in " + Arrays.toString(validOptions));
            }
        }
    }

    /**
     * Asks the user until getting a number between min and max
     * @param scanner Scanner For Reading data
     * @param min minimum inclusive value that the user can enter
     * @param max maximum inclusive value that the user can enter
     * @return valid number from the user
     */
    public static int nextParsedIntMinMax(@NotNull Scanner scanner, int min, int max){
        while (true) {
            final int option = nextParsedInt(scanner);
            if (option>= min && option<=max) {
                return option;
            } else {
                System.out.println("\""+option +"\" is not greater or equal than \""+min+"\" and lower or equal than \"" + max +"\"" );
            }
        }
    }
}
