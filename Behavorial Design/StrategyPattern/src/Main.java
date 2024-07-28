package StrategyPattern.src;

import StrategyPattern.src.strategy.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameAI gameAI = new GameAI();

        System.out.println("Select AI Difficulty: (1) Easy (2) Medium (3) Hard");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                gameAI.setStrategy(new EasyStrategy());
                break;
            case 2:
                gameAI.setStrategy(new MediumStrategy());
                break;
            case 3:
                gameAI.setStrategy(new HardStrategy());
                break;
            default:
                System.out.println("Invalid choice, defaulting to Easy.");
                gameAI.setStrategy(new EasyStrategy());
                break;
        }

        gameAI.executeStrategy();

        // Simulate player performance change and strategy switch
        System.out.println("Player is doing well, switching to Hard strategy...");
        gameAI.setStrategy(new HardStrategy());
        gameAI.executeStrategy();
    }
}
