package pl.edu.agh.qa.library.items;

public abstract class Item {
    public String title;
    public int allElements = 0;
    public int availableItems = 0;


    public Item(String title) {
        this.title = title;
        this.availableItems = 1;
        this.allElements = 1;
    }

}
