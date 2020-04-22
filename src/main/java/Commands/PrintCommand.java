package Commands;

import java.util.List;
import Context.CalcContext;
import Exceptions.EmptyStackExceptions;

public class PrintCommand implements Command {

    @Override
    public void execute(CalcContext context, List<String> args) throws EmptyStackExceptions {
        if (context.size() < 1){
            throw new EmptyStackExceptions();
        }
        context.print();
    }
}