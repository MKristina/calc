package Commands;

import java.util.List;

        import Context.CalcContext;
import Exceptions.ArgExceptions;
import Exceptions.EmptyStackExceptions;
import Exceptions.MyException;

public class SubtractionCommand implements Command {

    @Override
    public void execute(CalcContext context, List<String> args) throws MyException {
        if (context.size() < 2){
            throw new EmptyStackExceptions();
        }
        double y, x;

        y = context.pop();
        x = context.pop();

        context.push(x - y);
    }
}