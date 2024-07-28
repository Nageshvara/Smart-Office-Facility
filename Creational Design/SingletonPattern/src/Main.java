import singleton.DRS;

public class Main {
    public static void main(String[] args) {
        DRS drs1 = DRS.getInstance();
        DRS drs2 = DRS.getInstance();

        // Check if both references point to the same instance
        if (drs1 == drs2) {
            System.out.println("Both references point to the same DRS instance.");
        }

        // Simulate a review decision
        String decision1 = drs1.reviewDecision("NOT OUT", true);
        System.out.println(decision1);

        // Simulate another review decision
        String decision2 = drs2.reviewDecision("OUT", false);
        System.out.println(decision2);
    }
}
