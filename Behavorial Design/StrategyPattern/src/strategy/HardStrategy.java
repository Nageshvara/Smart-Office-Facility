package StrategyPattern.src.strategy;

public class HardStrategy implements Strategy {
    @Override
    public void play() {
        System.out.println("Playing with hard strategy: Aggressive attacks, minimal defense.");
    }
}
