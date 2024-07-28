import adapter.*;

public class Main {
    public static void main(String[] args) {
        ScoreProviderA scoreProviderA = new ScoreProviderA();
        ScoreProviderB scoreProviderB = new ScoreProviderB();

        ScoreAdapter scoreAdapterA = new ScoreProviderAAdapter(scoreProviderA);
        ScoreAdapter scoreAdapterB = new ScoreProviderBAdapter(scoreProviderB);

        System.out.println("Score from Provider A: " + scoreAdapterA.getUnifiedScore());
        System.out.println("Score from Provider B: " + scoreAdapterB.getUnifiedScore());
    }
}
