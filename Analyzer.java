import java.util.ArrayList;

public class Analyzer {
    public static void analyze(ArrayList<StudentRecord> students) {

        int yesBefore = 0, yesAfter = 0, yesCount = 0;
        int noBefore = 0, noAfter = 0, noCount = 0;

        for (StudentRecord s : students) {
            if (s.getUsesAi().equalsIgnoreCase("Yes")) {
                yesBefore += s.getBefore();
                yesAfter += s.getAfter();
                yesCount++;
            } else { // No AI
                noBefore += s.getBefore();
                noAfter += s.getAfter();
                noCount++;
            }
        }

        double yesAvgBefore = yesBefore * 1.0 / yesCount;
        double yesAvgAfter  = yesAfter  * 1.0 / yesCount;
        double yesChange    = yesAvgAfter - yesAvgBefore;

        double noAvgBefore = noBefore * 1.0 / noCount;
        double noAvgAfter  = noAfter  * 1.0 / noCount;
        double noChange    = noAvgAfter - noAvgBefore;

        System.out.println("Uses AI:");
        System.out.println("Avg before: " + yesAvgBefore);
        System.out.println("Avg after:  " + yesAvgAfter);
        System.out.println("Avg change: " + yesChange);

        System.out.println("\nDoes NOT use AI:");
        System.out.println("Avg before: " + noAvgBefore);
        System.out.println("Avg after:  " + noAvgAfter);
        System.out.println("Avg change: " + noChange);

        System.out.println("\nConclusion:");
        if (yesChange > noChange) {
            System.out.println("Students who use AI show a higher average grade improvement than students who do not.");
        } else if (yesChange < noChange) {
            System.out.println("Students who do not use AI show a higher average grade improvement than students who use AI.");
        } else {
            System.out.println("Students who use AI and students who do not show the same average grade improvement.");
        }
    }
}
