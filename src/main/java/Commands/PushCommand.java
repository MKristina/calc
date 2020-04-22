package Commands;

import java.util.List;
import Context.CalcContext;
import Exceptions.ArgExceptions;
import Exceptions.InvalidArgsExceptions;
import Exceptions.MyException;

public class PushCommand implements Command {

    @Override
    public void execute(CalcContext context, List<String> args) throws MyException {
        if (args.size() > 1){
            throw new ArgExceptions("too many arguments");
        } else if (args.size() == 0) {
            throw new ArgExceptions("not enough arguments");
        }
        Double  value;
        try {
            value = Double.parseDouble(args.get(0));
            context.push(value);
        } catch (NumberFormatException e) {
            value = context.definitions.get(args.get(0));
            if (value == null) throw new InvalidArgsExceptions("null");
            context.stack.push(value);
        }
    }
    }