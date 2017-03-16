package timur.task25;

import java.util.Stack;

public class MementoItem {

    private Stack<Memento> stack = new Stack<Memento>();

    public void add(Memento memento) {
        stack.push(memento);
    }

    public Memento pop() {
        return stack.pop();
    }
}
