package pl.edu.agh.qa.library;

import pl.edu.agh.qa.library.items.Book;
import pl.edu.agh.qa.library.items.Magazine;

public class test {

    public static void main(String[] args) {
        Library lib = new Library();
        lib.addItemToLibrary(new Book("t","t"), new Book("test","t"));
        lib.addItemToLibrary(new Book("test","t"), new Book("test","t"));
        lib.addItemToLibrary(new Book("t","t"), new Book("a","abcd"));
        lib.addItemToLibrary(new Book("test","t"), new Magazine("a","t"));
        lib.addItemToLibrary(new Book("test","t"), new Magazine("a","t"));
        lib.printListOfBooks();
        lib.printListOfMagazines();
    }
}