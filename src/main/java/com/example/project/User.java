package com.example.project;

public class User{
    //requires 3 private attributes String name, String Id, Book book that is initialized to empty
    private String name;
    private String Id;
    private Book[]book;
    //requires 1 contructor with two parameters that will initialize the name and id
    public User(String name, String Id) { 
        this.name = name;
        this.Id = Id;
        this.book = new Book[5];
    }
 
    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getId() {
        return Id;
    }

    public void setId(String newId) {
        Id = newId;
    }

    public Book[] getBooks() {
        return book;
    }

    public void setBooks(Book newBook[]) {
        book = newBook;
    }

    public String bookListInfo() {
        String temp = "\nBooks: \n";
    
        for (int i = 0; i < book.length; i++) {
            if (book[i] != null) {
                temp += book[i].bookInfo() + "\n";
            } else {
                temp += "empty\n";
            }
        }
    
        return temp;
    }

    public String userInfo(){
        return "Name: "+ name + "\nId: " + Id + bookListInfo();
    } //returns  "Name: []\nID: []\nBooks:\n[]"
       
}