package FactoryPattern.src;

import FactoryPattern.src.factory.Character;
import FactoryPattern.src.factory.CharacterFactory;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the type of character you want to create (warrior, mage, archer): ");
        String choice = scanner.nextLine();

        Character character = factory.createCharacter(choice);
        if (character != null) {
            character.display();
        } else {
            System.out.println("Invalid character type.");
        }
        scanner.close();
    }
}
