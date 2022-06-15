import java.util.Scanner;

public class Course {
    String courseName;
    String courseCode;

    public Course() {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.println("Enter new course name:");
        courseName = myObj.nextLine(); // Read user input
        System.out.println("Enter new course code:");
        courseCode = myObj.nextLine(); // Read user input
    }
    public void printCourse() {
        System.out.println("Course name:" + courseName);
        System.out.println("Course code:" + courseCode);
    }
}