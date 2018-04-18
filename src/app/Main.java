package app;

import collections.ArrayList;
import collections.EntryBasedMap;
import inout.In;
import inout.Out;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

//        EntryBasedMap<String, Integer> shoppingList = new EntryBasedMap<>();
//        shoppingList.put("Apple", 2);
//        shoppingList.put("Banana", 3);
//        shoppingList.put("Kiwi", 1);
//        shoppingList.put("Apple", 7);
//        shoppingList.remove("Banana");
        // TODO: Create shoppingList
        EntryBasedMap<String, Integer> shoppingList = new EntryBasedMap<>();
        System.out.println("---------------------------------------------------");
        System.out.println("------------------ SHOPPING LIST ------------------");
        System.out.println("---------------------------------------------------");
        System.out.println("");
        System.out.println("---------------------------------------------------");
        System.out.println("Operationen:");
        System.out.println("(1) Neuen Eintrag hinzufuegen");
        System.out.println("(2) Loeschen eines Eintrags");
        System.out.println("(3) Einkaufsliste (Gegenstand + Anzahl) ausgeben");
        System.out.println("(4) Anzahl der zu kaufenden Gegenstaende ausgeben");
        System.out.println("(5) Anzahl der unterschiedlichen Gegenstaende");
        System.out.println("(X) Ende");
        System.out.println("---------------------------------------------------\n");

        System.out.print("Ihre Eingabe: ");
        char c = In.readChar();
        while (!(c == 'X' || c == 'x')) {
            switch (c) {
                case '1':
                    System.out.print("Gegenstand: ");
                    String item = In.readWord();
                    System.out.print("Anzahl: ");
                    int number = In.readInt();
                    In.read();
                    // TODO: put item with their number into shoppping list
                    shoppingList.put(item, number);
                    break;
                case '2':
                    System.out.print("Gegenstand: ");
                    String remItem = In.readWord();

                    // TODO: Remove item from shopping list
                    shoppingList.remove(remItem);

                    break;
                case '3':
                    // TODO: Iterate over entries in shopping list and print them
                    Iterator entryItr = shoppingList.iterator();
                    while (entryItr.hasNext()) {
                        Object e = entryItr.next();
                        System.out.print(e.toString());
                    }
                    break;
                case '4':
                    // TODO: sum up the number of items in the shopping list
                    Iterator valueItr = shoppingList.valueIterator();
                    int sum = 0;
                    while (valueItr.hasNext()) sum += (int)valueItr.next();
                    System.out.println(sum);
                    break;
                case '5':
                    // TODO: print out the number of entries in the shopping list
                    Out.print(shoppingList.size());
                    break;
                default:
                    System.out.println(String.format("%s ist keine valide Eingabe!", c));
            }
            System.out.print("\nIhre Eingabe: ");
            c = In.readChar();
        }
    }
}
