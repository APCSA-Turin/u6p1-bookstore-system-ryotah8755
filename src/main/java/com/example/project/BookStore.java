package com.example.project;


public class BookStore{
    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users)
    private Book[] books;
    private User[] users = new User[10];
    private int amtOfBooks;


    //requires 1 empty constructor
    public BookStore() {}


    //returns users at bookstore
    public User[] getUsers() {return users;}


    //sets users at bookstore to new users
    public void setUsers(User[] newUsers) {
        users = newUsers;
    }


    //returns books at bookstore
    public Book[] getBooks() {return books;}


    //adds user by replacing first null found
    public void addUser(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                i = users.length;// Exit loop
            }
        }
    }


    //removes user by checking id of users
    public void removeUser(User user) {
        for (int i = 0; i < users.length; i++) {
            if (user.getId() == users[i].getId()) {
                users[i] = null;// Remove the user
                i = users.length;// Exit loop
            }
        }
        consolidateUsers();// Shift null values to the end
    }


    //pushes all null values behind users in array
    public void consolidateUsers() {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) { // Find null slots
                for (int j = i; j < users.length; j++) {
                    if (users[j] != null) {
                        users[i] = users[j];
                        users[j] = null;// Set old position to null
                        j = users.length;
                    }
                }
            }
        }
    }


    //adds book to books array
    public void addBook(Book book) {
        if (amtOfBooks == 0) {
            books = new Book[1];
            books[0] = book;
            amtOfBooks++;
        } else {
            Book[] temp = new Book[amtOfBooks + 1];
            for (int i = 0; i < amtOfBooks; i++) {
                temp[i] = books[i]; // Copy old books
            }
            temp[temp.length - 1] = book;
            books = temp;// Update reference
            amtOfBooks++;
        }
    }


    //inserts book at given index in books array
    public void insertBook(Book book, int index) {
        Book[] temp = new Book[books.length + 1]; // Create a larger array
        for (int i = 0; i < index; i++) {
            temp[i] = books[i];
        }
        temp[index] = book;
        for (int i = index + 1; i < temp.length; i++) {
            temp[i] = books[i - 1];
        }
        books = temp;
    }


    //removes quantity from book and if there are no more copies left, removes book from the store
    public void removeBook(Book book) {
        Book[] temp = new Book[books.length - 1];
        int index = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getIsbn().equals(book.getIsbn())) {
                index = i;
                books[i].setQuantity(books[i].getQuantity() - 1);// Decrease quantity
            }
            if (books[i].getQuantity() == 0) {
                for (int j = 0; j < index; j++) {
                    temp[j] = books[j];
                }
                for (int k = index + 1; k < books.length; k++) {
                    temp[k - 1] = books[k];
                }
                books = temp;
            }
        }
    }
   
    //returns information of all books in store
    public String bookStoreBookInfo() {
        String info = "";
        for (int i =  0; i < books.length; i++) {
            info += (i + 1) + ". " + books[i].bookInfo() + "\n";
        }
        return info;
    }


    //returns information of all registered users
    public String bookStoreUserInfo() {
        String info = "";
        for (int i =  0; i < users.length; i++) {
            if (users[i] != null) {
                info += (i + 1) + ". " + users[i].userInfo() + "\n";
            }
        }
        return info;
    }


}