package pl.edu.agh.qa.library;
import pl.edu.agh.qa.library.items.Book;
import pl.edu.agh.qa.library.items.Item;
import pl.edu.agh.qa.library.items.Magazine;
import pl.edu.agh.qa.library.users.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Library {

    List<User> userList = new ArrayList<>();
    List<Item> itemList = new ArrayList<>();


    public void addItemToLibrary(Item... items) {
        for(Item item : items) {
            if(itemList.size() == 0){
                itemList.add(new Book("",""));
                itemList.add(new Magazine("",""));
            }
            boolean exist = false;
            for (Item it : itemList) {
                if (it instanceof Book && item instanceof Book) {
                    if (((Book) item).equal((Book) it)) {
                        it.availableItems += 1;
                        it.allElements += 1;
                        exist = true;
                    }
                } else if (it instanceof Magazine && item instanceof Magazine) {
                    if (((Magazine) item).equal((Magazine) it)) {
                        it.availableItems += 1;
                        it.allElements += 1;
                        exist = true;
                    }
                }
            }
            if(!exist)
                itemList.add(item);
        }
    }

    public void addUserToLibrary(User... users) {
        userList.addAll(Arrays.asList(users));
    }

    public boolean rentItemToUser(Item item, User user) {
        if(itemList.contains(item) && userList.contains(user)) {
            Item it = itemList.get(itemList.indexOf(item));
            User u = userList.get(userList.indexOf(user));
            if (it.availableItems > 0  && u.alreadyBorrowed < u.limit) {
                it.availableItems--;
                u.alreadyBorrowed++;
                return true;
            }
        }
        return false;
    }

    public void importItemsFromFile(String csvFile) {
    }

    public void exportUsersWithItemsToFile(String csvFile) {
    }

    public void printListOfMagazines() {
        for(Item item : itemList){
            if (item instanceof Magazine) {
                System.out.println(((Magazine) item).print());
            }
        }
    }

    public void printListOfBooks() {
        for(Item item : itemList){
            if (item instanceof Book) {
                System.out.println(((Book) item).print());
            }
        }
    }

    public void printListOfUsers() {
        for(User user : userList) {
            System.out.println(user.toString());
        }
    }
}
