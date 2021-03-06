import Commands.Command;
import Exceptions.InvalidCommandExceptions;
import Exceptions.PropertiesExceptions;
import java.io.IOException;
import java.util.Properties;

public class CommandsFactory {
    private static volatile CommandsFactory commandsFactory;
    private final Properties properties = new Properties();

    CommandsFactory() throws PropertiesExceptions {
        try {
            properties.load(Calculator.class.getResourceAsStream("/commands.properties"));
        } catch (IOException e) {
            throw new PropertiesExceptions("command properties");
        }
    }

    private static CommandsFactory getCommandsFactory() throws PropertiesExceptions {
        if (commandsFactory == null){
            synchronized (ClassLoader.class){
                if(commandsFactory == null){
                    commandsFactory = new CommandsFactory();
                }
            }
        }
        return commandsFactory;
    }

    public Command getCommand(String commandName) {
        Command command = null;
        String  name;
        try {
            if ((name = properties.getProperty(commandName)) == null) throw new InvalidCommandExceptions(commandName);
            command = (Command) Class.forName(name).getDeclaredConstructor().newInstance();
        } catch ( Exception e) {
            e.printStackTrace();
        }

        return command;
    }
}