package org.example.borrowers;

import org.example.lib.Lib;
import org.example.librarian.Librarian;
import org.example.product.Artistic;
import org.example.product.Book;
import org.example.product.ModernBook;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Borrowers {
    private String name;
    private String contact;
    private Librarian librarina;
    private Map<Book , Integer> myLib = new HashMap<>();


    public Borrowers(String name, String contact, Librarian librarina) {
        this.name = name;
        this.contact = contact;
        this.librarina = librarina;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public Librarian getLibrarina() {
        return librarina;
    }


    public Book byBook(String title, String name, String author, Date date , String engre){
        Book b = switch (engre.toLowerCase()){
            case "artistic" -> new Artistic(title,name,author,date);
            default -> new ModernBook(title,name,author,date);
        };
        return byBook(b);
    }
    public Book byBook(Book b){
        Book book = librarina.giveBook(b);
        if (book == null){
            System.out.println("The book was not found");
            return null;
        }
        myLib.put( book ,  myLib.get(b) == null ? 1 :myLib.get(b) +  1) ;
        return b;
    }
    public void returnBook(String title, String name, String author, Date date ,String engre){
        Book b = switch (engre.toLowerCase()){
            case "artistic" -> new Artistic(title,name,author,date);
            default -> new ModernBook(title,name,author,date);
        };
        returnBook(b);
    }
    public void returnBook(Book b){
         librarina.takeBook(b);
    }
    @Override
    public String toString() {
        String s = "";
        for (Book b : myLib.keySet()) {
            s += b.toString() + ", count = " + myLib.get(b).toString() + "}";
        }
        return s;
    }
}
