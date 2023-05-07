package pl.edu.agh.qa.library.items;

public class Magazine extends Item {
    String number;

    public Magazine(String number, String title) {
        super(title);
        this.number = number;
    }

    public String print() {
        return title + ";" + number + ";" + allElements + ";" + availableItems;
    };
}
