package adapter;

public class ScoreProviderAAdapter implements ScoreAdapter {
    private ScoreProviderA scoreProviderA;

    public ScoreProviderAAdapter(ScoreProviderA scoreProviderA) {
        this.scoreProviderA = scoreProviderA;
    }

    @Override
    public String getUnifiedScore() {
        return scoreProviderA.getScore();
    }
}
