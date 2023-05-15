package pl.edu.agh.qa.library.users;

public class Lecturer extends User {
    public Lecturer(String firstName, String lastName) {
        super(firstName, lastName, "L", 10);
    }

}
