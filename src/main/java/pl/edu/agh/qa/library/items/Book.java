package pl.edu.agh.qa.library.items;

public class Book extends Item {
    public String author;

    public Book(String author, String title) {
        super(title);
        this.author = author;
    }

    public boolean equal(Book obj){
        return author.equals(obj.author) && title.equals(obj.title);
    }

    public String print() {
        return title + ";" + author + ";" + allElements + ";" + availableItems;
    };
}
