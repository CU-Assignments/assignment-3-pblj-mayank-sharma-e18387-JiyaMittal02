import java.util.HashMap;
import java.util.Scanner;

// Custom Exception for Course Full
class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

// Custom Exception for Missing Prerequisite
class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

// University Enrollment System
class University {
    private HashMap<String, Integer> courses = new HashMap<>();
    private HashMap<String, String> prerequisites = new HashMap<>();

    public University() {
        // Course seats
        courses.put("Advanced Java", 1); // Only 1 seat left
        courses.put("Core Java", 2);

        // Prerequisites
        prerequisites.put("Advanced Java", "Core Java");
    }

    public void enrollStudent(String course, boolean hasPrerequisite) throws CourseFullException, PrerequisiteNotMetException {
        if (!courses.containsKey(course)) {
            throw new IllegalArgumentException("Error: Course not found.");
        }

        if (prerequisites.containsKey(course) && !hasPrerequisite) {
            throw new PrerequisiteNotMetException("Error: Prerequisite not completed.");
        }

        if (courses.get(course) == 0) {
            throw new CourseFullException("Error: Course is full.");
        }

        courses.put(course, courses.get(course) - 1);
        System.out.println("Enrollment Successful in " + course);
    }
}

public class UniversityEnrollmentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        University university = new University();

        System.out.print("Enroll in Course: ");
        String course = scanner.nextLine();
        System.out.print("Have you completed the prerequisite? (yes/no): ");
        boolean hasPrerequisite = scanner.nextLine().equalsIgnoreCase("yes");

        try {
            university.enrollStudent(course, hasPrerequisite);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
