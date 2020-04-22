package Commands;

import java.util.List;

import Context.CalcContext;
import Exceptions.ArgExceptions;
import Exceptions.EmptyStackExceptions;
import Exceptions.MyException;

public class AdditionCommand implements Command {

    @Override
    public void execute(CalcContext context, List<String> args) throws MyException {
        double y, x;
        if (context.size() < 2){
            throw new EmptyStackExceptions();
        }
        y = context.pop();
        x = context.pop();

        context.push(x + y);
    }
}