package Commands;

import java.util.List;
import Context.CalcContext;
import Exceptions.ArgExceptions;
import Exceptions.MyException;
import Exceptions.NoArgsExceptions;


public class DefineCommand implements Command {

    @Override
    public void execute(CalcContext context, List<String> args) throws MyException {
        if (args.size() < 2) {
            throw new NoArgsExceptions();
        }
        if (args.size() > 2) {
            throw new ArgExceptions("extra argument");
        }
        try {
            double value = Double.parseDouble(args.get(1));
        } catch (Exception ex) {
            throw new ArgExceptions("Unknown number");
        }

        context.setDefinitions(args.get(0), Double.parseDouble(args.get(1)));
    }
}