package adapter;

public class ScoreProviderBAdapter implements ScoreAdapter {
    private ScoreProviderB scoreProviderB;

    public ScoreProviderBAdapter(ScoreProviderB scoreProviderB) {
        this.scoreProviderB = scoreProviderB;
    }

    @Override
    public String getUnifiedScore() {
        int[] score = scoreProviderB.getScore();
        return "TeamA: " + score[0] + "/" + score[1] + " in " + score[2] + " overs";
    }
}
