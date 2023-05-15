package pl.edu.agh.qa.library.items;

import java.util.ArrayList;
import java.util.List;

public class RentStatus {

    public int userId;

    public List<Item> itemList = new ArrayList<>();

    public RentStatus(int id, Item item){
        userId = id;
        itemList.add(item);
    }

    public void rentBook(Item item){
        itemList.add(item);
    }
}
