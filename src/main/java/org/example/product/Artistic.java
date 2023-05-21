package org.example.product;

import java.util.Date;

public class Artistic extends Book {
    public Artistic(String title, String name, String author, Date date){
        super(title,name,author,date);
    }
    @Override
    public String reading() {
        return "Artistic Book";
    }
}
