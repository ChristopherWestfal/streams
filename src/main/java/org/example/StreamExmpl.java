package org.example;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class StreamExmpl {
    // Eine Liste von Zahlen, die initialisiert wird.
    private List<Integer> numbers = List.of(11,1,2,3,4,5,6,7,8,9,10);

    public void evenNumbers(){
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(evenNumbers);
    }

    public void doubleNumbers() {
        // Erstelle einen Stream aus der Liste numbers.
        List<Integer> doubledNumbers = numbers.stream()
                // Verwandle jede Zahl n in einen Stream, der n zweimal enthält, und flache diesen Stream ab.
                .flatMap(n -> List.of(n, n).stream())
                // Sammle die abgeflachten Elemente in eine Liste.
                .collect(Collectors.toList());

        // Gib die Liste der verdoppelten Zahlen aus.
        System.out.println(doubledNumbers);
    }

    public void sortListAscend(){
        List<Integer> ascendedList = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(ascendedList);
    }

    public void addNumbers(){
        int sumList = numbers.stream()
                .reduce(0, Integer::sum);

        System.out.println("Die Summe aller Zahlen in der List beträgt: " + sumList);
    }

    public void editList(){
        List<Integer> newNumberList = numbers.stream()
                .filter(n -> n % 2 == 0)
                .peek(System.out::print)
                .flatMap(n -> List.of(n,n).stream())
                .sorted()
                .toList();

        newNumberList.forEach(System.out::print);

        System.out.println("\nDie Summe aller Zahlen in der List beträgt: " + newNumberList.stream().reduce(0, Integer::sum));
    }
}
