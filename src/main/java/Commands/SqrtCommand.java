package Commands;

import java.util.List;
import Context.CalcContext;
import Exceptions.ArgExceptions;
import Exceptions.EmptyStackExceptions;
import Exceptions.MyException;
import Exceptions.NegativeSQRT;


public class SqrtCommand implements Command {

    @Override
    public void execute(CalcContext context, List<String> args) throws MyException {
        if(context.size() < 1){
            throw new EmptyStackExceptions();
        }
        if (context.getValue() < 0) {
            throw new ArgExceptions(" argument < 0");
        }
        Double x = context.pop();

        if (x >= 0) {
            x = Math.sqrt(x);
            context.push(x);
        }

        else throw new NegativeSQRT(x.toString());
    }
}