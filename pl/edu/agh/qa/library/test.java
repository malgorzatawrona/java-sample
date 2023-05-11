package pl.edu.agh.qa.library;

import pl.edu.agh.qa.library.items.Book;
import pl.edu.agh.qa.library.items.Item;
import pl.edu.agh.qa.library.items.Magazine;
import pl.edu.agh.qa.library.users.Lecturer;
import pl.edu.agh.qa.library.users.Student;
import pl.edu.agh.qa.library.users.User;

import java.io.FileNotFoundException;
import java.util.List;

public class test {

    public static void main(String[] args) throws FileNotFoundException {
        Library lib = new Library();
        lib.addUserToLibrary(new Student("Gosia", "Wrona"), new Lecturer("Grzegorz", "Szczutkowski"));
        lib.addUserToLibrary(new Student("Adam", "Nowak"));
        lib.addUserToLibrary(new Lecturer("Kamil", "Marek"));
        lib.printListOfUsers();

        lib.addItemToLibrary(new Book("H. Sienkiewicz","Ogniem i mieczem"));
        lib.addItemToLibrary(new Book("H. Sienkiewicz","W pustyni i w puszczy"), new Book("H. Sienkiewicz","W pustyni i w puszczy"));
        lib.addItemToLibrary(new Book("R. Ludlum","Tożsamość Bourne’a"), new Book("H. Sienkiewicz","W pustyni i w puszczy"));
        lib.addItemToLibrary(new Book("H. Sienkiewicz","W pustyni i w puszczy"), new Magazine("04-1993","nasz nowy dom"));
        lib.addItemToLibrary(new Book("R. Ludlum","Tożsamość Bourne’a"), new Magazine("06-2005","test"));
        lib.addItemToLibrary(new Magazine("02-2022","nasz nowy dom"));
        lib.printListOfBooks();
        System.out.println("**********************************");
        lib.printListOfMagazines();
        System.out.println("///////////////////////////////////");

        List<User> userList = lib.getUserList();
        List<Item> itemList = lib.getItemList();

        System.out.println(itemList.get(1).availableItems);
        System.out.println(userList.get(0).alreadyBorrowed);

        lib.rentItemToUser(itemList.get(2), userList.get(0));
        System.out.println(itemList.get(2).availableItems);
        System.out.println(userList.get(0).alreadyBorrowed);

        lib.rentItemToUser(itemList.get(1), userList.get(0));
        System.out.println(itemList.get(1).availableItems);
        System.out.println(userList.get(0).alreadyBorrowed);

        lib.rentItemToUser(itemList.get(2), userList.get(0));
        System.out.println(itemList.get(2).availableItems);
        System.out.println(userList.get(0).alreadyBorrowed);

        boolean a = lib.rentItemToUser(itemList.get(2), userList.get(0));
        System.out.println(a);
        System.out.println(itemList.get(2).availableItems);
        System.out.println(userList.get(0).alreadyBorrowed);

        boolean b = lib.rentItemToUser(itemList.get(2), userList.get(0));
        System.out.println(b);
        System.out.println(itemList.get(2).availableItems);
        System.out.println(userList.get(0).alreadyBorrowed);

        lib.rentItemToUser(itemList.get(3), userList.get(2));

        lib.importItemsFromFile("C:\\Users\\Gosia i Szymon\\Desktop\\test\\test.txt");
        lib.printListOfBooks();
        System.out.println("**********************************");
        lib.printListOfMagazines();

        lib.exportUsersWithItemsToFile("C:\\Users\\Gosia i Szymon\\Desktop\\test\\test1.txt");
    }
}