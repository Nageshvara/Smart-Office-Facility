package StrategyPattern.src.strategy;

public class GameAI {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        strategy.play();
    }
}
