import Commands.Command;
import Context.CalcContext;
import Exceptions.MyException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Calculator {
    private static final Logger log = Logger.getLogger(Calculator.class.getName());
    CalcContext context;
    CommandsFactory commandsFactory;
    boolean isException = false;

    public Calculator() {
        context = new CalcContext();
        commandsFactory = new CommandsFactory();
    }
    public void calculate(Scanner scanner) throws MyException {

        log.log(Level.INFO, "Start calculating");

            while (scanner.hasNextLine()) {
               log.log(Level.INFO, "Start parsing");

                String commandName;
                List<String> args = null;
                List<String> words = Arrays.asList(scanner.nextLine().split(" "));

                commandName = words.get(0);

                if (words.size() > 1)
                    args = words.subList(1, words.size());

                if (args == null) args = Collections.singletonList("");
               log.log(Level.INFO, "Start '" + commandName + " " + args);

                Command com = commandsFactory.getCommand(commandName);
                com.execute(context, args);

               log.log(Level.FINE, "Successful'");
            }
            if (!context.isEmpty()) {
               log.log(Level.INFO, "Result is: ");
                context.print();
            }
            log.log(Level.FINE, "Successful calculating");
    }

}