package consoleRPG.scanner;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ParsableScannerTest {

    @org.junit.jupiter.api.Test
    void nextParsedInt() {
        assertEquals(7,ParsableScanner.nextParsedInt(new Scanner("7")));
        assertEquals(-3,ParsableScanner.nextParsedInt(new Scanner("-3")));
        assertEquals(5,ParsableScanner.nextParsedInt(new Scanner("ererere\n5")));
        assertEquals(0,ParsableScanner.nextParsedInt(new Scanner("line1\nline2\nline3\n0")));



    }

    @org.junit.jupiter.api.Test
    void testNextParsedInt() {
        assertEquals(4,ParsableScanner.nextParsedInt(new Scanner("4"),1,2,3,4,5));
        assertEquals(1,ParsableScanner.nextParsedInt(new Scanner("lot of text\n1"),1));
        assertEquals(-4,ParsableScanner.nextParsedInt(new Scanner("lot of text\n8\n6\n-4"),-4,2,3,4,5));
        assertEquals(8,ParsableScanner.nextParsedInt(new Scanner("3\n0\n9\n\n8\n1"),1,4,8));


    }

    @org.junit.jupiter.api.Test
    void nextParsedIntMinMax() {

        assertEquals(2,ParsableScanner.nextParsedIntMinMax(new Scanner("2"),0,5));
        assertEquals(2,ParsableScanner.nextParsedIntMinMax(new Scanner("text\n2"),0,5));
        assertEquals(0,ParsableScanner.nextParsedIntMinMax(new Scanner("text\n-1\n0"),0,5));
        assertEquals(5,ParsableScanner.nextParsedIntMinMax(new Scanner("text\n6\n5"),0,5));



    }
}