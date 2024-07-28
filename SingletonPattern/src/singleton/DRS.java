package singleton;

public class DRS {
    private static DRS instance;

    private DRS() {
        // private constructor to prevent instantiation
    }

    public static DRS getInstance() {
        if (instance == null) {
            synchronized (DRS.class) {
                if (instance == null) {
                    instance = new DRS();
                }
            }
        }
        return instance;
    }

    public String reviewDecision(String onFieldDecision, boolean isOut) {
        return isOut ? "Decision overturned to OUT." : "Decision stands as " + onFieldDecision + ".";
    }
}
