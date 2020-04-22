import Exceptions.MyException;

import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class main {
    public static Logger log = Logger.getLogger(main.class.getName());

    public static void Main(String[] args) throws IOException, MyException, ClassNotFoundException {

        try {
            LogManager.getLogManager().readConfiguration(
                    main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }

        String inputName = null;
        if (args.length > 1) {
            inputName = args[0];
            log.log(Level.WARNING, "Too many arguments");
        } else if (args.length == 1 ){
            inputName = args[0];
        }
        log.log(Level.INFO, "Start calculating");
        Calculator calculator;
        calculator = new Calculator();
        Scanner inputStr;

        if (inputName == null) {
            log.log(Level.INFO, "Create from System.in");
            inputStr = new Scanner(System.in);
        } else {
         try {
              log.log(Level.INFO, "Create from {0} ", inputName);
              inputStr = new Scanner(Paths.get(inputName));
          }
          catch (FileNotFoundException e){
                log.log(Level.SEVERE, "File not found " + e.toString());
                inputStr = new Scanner(System.in);
                e.printStackTrace();
            }
        }
            calculator.calculate(inputStr);
          log.log(Level.FINEST, "Successful calculating");
    }
}