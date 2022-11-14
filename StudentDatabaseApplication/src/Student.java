import java.util.Scanner;
public class Student {
    private String firstName;
    private String lastName;
    private String gradeYear;
    private int firstIDNumber;
    private String courses = "";
    private int numberOfMaxCourses = 5;
    private String coursesAvailable = "\nCourses available:\n- History 101\n- Mathematics101\n- English 101\n- Chemistry 101\n- Computer Science 101";
    private String studentId;
    private static int id = 1000;
    private int balance = 0;
    private static int costOfCourse = 600;
    private Scanner in;

    // Constructor : name & year
    public Student(){
        this.in = new Scanner(System.in);
        System.out.print("Enter first name: ");
        this.firstName = this.in.nextLine();
        System.out.print("Enter last name: ");
        this.lastName = this.in.nextLine();

        //Ask class level and set first number of the student ID
        this.firstIDNumber = setFirstIDNumber();

        //Set student id
        id++;
        this.studentId = setStudentId();

        // Verify
        //System.out.println("First name: " + this.firstName.toUpperCase() + "\nLast name: " + this.lastName.toUpperCase() + "\nGrade year: " + this.gradeYear.toUpperCase() + "\nStudent ID: " + this.studentId);
    }

    // Generate a Student ID (5 numbers) with the first number being their grade level
    private int setFirstIDNumber(){
        boolean gradeYearEntered = true;
        while (gradeYearEntered){
            System.out.print("- Freshman\n- Sophomore\n- Junior\n- Senior\nEnter class level: ");
            this.gradeYear = this.in.nextLine();
            if (this.gradeYear.equalsIgnoreCase("freshman")){ gradeYearEntered = false; return 1; }
            else if (this.gradeYear.equalsIgnoreCase("sophomore")){ gradeYearEntered = false; return 2; }
            else if (this.gradeYear.equalsIgnoreCase("junior")){ gradeYearEntered = false; return 3; }
            else if (this.gradeYear.equalsIgnoreCase("senior")){ gradeYearEntered = false; return 4; }
            else {System.out.println("Error: please try again."); }
        } return 0;
    }

    private String setStudentId(){
        return this.firstIDNumber + "" + id;
    }

    public String getStudentId() {
        return this.studentId;
    }


    // Students can enroll in History / mathematics / english / chemistry / computer science & Make a tuition bill, each course cost 600$
    public void enrollCourses(){
        System.out.println(this.coursesAvailable);
        for (int i = this.numberOfMaxCourses; i>0; i--){
            System.out.print("Enter a course to enroll ('Q' to quit): ");
            String entry = this.in.nextLine();
            if (entry.toLowerCase().equals("q")){ i = 0; }
            else {
                this.courses += entry + " / ";
                this.balance += costOfCourse; }
        }
    }

    // Student should be able to view their balance
    public void showBalance(){
        System.out.println("Your remaining balance to pay is: $" + this.balance);
    }

    public void showId(){
        System.out.println("STUDENT ID: " + this.studentId);
    }

    // Students should be able to pay their tuition
    public int payTuition(){
        showBalance();
        System.out.print("How much do you want to pay? ");
        int payment = this.in.nextInt();
        this.balance -= payment;
        if (this.balance != 0){ showBalance(); }
        else if (this.balance == 0){System.out.println("You have paid all your tuition fees"); }
        return this.balance;
    }
    // Show student status -> name / id / courses / balance
    public void showStatus(){
        System.out.println("NAME: " + firstName.toUpperCase() + " " + this.lastName.toUpperCase());
        System.out.println("STUDENT ID: " + this.studentId);
        System.out.println("COURSES: " + this.courses);
        System.out.println("TUITION FEES: " + this.balance);
    }



}
