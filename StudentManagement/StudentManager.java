package Edu_Bridge.StudentManagement;

import java.util.*;

public class StudentManager {
    List<StudentImp> studentList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addStudent() {
        System.out.println("Enter ID:");
        int id = sc.nextInt();

        System.out.println("Enter Name:");
        String name = sc.next();

        System.out.println("Enter Age:");
        int age = sc.nextInt();

        System.out.println("Enter Course:");
        String course = sc.next();

        System.out.println("Enter Email:");
        String email = sc.next();

        StudentImp student = new StudentImp(id, name, age, course, email);
        studentList.add(student);

        System.out.println(" Student added successfully!");
    }

    public void viewAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (StudentImp s : studentList) {
                System.out.println(s);
            }
        }
    }

    public void searchStudent() {
        System.out.println("Search by:");
        System.out.println("1. Student ID");
        System.out.println("2. Student Name");
        System.out.print("Enter your choice: ");
        int searchOption = sc.nextInt();
        sc.nextLine(); // clear the buffer

        boolean found = false;

        switch (searchOption) {
            case 1:
                System.out.print("Enter student ID to search: ");
                int searchId = sc.nextInt();
                for (StudentImp s : studentList) {
                    if (s.getId() == searchId) {
                        System.out.println(" Student found: " + s);
                        found = true;
                        break;
                    }
                }
                break;

            case 2:
                System.out.print("Enter student Name to search: ");
                String searchName = sc.nextLine();
                for (StudentImp s : studentList) {
                    if (s.getName().equalsIgnoreCase(searchName)) {
                        System.out.println(" Student found: " + s.getId());
                        found = true;
                    }
                }
                break;

            default:
                System.out.println(" Invalid search option.");
                return;
        }

        if (!found) {
            System.out.println(" Student not found.");
        }
    }


    public void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int updateId = sc.nextInt();

        for (StudentImp s : studentList) {
            if (s.getId() == updateId) {
                System.out.println("Editing student: " + s);

                System.out.print("New Name: ");
                s.name = sc.nextLine();

                System.out.print("New Age: ");
                s.age = sc.nextInt();

                System.out.print("New Course: ");
                s.course = sc.next();

                System.out.print("New Email: ");
                s.email = sc.next();

                System.out.println(" Student updated successfully!");
                return;
            }
        }

        System.out.println(" Student with ID " + updateId + " not found.");
    }

    public void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int deleteId = sc.nextInt();

        Iterator<StudentImp> iterator = studentList.iterator();
        boolean removed = false;

        while (iterator.hasNext()) {
            StudentImp s = iterator.next();
            if (s.getId() == deleteId) {
                iterator.remove();
                removed = true;
                System.out.println(" Student deleted successfully!");
                break;
            }
        }

        if (!removed) {
            System.out.println(" Student with ID " + deleteId + " not found.");
        }
    }


    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);
//        sc.nextLine();

        while (true) {
            System.out.println("\n------- Welcome to Student Management System -------");
            System.out.println("Select an option:");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    manager.addStudent();
                    break;
                case 2:
                    manager.viewAllStudents();
                    break;
                case 3:
                    manager.searchStudent();
                    break;
                case 4:
                    manager.updateStudent();
                    break;
                case 5:
                    manager.deleteStudent();
                    break;
                case 6:
                    System.out.println(" Thank you for using the Student Management System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println(" Invalid option. Please try again.");
            }
        }
    }

}
