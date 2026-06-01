package subjectmanager;

import java.util.ArrayList;
import java.util.List;

public class SubjectManager<T extends Subject> {
    private List<T> subjects;

    public SubjectManager() {
        this.subjects = new ArrayList<>();
    }

    public void addSubject(T subject) {
        subjects.add(subject);
        System.out.println("Subject added successfully.");
    }

    public void removeSubject(String code) {
        T subjectToRemove = null;
        for (T subject : subjects) {
            if (subject.getCode().equals(code)) {
                subjectToRemove = subject;
                break;
            }
        }

        if (subjectToRemove != null) {
            subjects.remove(subjectToRemove);
            System.out.println("Subject removed successfully.");
        } else {
            System.out.println("Error: Subject not found to remove.");
        }
    }

    public void displaySubjects() {
        if (subjects.isEmpty()) {
            System.out.println("Subject list is empty.");
            return;
        }
        System.out.println("Subject list:");
        for (T subject : subjects) {
            System.out.println(subject);
        }
    }

    public void searchByName(String name) {
        boolean found = false;
        for (T subject : subjects) {
            if (subject.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println("Subject found: " + subject);
                found = true;
            }
        }
        if (!found) {
            System.out.println("There is no suitable subject.");
        }
    }

    public void filterByCredits(int minCredits) {
        System.out.println("Subjects with credits greater than " + minCredits + ":");
        boolean found = false;
        for (T subject : subjects) {
            if (subject.getCredits() > minCredits) {
                System.out.println(subject);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching subject found.");
        }
    }
}
