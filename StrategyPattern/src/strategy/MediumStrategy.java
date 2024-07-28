package StrategyPattern.src.strategy;

public class MediumStrategy implements Strategy {
    @Override
    public void play() {
        System.out.println("Playing with medium strategy: Balanced attacks and defense.");
    }
}
