package turtle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        PrintStream printStream = new PrintStream(System.out);
        TurtleInterpreter turtleInterpreter;
        int length = args.length;

        switch (length) {
            case 2:
                printStream = new PrintStream(new File(args[1]));
            case 1:
                scanner = new Scanner(new File(args[0]));
                break;
        }
        turtleInterpreter = new TurtleInterpreter(scanner, printStream);
        turtleInterpreter.readAndProcess();
    }
}
