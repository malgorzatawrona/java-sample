package pl.edu.agh.qa.library.items;

public abstract class Item {
    public String title;
    public int allElements;
    public int availableItems;


    public Item(String title) {
        this.title = title;
        this.availableItems = 1;
        this.allElements = 1;
    }

}
