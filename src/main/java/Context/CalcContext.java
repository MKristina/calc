package Context;

import Exceptions.EmptyStackExceptions;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

public class CalcContext {
    private Stack<Double> stack;
    private HashMap<String, Double> definitions;

    public CalcContext() {
        stack = new Stack<>();
        definitions = new HashMap<>();
    }

    public void setDefinitions(String name, double value){
        if (definitions.containsKey(name)) {
            definitions.replace(name, value);
        }
        else {
            definitions.put(name, value);
        }
    }

    public Double pop() throws EmptyStackExceptions {
        if (stack.isEmpty()) throw new EmptyStackExceptions();
        return stack.pop();
    }

    public void push(Double value) {
        stack.push(value);
    }
    public boolean isEmpty() { return stack.isEmpty(); }

    public int size() { return stack.size(); }

    public void print() {
        if (stack.isEmpty()) throw new EmptyStackException();
        System.out.println(stack.peek());
    }

    public Double getValue(){
        return stack.peek();
    }
    public Double getValueByKey(String key) {
        return definitions.get(key);
    }
}
