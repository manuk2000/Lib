package org.example.librarian;

import org.example.lib.Lib;
import org.example.product.Artistic;
import org.example.product.Book;
import org.example.product.ModernBook;

import java.util.Date;
import java.util.Optional;

public class Librarian {
    private String name;
    private String contact;
    private Lib lib;

    public Librarian(String name, String contact, Lib lib) {
        this.name = name;
        this.contact = contact;
        this.lib = lib;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public Lib getLib() {
        return lib;
    }

    public void takeBook(String title, String name, String author, Date date , String engre){
        Book b = switch (engre.toLowerCase()){
            case "artistic" -> new Artistic(title,name,author,date);
            default -> new ModernBook(title,name,author,date);
        };
        takeBook(b);
    }
    public void takeBook(Book b){
        lib.addBook(b);
    }
    public Book giveBook(String title, String name, String author, Date date ,String engre){
        Book b = switch (engre.toLowerCase()){
            case "artistic" -> new Artistic(title,name,author,date);
            default -> new ModernBook(title,name,author,date);
        };
        return giveBook(b);
    }
    public Book giveBook(Book b){
        return lib.getBook(b).get();
    }}
