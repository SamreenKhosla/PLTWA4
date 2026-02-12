import javax.swing.JFrame;
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
            } else {
                noBefore += s.getBefore();
                noAfter += s.getAfter();
                noCount++;
            }
        }

        //calculate Averages
        double yesAvgBefore = (yesCount > 0) ? yesBefore * 1.0 / yesCount : 0;
        double yesAvgAfter  = (yesCount > 0) ? yesAfter  * 1.0 / yesCount : 0;
        double noAvgBefore = (noCount > 0) ? noBefore * 1.0 / noCount : 0;
        double noAvgAfter  = (noCount > 0) ? noAfter  * 1.0 / noCount : 0;

        //create the Swing Window
        JFrame frame = new JFrame("Grade Analysis Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //pass the calculated data to our custom drawing panel
        graph panel = new graph(yesAvgBefore, yesAvgAfter, noAvgBefore, noAvgAfter);
        frame.add(panel);
        
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}