package subjectmanager;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SubjectManager<Subject> manager = new SubjectManager<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Select option:");
            System.out.println("1. Show subject list");
            System.out.println("2. Add subject");
            System.out.println("3. Delete subject by code");
            System.out.println("4. Search subject by name");
            System.out.println("5. Filter subject by credits (>3)");
            System.out.println("6. Exit");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:
                    manager.displaySubjects();
                    break;
                case 2:
                    addSubject();
                    break;
                case 3:
                    deleteSubject();
                    break;
                case 4:
                    searchByName();
                    break;
                case 5:
                    manager.filterByCredits(3);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addSubject() {
        System.out.println("Enter subject code:");
        String code = scanner.nextLine();

        System.out.println("Enter subject name:");
        String name = scanner.nextLine();

        int credits = -1;
        while (true) {
            try {
                System.out.println("Enter credits:");
                credits = Integer.parseInt(scanner.nextLine());
                if (credits < 0 || credits > 10) {
                    throw new IllegalArgumentException("Credits must be between 0 and 10.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid format. Please enter a number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("Enter start date (dd/MM/yyyy):");
        String startDate = scanner.nextLine();

        manager.addSubject(new Subject(code, name, credits, startDate));
    }

    private static void deleteSubject() {
        System.out.println("Enter subject code to delete:");
        String code = scanner.nextLine();
        manager.removeSubject(code);
    }

    private static void searchByName() {
        System.out.println("Enter subject name to search:");
        String name = scanner.nextLine();
        manager.searchByName(name);
    }
}
