package pl.edu.agh.qa.library.items;

public class Book extends Item {
    String author;

    public Book(String author, String title) {
        super(title);
        this.author = author;
    }

    public String print() {
        return title + ";" + author + ";" + allElements + ";" + availableItems;
    };
}
