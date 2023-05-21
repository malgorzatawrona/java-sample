package pl.edu.agh.qa.library;

import pl.edu.agh.qa.library.items.Book;
import pl.edu.agh.qa.library.items.Item;
import pl.edu.agh.qa.library.items.Magazine;
import pl.edu.agh.qa.library.users.Lecturer;
import pl.edu.agh.qa.library.users.Student;
import pl.edu.agh.qa.library.users.User;

import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.List;

public class test {

    public static void main(String[] args) throws FileNotFoundException {
        Library lib = new Library();
//
//        Student s = new Student("Gosia", "Wrona");
//        Lecturer l = new Lecturer("Grzegorz", "Szczutkowski");
//        lib.addUserToLibrary(s, l);
//        lib.addUserToLibrary(new Student("Adam", "Nowak"));
//        lib.addUserToLibrary(new Lecturer("Kamil", "Marek"));
//        lib.printListOfUsers();
//
//        Book b = new Book("H. Sienkiewicz","Ogniem i mieczem");
//        Book b2 = new Book("H. Sienkiewicz","W pustyni i w puszczy");
//        Magazine m1 = new Magazine("02-2022", "nasz nowy dom");
//        lib.addItemToLibrary(b);
//        lib.addItemToLibrary(b2, b2, b2, b2, b,b,b,b,b, new Book("H. Sienkiewicz","W pustyni i w puszczy"));
//        lib.addItemToLibrary(new Book("R. Ludlum","Tożsamość Bourne’a"),b2);
//        lib.addItemToLibrary(b2, new Magazine("04-1993","nasz nowy dom"));
//        lib.addItemToLibrary(new Book("R. Ludlum","Tożsamość Bourne’a"), new Magazine("06-2005","test"));
//        lib.addItemToLibrary(m1, m1, m1, m1, m1, m1, m1, new Magazine("02-2022","nasz nowy dom"));
//        lib.printListOfBooks();
//        lib.printListOfMagazines();
//
//        List<User> userList = lib.getUserList();
//        List<Item> itemList = lib.getItemList();


//        import z pliku i wypożyczenie
        Student s = new Student("Gosia", "Wrona");
        lib.addUserToLibrary(s);
        Book b = new Book("H. Sienkiewicz","Ogniem i mieczem");

        Book b4 = new Book("O.Tkarczuk", "Bieguni");
        lib.addItemToLibrary(b4,b4);
        System.out.println(lib.rentItemToUser(b4,s));

        System.out.println(lib.rentItemToUser(b4,s));

        lib.importItemsFromFile("C:\\Users\\Gosia i Szymon\\Desktop\\test\\test.txt");

        System.out.println(lib.rentItemToUser(b, s));

//
//        System.out.println(itemList.get(1).availableItems);
//        System.out.println(userList.get(0).alreadyBorrowed);
//
//        lib.rentItemToUser(itemList.get(2), userList.get(0));
//        System.out.println(itemList.get(2).availableItems);
//        System.out.println(userList.get(0).alreadyBorrowed);
//
//        lib.rentItemToUser(b,s);
//        System.out.println(itemList.get(1).availableItems);
//        System.out.println(userList.get(0).alreadyBorrowed);
//
//        lib.rentItemToUser(itemList.get(2), userList.get(0));
//        System.out.println(itemList.get(2).availableItems);
//        System.out.println(userList.get(0).alreadyBorrowed);
//
//        lib.rentItemToUser(itemList.get(2), userList.get(0));
//        System.out.println(itemList.get(2).availableItems);
//        System.out.println(userList.get(0).alreadyBorrowed);
//
//        lib.rentItemToUser(itemList.get(2), userList.get(0));
//        System.out.println(itemList.get(2).availableItems);
//        System.out.println(userList.get(0).alreadyBorrowed);
//
//        lib.rentItemToUser(itemList.get(3), userList.get(2));
//
//        lib.importItemsFromFile("C:\\Users\\Gosia i Szymon\\Desktop\\test\\test.txt");
//        lib.printListOfBooks();
//        lib.printListOfMagazines();
//
//        lib.exportUsersWithItemsToFile("C:\\Users\\Gosia i Szymon\\Desktop\\test\\test1.txt");
//
//        lib.rentItemToUser(itemList.get(2), userList.get(0));
//        System.out.println(itemList.get(2).availableItems);
//        System.out.println(userList.get(0).alreadyBorrowed);
//        lib.rentItemToUser(itemList.get(2), userList.get(0));
//        System.out.println(itemList.get(2).availableItems);
//        System.out.println(userList.get(0).alreadyBorrowed);
//        lib.printListOfBooks();
//        lib.exportUsersWithItemsToFile("C:\\Users\\Gosia i Szymon\\Desktop\\test\\test1.txt");
    }
}