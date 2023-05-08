package pl.edu.agh.qa.library;

import pl.edu.agh.qa.library.items.Book;
import pl.edu.agh.qa.library.items.Item;
import pl.edu.agh.qa.library.items.Magazine;
import pl.edu.agh.qa.library.users.Lecturer;
import pl.edu.agh.qa.library.users.Student;
import pl.edu.agh.qa.library.users.User;

import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {
        Library lib = new Library();
        lib.addUserToLibrary(new Student("Kuba", "Buba"), new Lecturer("wacek", "placek"));
        lib.addUserToLibrary(new Student("Kuba", "Buba"), new Lecturer("wacek", "placek"));
        lib.addUserToLibrary(new Student("jan", "matejko"), new Lecturer("henryk", "siekiewicz"));
//        lib.printListOfUsers();

        lib.addItemToLibrary(new Book("t","t"), new Book("test","t"));
        lib.addItemToLibrary(new Book("test","t"), new Book("test","t"));
        lib.addItemToLibrary(new Book("t","t"), new Book("a","abcd"));
        lib.addItemToLibrary(new Book("test","t"), new Magazine("a","t"));
        lib.addItemToLibrary(new Book("test","t"), new Magazine("a","t"));
        lib.addItemToLibrary(new Book("test12","t"), new Magazine("a1","t"));
        lib.printListOfBooks();
//        lib.printListOfMagazines();

        List<User> userList = lib.getUserList();
        List<Item> itemList = lib.getItemList();

        System.out.println(itemList.get(1).availableItems);
        System.out.println(userList.get(0).alreadyBorrowed);

        lib.rentItemToUser(itemList.get(1), userList.get(0));
        System.out.println(itemList.get(1).availableItems);
        System.out.println(userList.get(0).alreadyBorrowed);

        lib.rentItemToUser(itemList.get(1), userList.get(0));
        System.out.println(itemList.get(1).availableItems);
        System.out.println(userList.get(0).alreadyBorrowed);

        lib.rentItemToUser(itemList.get(1), userList.get(0));
        System.out.println(itemList.get(1).availableItems);
        System.out.println(userList.get(0).alreadyBorrowed);

        lib.rentItemToUser(itemList.get(1), userList.get(0));
        System.out.println(itemList.get(1).availableItems);
        System.out.println(userList.get(0).alreadyBorrowed);

        lib.rentItemToUser(itemList.get(1), userList.get(0));
        System.out.println(itemList.get(1).availableItems);
        System.out.println(userList.get(0).alreadyBorrowed);

        lib.printListOfBooks();
    }
}