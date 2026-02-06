import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<StudentRecord> students = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File("students_ai_usage.csv"));
            sc.nextLine(); // skip header

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");

                
                String usesAi = parts[3].trim();
                int before = Integer.parseInt(parts[6].trim());
                int after = Integer.parseInt(parts[7].trim());

                students.add(new StudentRecord(usesAi, before, after));
            }

            sc.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        Analyzer.analyze(students);
    }
}
