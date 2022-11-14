import java.util.ArrayList;
import java.util.Scanner;
public class StudentDatabaseAppplication {

    public boolean search;

    public static void main(String[] args) {

        // Ask how many students are enrolled
        System.out.print("How many new students: ");
        Scanner in = new Scanner(System.in);
        int numNewStudents = in.nextInt();
        //Create an array to stock the students objects
        ArrayList<Student> studentList = new ArrayList<>();
        for (int s = 0; s != numNewStudents; s++) {
            Student student = new Student();
            student.enrollCourses();
            student.payTuition();
            student.showId();
            studentList.add(student);
        }

        boolean operation = true;
        while (operation) {
            System.out.print("What do you want to do (pay tuition / show status): ");
            Scanner str = new Scanner(System.in);
            String search = str.nextLine();
            if (search.toLowerCase().equals("pay tuition")) {
                System.out.print("Enter ID student: ");
                String searchId = str.nextLine();
                for (Student student : studentList) {
                    if (student.getStudentId().equals(searchId)) {
                        student.payTuition();
                        break;
                    }
                }
            } else if (search.toLowerCase().equals("show status")) {
                System.out.print("Enter ID student: ");
                String searchId = str.nextLine();
                for (Student student : studentList) {
                    if (student.getStudentId().equals(searchId)) {
                        student.showStatus();
                        break;
                    }
                }
            } else {
                System.out.println("Error: try again please");
            }
            System.out.println("Do you want to make an other operation: ");
            String continueOperation = str.nextLine();
            if (continueOperation.equalsIgnoreCase("no")) {
                operation = false;
            }
        }
    }
}