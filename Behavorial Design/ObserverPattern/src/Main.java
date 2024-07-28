package ObserverPattern.src;

import ObserverPattern.src.observer.CricketData;
import ObserverPattern.src.observer.ScoreBoard;

public class Main {
    public static void main(String[] args) {
        CricketData cricketData = new CricketData();

        ScoreBoard scoreboard1 = new ScoreBoard("ScoreBoard 1");
        ScoreBoard scoreboard2 = new ScoreBoard("ScoreBoard 2");
        ScoreBoard mobileApp = new ScoreBoard("Mobile App");

        cricketData.addObserver(scoreboard1);
        cricketData.addObserver(scoreboard2);
        cricketData.addObserver(mobileApp);

        cricketData.setScore(100, 2);
        cricketData.setScore(150, 3);
    }
}
