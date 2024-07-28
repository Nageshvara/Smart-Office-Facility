package ObserverPattern.src.observer;

public class ScoreBoard implements Observer {
    private String boardName;

    public ScoreBoard(String boardName) {
        this.boardName = boardName;
    }

    @Override
    public void update(int runs, int wickets) {
        System.out.println(boardName + " updated: Runs - " + runs + ", Wickets - " + wickets);
    }
}
