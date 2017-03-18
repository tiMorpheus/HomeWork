package timur.task17;

import timur.task17.operations.Division;
import timur.task17.operations.Multiply;
import timur.task17.operations.Plus;
import timur.task17.operations.Subtract;

import java.lang.*;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TreeFactory {

    public static Component getCalculateTree(String expression) {
        if (expression == null) {
            throw new IllegalArgumentException();
        }
        List<String> list = Arrays.asList(ShuntingYard.getPolishView(expression).split("\\s"));
        Stack<Component> numbers = new Stack<>();
        for (String part : list) {
            switch (part) {
                case "+" :
                    numbers.push(new Plus(numbers.pop(), numbers.pop()));
                    break;
                case "-" :

                    numbers.push(new Subtract(numbers.pop(), numbers.pop()));
                    break;
                case "*" :
                    numbers.push(new Multiply(numbers.pop(), numbers.pop()));
                    break;
                case "/" :

                    numbers.push(new Division(numbers.pop(), numbers.pop()));
                    break;
                default:
                    numbers.push(new Number(Integer.parseInt(part)));
                    break;
            }
        }
        return numbers.pop();
    }
}
