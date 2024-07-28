package StrategyPattern.src.strategy;

public class EasyStrategy implements Strategy {
    @Override
    public void play() {
        System.out.println("Playing with easy strategy: Minimal attacks, focus on defense.");
    }
}
