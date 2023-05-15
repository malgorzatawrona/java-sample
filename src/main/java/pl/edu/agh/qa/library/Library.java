package pl.edu.agh.qa.library;
import pl.edu.agh.qa.library.items.Book;
import pl.edu.agh.qa.library.items.Item;
import pl.edu.agh.qa.library.items.Magazine;
import pl.edu.agh.qa.library.items.RentStatus;
import pl.edu.agh.qa.library.users.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Library {

    List<User> userList = new ArrayList<>();
    List<Item> itemList = new ArrayList<>();
    List<RentStatus> rentList = new ArrayList<>();

    public void addItemToLibrary(Item... items) {
        for(Item item : items) {
            boolean itemExist = this.checkIfItemExistInLibrary(item);
            if(!itemExist)
                itemList.add(item);
        }
    }

    public void addUserToLibrary(User... users) {
        userList.addAll(Arrays.asList(users));
    }

    public boolean rentItemToUser(Item item, User user) {
        if(userList.contains(user) && itemList.contains(item)) {
            if (item.availableItems > 0 && user.alreadyBorrowed < user.limit) {
                this.addUserToList(user, item);
                item.availableItems--;
                user.alreadyBorrowed++;
                return true;
            }
        }
        return false;
    }

    public void importItemsFromFile(String csvFile) throws FileNotFoundException {
        File file = new File(csvFile);
        Scanner inputFile = new Scanner(file);

        while (inputFile.hasNext()){
            String line = inputFile.nextLine();
            String[] lineAsArray = line.split(";");
            boolean itemExistOnList = false;

            for (Item it : itemList) {
                itemExistOnList = this.assignMultipleQuantityToItemList(it, lineAsArray);
            }
            if(!itemExistOnList){
                this.addMultipleItemsToLibrary(lineAsArray);
            }
        }
        inputFile.close();
    }

    public void exportUsersWithItemsToFile(String csvFile) throws FileNotFoundException {
        PrintWriter outputFile = new PrintWriter(csvFile);
        for (RentStatus ren: rentList){
            outputFile.println(this.saveLineToFile(ren));
        }
        outputFile.close();
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

    public List<Item> getItemList() {
        return itemList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public boolean checkIfItemExistInLibrary(Item item){
        for (Item itElement : itemList){
            if (itElement instanceof Book && item instanceof Book) {
                if (((Book) item).equal((Book) itElement)) {
                    itElement.availableItems += 1;
                    itElement.allElements += 1;
                    return true;
                }
            }
            else if (itElement instanceof Magazine && item instanceof Magazine) {
                if (((Magazine) item).equal((Magazine) itElement)) {
                    itElement.availableItems += 1;
                    itElement.allElements += 1;
                    return true;
                }
            }
        }
        return false;
    }

    public void addUserToList(User u, Item it){
        boolean userExist = false;
        for(RentStatus elem: rentList){
            if(elem.userId == u.userId){
                elem.rentBook(it);
                userExist = true;
            }
        }
        if (!userExist){
            rentList.add(new RentStatus(u.userId, it));
        }}

    public boolean assignMultipleQuantityToItemList(Item it, String[] lineAsArray){
        if (it instanceof Book && Objects.equals(lineAsArray[3], "B")) {
            if (new Book(lineAsArray[1], lineAsArray[0]).equal((Book) it)) {
                it.availableItems += Integer.parseInt(lineAsArray[2]);
                it.allElements += Integer.parseInt(lineAsArray[2]);
                return true;
            }
        } else if (it instanceof Magazine && Objects.equals(lineAsArray[3], "M")) {
            if (new Magazine(lineAsArray[1], lineAsArray[0]).equal((Magazine) it)) {
                it.availableItems += Integer.parseInt(lineAsArray[2]);
                it.allElements += Integer.parseInt(lineAsArray[2]);
                return true;
            }
        }
        return false;
    }

    public void addMultipleItemsToLibrary(String[] lineAsArray){
            if(Objects.equals(lineAsArray[3], "M"))
                itemList.add(new Magazine(lineAsArray[1], lineAsArray[0]));
            else
                itemList.add(new Book(lineAsArray[1], lineAsArray[0]));
            itemList.get(itemList.size() -1).availableItems = Integer.parseInt(lineAsArray[2]);
            itemList.get(itemList.size() -1).allElements = Integer.parseInt(lineAsArray[2]);
    }

    public String saveLineToFile(RentStatus ren){
        StringBuilder listOfBooks = new StringBuilder("ID");
        listOfBooks.append(ren.userId).append('[');
        for(Item i : ren.itemList){
            listOfBooks.append(i.title).append('-');
            if(i instanceof Book)
                listOfBooks.append(((Book) i).author);
            else if(i instanceof Magazine)
                listOfBooks.append(((Magazine) i).number);
            listOfBooks.append(';');
        }
        return listOfBooks.substring(0, listOfBooks.length() - 1) + "]";
    }
}
