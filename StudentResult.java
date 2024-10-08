import java.util.Scanner;

public class StudentResult {

    public static void main(String[] args) {
        // Number of subjects
        try (Scanner sc = new Scanner(System.in)) {
            // Number of subjects
            int subjects = 5;  // You can change this value if needed
            int totalMarks = 0;
            int marks[] = new int[subjects];
            
            // Input marks for each subject
            for (int i = 0; i < subjects; i++) {
                System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
                marks[i] = sc.nextInt();
                totalMarks += marks[i];
            }
            
            // Calculate average percentage
            double averagePercentage = totalMarks / (double) subjects;
            
            // Determine grade based on average percentage
            char grade;
            if (averagePercentage >= 90) {
                grade = 'A';
            } else if (averagePercentage >= 80) {
                grade = 'B';
            } else if (averagePercentage >= 70) {
                grade = 'C';
            } else if (averagePercentage >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }
            
            // Display the results
            System.out.println("\nTotal Marks: " + totalMarks);
            System.out.println("Average Percentage: " + averagePercentage + "%");
            System.out.println("Grade: " + grade);
        } // You can change this value if needed
    }
}
