package Commands;

import java.util.List;
import Context.CalcContext;
import Exceptions.ArgExceptions;
import Exceptions.EmptyStackExceptions;
import Exceptions.MyException;

public class PopCommand implements Command {

    @Override
    public void execute(CalcContext context, List<String> args) throws MyException {
        if (args.size() != 0){
            throw new ArgExceptions("extra argument");
        }
        if (context.isEmpty()){
            throw new EmptyStackExceptions();
        }
        context.pop();
    }
}