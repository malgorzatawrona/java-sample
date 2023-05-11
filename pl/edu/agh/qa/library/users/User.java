package pl.edu.agh.qa.library.users;

public abstract class User {
    protected String firstname;
    protected String surname;
    protected String userType;
    public int userId;
    private static int actualId = 1567;
    public int limit = 0;
    public int alreadyBorrowed = 0;

    public User(String firstname, String surname, String userType, int limit){
        this.firstname = firstname;
        this.surname = surname;
        this.userType = userType;
        this.limit = limit;
        this.userId = actualId;
        actualId++;
    }

    @Override
    public String toString() {
        return firstname + ";" + surname + ";" + userId + ";" + userType;
    }

}
