import Commands.AdditionCommand;
import Commands.DefineCommand;
import Commands.PushCommand;
import Context.CalcContext;
import Exceptions.ArgExceptions;
import Exceptions.EmptyStackExceptions;
import Exceptions.InvalidArgsExceptions;
import Exceptions.MyException;
import com.sun.org.apache.xerces.internal.xs.StringList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void PushTest() throws MyException {

        CalcContext context = new CalcContext();
        PushCommand pushCom = new PushCommand();
        List<String> args = new ArrayList<>();
        args.add("123");
        pushCom.execute(context, args);
        assertFalse(context.isEmpty());
        assertEquals(123, context.getValue(), 0.0);
    }
    @Test
    public void AdditionTest() throws MyException {

        CalcContext context = new CalcContext();
        List<String> args = new ArrayList<>();
        context.push(3.0);
        context.push(9.0);
        AdditionCommand add = new AdditionCommand();
        add.execute(context, args);
        assertEquals(12, context.getValue(), 0.0);
    }
    @Test
    public void DefineTest() throws MyException {

        CalcContext context = new CalcContext();
        List<String> args = new ArrayList<>();
        args.add("a");
        args.add("4");
        DefineCommand def = new DefineCommand();
        def.execute(context, args);
        assertEquals(4, context.getValueByKey("a"), 0.0);
    }

  /*  @Test
    public void PUSHandPOPTest() throws EmptyStackExceptions {
        CalcContext context = new CalcContext();

        for (double i = 0; i < 100; i++) {
            context.push(i);
        }
        assert (context.size() == 100);
        for (double i = 0; i < 100; i++) {
            context.pop();
        }
        assert (context.isEmpty());
    }
*/

}