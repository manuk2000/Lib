package org.example.lib;

import org.example.product.Artistic;
import org.example.product.Book;
import org.example.product.ModernBook;

import java.util.*;

public  class Lib {

    private Map<Book, Integer> lib = new HashMap<>();
    public void addBook(String title, String name, String author, Date date ,String engre){
        Book b = switch (engre.toLowerCase()){
            case "artistic" -> new Artistic(title,name,author,date);
            default -> new ModernBook(title,name,author,date);
        };
        addBook(b);
    }
    public void addBook(Book b){
        Integer count = lib.putIfAbsent(b,  1);
        if( count != null){
            lib.put(b , count + 1);
        }
    }
    public Optional<Book> getBook(Book b){
        Integer count = lib.get(b);
        if( count == 1){
            lib.remove(b);
        }else if(count > 1){
            lib.put(b , lib.get(b) - 1);
        }
        return Optional.ofNullable( b );
    }
    public Optional<Book> getBook(String title, String name, String author, Date date ,String engre){
        Book b = switch (engre.toLowerCase()){
            case "artistic" -> new Artistic(title,name,author,date);
            default -> new ModernBook(title,name,author,date);
        };
        return getBook(b);
    }

    @Override
    public String toString() {
        String s = "";
        for (Book b : lib.keySet()) {
            s += b.toString() + ", count = " + lib.get(b).toString() + "}";
        }
        return s;
    }
}
